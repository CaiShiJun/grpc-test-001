package com.tingyun.wade.server.routeguide;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by tingyun on 2018/1/29.
 */
//@Service
public class RouteGuideService {

    private static final Logger logger = Logger.getLogger(RouteGuideService.class.getName());

    private final int port;
    private final Server server;


    public RouteGuideService(int port) throws IOException {
        this(port, RouteGuideUtil.getDefaultFeaturesFile());
    }

    public RouteGuideService(int port, URL defaultFeaturesFile) throws IOException {
        this(ServerBuilder.forPort(port), port, RouteGuideUtil.parseFeatures(defaultFeaturesFile));
    }

    public RouteGuideService(ServerBuilder<?> serverBuilder, int port, List<Feature> features) {
        this.port = port;
        server = serverBuilder.addService(new RouteGuideServiceImpl(features))
                .build();
    }


    private class RouteGuideServiceImpl  extends RouteGuideGrpc.RouteGuideImplBase{
        private final Collection<Feature> features;
        private final ConcurrentMap<Point, List<RouteNote>> routeNotes =
                new ConcurrentHashMap<Point, List<RouteNote>>();

        RouteGuideServiceImpl(Collection<Feature> features) {
            this.features = features;
        }

        @Override
        public void getFeature(Point request, StreamObserver<Feature> responseObserver) {
            responseObserver.onNext(checkFeature(request));
        }
        //getFeature
        private Feature checkFeature(Point location) {
            for (Feature feature : features) {
                if (feature.getLocation().getLatitude() == location.getLatitude()
                        && feature.getLocation().getLongitude() == location.getLongitude()) {
                    return feature;
                }
            }
            return Feature.newBuilder().setName("").setLocation(location).build();
        }

        @Override
        public void listFeatures(Rectangle request, StreamObserver<Feature> responseObserver) {
            int left = min(request.getLo().getLongitude(), request.getHi().getLongitude());
            int right = max(request.getLo().getLongitude(), request.getHi().getLongitude());
            int top = max(request.getLo().getLatitude(), request.getHi().getLatitude());
            int bottom = min(request.getLo().getLatitude(), request.getHi().getLatitude());

            for(Feature feature:features){
                if(!RouteGuideUtil.exists(feature)){
                    continue;
                }
                int lat = feature.getLocation().getLatitude();
                int lon = feature.getLocation().getLongitude();
                if (lon >= left && lon <= right && lat >= bottom && lat <= top) {
                    responseObserver.onNext(feature);
                }
            }
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<Point> recordRoute(final StreamObserver<RouteSummary> responseObserver) {

            return new StreamObserver<Point>() {
                int pointCount;
                int featureCount;
                int distance;
                Point previous;
                final long startTime = System.nanoTime();
                @Override
                public void onNext(Point point) {
                    pointCount++;
                    if (RouteGuideUtil.exists(checkFeature(point))) {
                        featureCount++;
                    }
                    // For each point after the first, add the incremental distance from the previous point to
                    // the total distance value.
                    if (previous != null) {
                        distance += calcDistance(previous, point);
                    }
                    previous = point;
                }

                @Override
                public void onError(Throwable throwable) {
                    logger.log(Level.WARNING, "recordRoute cancelled");
                }

                @Override
                public void onCompleted() {
                    long seconds = NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                    responseObserver.onNext(RouteSummary.newBuilder().setPointCount(pointCount)
                            .setFeatureCount(featureCount).setDistance(distance)
                            .setElapsedTime((int) seconds).build());
                    responseObserver.onCompleted();
                }
            };
        }



        @Override
        public StreamObserver<RouteNote> routeChat(final StreamObserver<RouteNote> responseObserver) {
            return new StreamObserver<RouteNote>() {
                @Override
                public void onNext(RouteNote note) {
                    List<RouteNote> notes = getOrCreateNotes(note.getLocation());

                    // Respond with all previous notes at this location.
                    for (RouteNote prevNote : notes.toArray(new RouteNote[0])) {
                        responseObserver.onNext(prevNote);
                    }

                    // Now add the new note to the list
                    notes.add(note);
                }

                @Override
                public void onError(Throwable t) {
                    logger.log(Level.WARNING, "routeChat cancelled");
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }

        private List<RouteNote> getOrCreateNotes(Point location) {
            List<RouteNote> notes = Collections.synchronizedList(new ArrayList<RouteNote>());
            List<RouteNote> prevNotes = routeNotes.putIfAbsent(location, notes);
            return prevNotes != null ? prevNotes : notes;
        }

        private int calcDistance(Point start, Point end) {
            double lat1 = RouteGuideUtil.getLatitude(start);
            double lat2 = RouteGuideUtil.getLatitude(end);
            double lon1 = RouteGuideUtil.getLongitude(start);
            double lon2 = RouteGuideUtil.getLongitude(end);
            int r = 6371000; // meters
            double phi1 = toRadians(lat1);
            double phi2 = toRadians(lat2);
            double deltaPhi = toRadians(lat2 - lat1);
            double deltaLambda = toRadians(lon2 - lon1);

            double a = sin(deltaPhi / 2) * sin(deltaPhi / 2)
                    + cos(phi1) * cos(phi2) * sin(deltaLambda / 2) * sin(deltaLambda / 2);
            double c = 2 * atan2(sqrt(a), sqrt(1 - a));

            return (int) (r * c);
        }
    }
    //execute
    public void startRouteGuide() throws IOException, InterruptedException {
        RouteGuideService service=new RouteGuideService(8089);
        service.start();
        service.blockUntilShutdown();
    }

    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                RouteGuideService.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


}
