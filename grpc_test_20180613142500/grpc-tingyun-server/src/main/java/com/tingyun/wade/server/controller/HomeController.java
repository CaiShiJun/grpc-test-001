package com.tingyun.wade.server.controller;

import com.tingyun.wade.server.helloworld.HelloWorldServer;
import com.tingyun.wade.server.manual.ManualFlowControlServer;
import com.tingyun.wade.server.routeguide.RouteGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tingyun on 2018/1/24.
 */
@RestController
public class HomeController {


    @Autowired
    private HelloWorldServer server;

    @Autowired
    private ManualFlowControlServer manualFlowControlServer;

    @RequestMapping({"/index", "/"})
    //@ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/grpc-server")
    @ResponseBody
    public String start() throws IOException, InterruptedException {
        //server.startServer();
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(server);
        service.shutdown();
        return "grpc-server is running.";
    }

    @RequestMapping("/streaming-server")
    @ResponseBody
    public String streamingStart() throws IOException, InterruptedException {
        new Thread() {
            @Override
            public void run() {
                try {
                    manualFlowControlServer.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return "stream server is running.";
    }

    //route
    @RequestMapping("/route-server")
    @ResponseBody
    public String routeStart() throws IOException, InterruptedException {


        new Thread(){
            @Override
            public void run() {

                RouteGuideService service = null;
                try {
                    service = new RouteGuideService(8089);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    service.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*try {
                    service.blockUntilShutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }.start();

        return "route is running...";
    }
}
