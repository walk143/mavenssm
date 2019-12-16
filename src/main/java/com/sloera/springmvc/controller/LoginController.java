package com.sloera.springmvc.controller;

import com.sloera.mng.core.action.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by myzha on 2019/10/10.
 */
@Controller
public class LoginController extends BaseController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        return "hello";
    }
}
