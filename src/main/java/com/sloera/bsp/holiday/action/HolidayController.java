package com.sloera.bsp.holiday.action;

import com.sloera.bsp.holiday.service.HolidayService;
import com.sloera.mng.core.action.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/bsp/holiday")
public class HolidayController extends BaseController {
    @Autowired
    private HolidayService holidayService;
    public HolidayController() {
    }

    @RequestMapping(params = "method=initHoliday", method = RequestMethod.GET)
    public void initHoliday(HttpServletRequest request, HttpServletResponse response) {
        String year = this.getPara("year");
        String month = this.getPara("month");
        Boolean res = holidayService.initHoliday(year, month);
        JSONObject jsonObject = new JSONObject();
        if (res) {
            jsonObject.put("code","200");
        } else {
            jsonObject.put("code", "300");
        }
        this.renderJson(response, jsonObject.toString());
    }
}
