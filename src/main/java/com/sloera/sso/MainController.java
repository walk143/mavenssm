package com.sloera.sso;

import com.sloera.mng.core.action.BaseController;
import com.sloera.mng.core.db.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

@Controller
public class MainController extends BaseController {
    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String home(HttpServletResponse response) {
        try {
            String type = this.getPara("type");
            String userName = this.getPara("userName");
            userName = URLDecoder.decode(userName,"UTF-8");
            String password = this.getPara("password");
            password = URLDecoder.decode(password,"UTF-8");
            String query = request.getQueryString();
        } catch (Exception e) {
            logger.error(e);
        }
//        return login(response);
        return defaultHtmlUrl();
    }

    /*
     * @Description 用户请求登录
     * @Return 页面
     * @Author liuwangyang
     * @Date 2019-12-14 11:38
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response) {
        Record record = (Record) WebUtils.getSessionAttribute(request, BaseController.USER_TOCKEN);
        String root = this.getCdnURL(request);
        request.setAttribute("command", root + "/main");
        request.setAttribute("root", root );
        return "login";
    }
    private String defaultHtmlUrl(){
        String defaultHtmlUrl = "index";
        return defaultHtmlUrl;
    }
}
