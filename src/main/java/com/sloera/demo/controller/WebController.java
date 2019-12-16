package com.sloera.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by myzha on 2019/7/4.
 */
@Controller
//@RequestMapping("/")
public class WebController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("This is WebController/index");
        return "index";
    }
    @RequestMapping("/form")
    public String form(){
        System.out.println("This is WebController/form");
        return "form";
    }
    @RequestMapping("/display")
    public String display(){
        System.out.println("This is WebController/display");
        return "display";
    }
    @RequestMapping("/list")
    public String list(){
        System.out.println("This is WebController/list");
        return "list";
    }
}
