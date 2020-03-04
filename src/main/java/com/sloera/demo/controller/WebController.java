package com.sloera.demo.controller;

import com.sloera.mng.core.action.BaseController;
import gov.zwfw.iam.zzgx.util.ParamUtil;
import gov.zwfw.iam.zzgx.util.WebUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by myzha on 2019/7/4.
 */
@Controller
//@RequestMapping("/")
public class WebController extends BaseController {

    private String url = "https://login.gjzwfw.gov.cn:13080/zzgx";
    private String appId = "52_bjxxsstb_test";
    private String appKey = "38d2628a695918079db3eda491ca102cc97ad19ea6666afa67046e31034da050";
    private String appSecret = "UGBAAXMSJ5SC4DCO";
    private String effDate = "2020-09-04";
    private String serviceId = "1000000026";
    private String version = "v1";
    private String token = "";

    @RequestMapping("/index")
    public String index(){
        String root = this.getCdnURL(request);
        request.setAttribute("root", root );
        System.out.println("This is WebController/index");
        return "index";
    }
    @RequestMapping("/form")
    public String form(){

        this.setAttr("root", getContextPath(request));
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
    @RequestMapping(value = "/getstatus", method = RequestMethod.GET)
    public void getStatusGet(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        String id = this.getPara("id");
        if (Integer.valueOf(id) % 2 == 0){
            jsonObject.put("status","even");
        } else
            jsonObject.put("status","odd");
        jsonObject.put("code",200);
        this.renderJson(response, jsonObject.toString());
    }
    @RequestMapping(value = "/getstatus", method = RequestMethod.POST)
    public void getStatusPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        System.out.println("getstatus post");
        String aaa = this.getPara("aaa");
        if (aaa.equals("1")) {
            StringBuilder sb = new StringBuilder();
            Enumeration<String> e = this.request.getParameterNames();
            if (e.hasMoreElements()) {
                label39:
                while(true) {
                    while(true) {
                        String name;
                        do {
                            if (!e.hasMoreElements()) {
                                break label39;
                            }
                            name = (String)e.nextElement();
                        } while("method".equalsIgnoreCase(name));
                        String[] values = this.request.getParameterValues(name);
                        if (values.length == 1) {
                            sb.append(name).append("").append(values[0]);
                        } else {
                            sb.append(name).append("[]={");
                            for(int i = 0; i < values.length; ++i) {
                                if (i > 0) {
                                    sb.append(",");
                                }
                                sb.append(values[i]);
                            }
                            sb.append("}");
                        }
                    }
                }
            }
            this.renderJson(response, result.toString());
            return;
        }
        try {
            //String id = this.getPara("id")==null?"0":this.getPara("id");
            //if (Integer.valueOf(id) % 2 == 0) {
            //    jsonObject.put("status", "even");
            //} else
            //    jsonObject.put("status", "odd");
            JSONObject head = new JSONObject();
            head.put("cllxmc","cllxmc");
            head.put("qrrq","qrrq");
            JSONObject body = new JSONObject();
            body.put("total", "1");
            JSONObject list = new JSONObject();
            JSONArray acc_info = new JSONArray();
            body.put("jzny", "jzny");
            body.put("sr", "sr");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("grzh", "zhigongzhanghao");
            jsonObject.put("zjhm","shenfenzhenghaoma");
            jsonObject.put("lxdh", "lianxidianhua");
            acc_info.add(jsonObject);
            list.put("acc_info", acc_info);
            body.put("list", list);
            result.put("body", body);
            result.put("head", head);
        } catch (Exception e) {
            result.put("code", 300);
            e.printStackTrace();
        }
        System.out.println(result);
        this.renderJson(response, result.toString());
    }

    @RequestMapping(value = "/getstatusArray", method = RequestMethod.OPTIONS)
    public void getStatusArray(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray result = new JSONArray();
        String zjhm = this.getPara("zhjm");
        System.out.println(zjhm);
        System.out.println("getstatus post");
        try {
            jsonObject.put("grzh", "zhigongzhanghao");
            jsonObject.put("zjhm","shenfenzhenghaoma");
            jsonObject.put("lxdh", "lianxidianhua");
            jsonObject2.put("grzh", "zhigongzhanghao2");
            jsonObject2.put("zjhm","shenfenzhenghaoma2");
            jsonObject2.put("lxdh", "lianxidianhua2");
            result.add(jsonObject);
            result.add(jsonObject2);

        } catch (Exception e) {
            jsonObject.put("code", 300);
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        this.renderJson(response, result.toString());
    }
    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public void temp(HttpServletRequest request, HttpServletResponse response) {

        StringBuilder query = new StringBuilder();
        List<Object> sqlParam = new ArrayList<Object>();
        if (logger.isInfoEnabled()) {
            logger.info("接口交换数据开始");
        }
        try {
            //检查token
            if (StringUtils.isBlank(token)) {
               getToken();
            }
            Map<String, String> param = ParamUtil.getDefaultParamMap(appId, serviceId, token, version);
            param = ParamUtil.signParamMap(param, appSecret);
            String result = WebUtils.doPost(url, param, 30000, 40000);
            JSONObject resultJson = JSONObject.fromObject(result);
            System.out.println(result);

        } catch (Exception e) {
            logger.error(e);
        }
    }
    private void getToken() {
        try {
            Map<String, String> param = ParamUtil.getDefaultParamMap(appId, serviceId, token, version);
            param.put("appKey", appKey); //访问密钥
            param = ParamUtil.signParamMap(param, appSecret);
            String result = WebUtils.doPost(url, param, 30000, 40000);
            JSONObject resultJson = JSONObject.fromObject(result);
            if (resultJson.getString("code").equals("200")) {
                token = resultJson.getString("data");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
