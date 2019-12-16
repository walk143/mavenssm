package com.sloera.demo.controller;


import com.sloera.demo.bean.Form;
import com.sloera.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myzha on 2019/7/3.
 */
@RestController
//    @Controller
//    @ResponseBody
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/getAll")
    public List<Form> getAll(HttpServletRequest request, HttpServletResponse response){
//        PageHelper.startPage(2,2);
//        String name = request.getParameter("name");
//        return demoService.getAll();
        return new ArrayList<Form>();
    }

    @RequestMapping("/getByNumber")
    public Form getByNumber(HttpServletRequest request, HttpServletResponse response){
        String number = request.getParameter("number");
//        long id = Long.parseLong(ids);
//        return demoService.getByNumber(number);
        return new Form();
    }
    @RequestMapping("/add")
    public int add(HttpServletRequest request, HttpServletResponse response){
        System.out.println("This is /add/DemoController/add");
        Form form = getForm(request);
        //return demoService.add(form);
        return 1;
    }
    @RequestMapping("/delete")
    public int delete(HttpServletRequest request, HttpServletResponse response){
        System.out.println("This is /add/DemoController/delete");
        Form form = new Form();
        String number = request.getParameter("number");
        form.setNumber(number);
        //return demoService.delete(form);
        return 1;
    }
    @RequestMapping("/delete2")
    public int delete2(HttpServletRequest request, HttpServletResponse response){
        System.out.println("This si /add/DemoController/delete2");
        String number = request.getParameter("number");
        return 1;
        //return demoService.delete2(number);
    }
    @RequestMapping("/update")
    public int update(HttpServletRequest request, HttpServletResponse response){
        System.out.println("This is /add/DemoController/update");
        Form form = getForm(request);
        return 1;
        //return demoService.update(form);
    }
//    获取请求中的数据
    private Form getForm(HttpServletRequest request){
        Form form = new Form();
        String apply = request.getParameter("apply");
        form.setApply(apply);
        String file = request.getParameter("file");
        form.setFile(file);
        String username = request.getParameter("username");
        form.setUsername(username);
        String number = request.getParameter("number");
        form.setNumber(number);
        String password = request.getParameter("password");
        form.setPassword(password);
        String time = request.getParameter("time");
        form.setTime(time);
        String week = request.getParameter("week");
        form.setWeek(week);
        String city = request.getParameter("city");
        form.setCity(city);
        String cars = request.getParameter("cars");
        form.setCars(cars);
        return form;
    }


}
