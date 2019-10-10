package com.sloera.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by myzha on 2019/10/10.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        return "hello";
    }
}
