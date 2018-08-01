package com.tingyun.wade.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tingyun on 2018/1/24.
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    //@ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/index")
    //@ResponseBody
    public String home(){
        return "index";
    }

}
