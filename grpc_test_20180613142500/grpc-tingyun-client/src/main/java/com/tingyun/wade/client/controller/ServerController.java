package com.tingyun.wade.client.controller;

import com.tingyun.wade.client.HelloWorldClient;
import com.tingyun.wade.client.manual.ManualService;
import com.tingyun.wade.client.route.RouteGuideService;
import com.tingyun.wade.client.route.RouteGuideUtil;
import com.tingyun.wade.server.routeguide.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by tingyun on 2018/1/24.
 */
@Controller
public class ServerController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @Autowired
    private ManualService manualService;

    @RequestMapping("/grpc-client")
    @ResponseBody
    public String getResult() throws InterruptedException {
        helloWorldClient.greet("wade");
        helloWorldClient.shutdown();

        return "client is success.";
    }

    @RequestMapping("/streaming-client")
    @ResponseBody
    public String stream() {
        new Thread(){
            @Override
            public void run() {
                try {
                    manualService.execute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return "client is success.";
    }

    @RequestMapping("/route-chat")
    @ResponseBody
    public String chat() throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                RouteGuideService service=new RouteGuideService("localhost",8089);
                service.routeChat();
/*                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return "route feature is finshed.";
    }

    @RequestMapping("/route-feature")
    @ResponseBody
    public String feature() throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                RouteGuideService service=new RouteGuideService("localhost",8089);
                service.getFeature(1,2);
/*                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        /*RouteGuideService service=new RouteGuideService("localhost",8089);
        service.getFeature(409146138, -746188906);*/
        //service.shutdown();
        return "route feature is finshed.";
    }

    @RequestMapping("/route-listFeatures")
    @ResponseBody
    public String listFeatures() throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                RouteGuideService service=new RouteGuideService("localhost",8089);
                service.listFeatures(400000000, -750000000, 420000000, -730000000);
/*                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return "route feature is finshed.";
    }
    @RequestMapping("/route-recordRoute")
    @ResponseBody
    public String recordRoute() throws IOException, InterruptedException {
        List<Feature> features = RouteGuideUtil.parseFeatures(RouteGuideUtil.getDefaultFeaturesFile());
        RouteGuideService service=new RouteGuideService("localhost",8089);
        service.recordRoute(features, 10);
        return "route feature is finshed.";
    }


}
