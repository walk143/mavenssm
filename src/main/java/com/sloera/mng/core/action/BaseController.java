package com.sloera.mng.core.action;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    public Logger logger = Logger.getLogger(this.getClass());
    public static final String USER_TOCKEN = "_Invalidate_Session_Token_";
    public String SYSTEM_CDN = "localhost";

    @Resource
    public HttpServletRequest request;

    public BaseController() {
    }

    public String getPara(String name) {
        String str = this.request.getParameter(name);
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
        }
        //处理字符
        str = StringEscapeUtils.escapeSql(str);
        str = HtmlUtils.htmlEscape(str);
        str = JavaScriptUtils.javaScriptEscape(str);
        return str;
    }

    public String getCdnURL(HttpServletRequest request) {
        String cdn = this.SYSTEM_CDN;
        if (cdn.indexOf("localhost") != -1) {
            String url = this.getContextPath(request);
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }
            return url;
        }else {
            // TODO: 2019/12/17 cdn页面 
            return "";
        }
    }

    public String getContextPath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath =
                request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        logger.error("basePath:" + basePath);
        return basePath;
    }
}
