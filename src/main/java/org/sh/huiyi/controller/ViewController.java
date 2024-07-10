package org.sh.huiyi.controller;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.service.MeetingReservationService;
import org.sh.huiyi.vo.MeetingReservationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private MeetingReservationService meetingReservationService;
    @Autowired
    protected HttpServletRequest request;

    @GetMapping(value = "/meetingReservationV")
    public String meetingReservation(String id, Model model) {
        Result result = meetingReservationService.getMeetingReservationById(id);
        MeetingReservationVo meetingReservationVo = JSON.parseObject(JSON.toJSONString(result.getData()), MeetingReservationVo.class);

        model.addAttribute("meetingReservation", meetingReservationVo);
        return "meetingReservation";
    }

}
