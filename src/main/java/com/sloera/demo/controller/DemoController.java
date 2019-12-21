package com.sloera.demo.controller;


import com.sloera.demo.bean.Demo;
import com.sloera.demo.bean.Form;
import com.sloera.demo.po.TempBean;
import com.sloera.demo.service.DemoService;
import com.sloera.mng.core.action.BaseController;
import com.sloera.mng.core.utils.CTools;
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
public class DemoController extends BaseController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/getAll")
    public List<Form> getAll(HttpServletRequest request, HttpServletResponse response) {
//        PageHelper.startPage(2,2);
//        String name = request.getParameter("name");
//        return demoService.getAll();
        return new ArrayList<Form>();
    }

    @RequestMapping("/getByNumber")
    public Form getByNumber(HttpServletRequest request, HttpServletResponse response) {
        String number = request.getParameter("number");
//        long id = Long.parseLong(ids);
//        return demoService.getByNumber(number);
        return new Form();
    }

    @RequestMapping("/add")
    public int add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("This is /add/DemoController/add");
//        Form form = getForm(request);
        TempBean tempBean = getTemp(request);
        int res = -1;
        try {
            res = demoService.save(tempBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
//        return 1;
    }

    @RequestMapping("/delete")
    public int delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("This is /add/DemoController/delete");
        Form form = new Form();
        String number = request.getParameter("number");
        form.setNumber(number);
        //return demoService.delete(form);
        return 1;
    }

    @RequestMapping("/delete2")
    public int delete2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("This si /add/DemoController/delete2");
        String number = request.getParameter("number");
        return 1;
        //return demoService.delete2(number);
    }

    @RequestMapping("/update")
    public int update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("This is /add/DemoController/update");
        Form form = getForm(request);
        return 1;
        //return demoService.update(form);
    }

    //    获取请求中的数据
    private Form getForm(HttpServletRequest request) {
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

    //    获取请求中的数据
    private TempBean getTemp(HttpServletRequest request) {
        TempBean demo = new TempBean();
//        String apply = request.getParameter("apply");
//        demo.setApply(apply);
//        String file = request.getParameter("file");
//        demo.setFile(file);
        demo.setId(CTools.getUUID());
//        String username = request.getParameter("username");
//        demo.setBsNum(username);
        String number = request.getParameter("number");
        demo.setBsNum(number);
        String password = request.getParameter("password");
        demo.setItem(password);
//        String time = request.getParameter("time");
//        demo.setTime(time);
//        String week = request.getParameter("week");
//        demo.setWeek(week);
//        String city = request.getParameter("city");
//        demo.setCity(city);
//        String cars = request.getParameter("cars");
//        demo.setCars(cars);
        return demo;
    }


}
