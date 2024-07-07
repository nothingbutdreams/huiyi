package org.sh.huiyi.controller;

import org.sh.huiyi.dao.MeetingReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private MeetingReservationDao meetingReservationDao;

    @GetMapping(value = "/meetingReservationV")
    public String meetingReservation() {
        return "meetingReservation";
    }

}
