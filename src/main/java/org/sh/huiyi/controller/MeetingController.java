package org.sh.huiyi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.ModelUtil;
import org.sh.huiyi.dao.MeetingReservationDao;
import org.sh.huiyi.model.MeetingReservation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
@RequestMapping(value = "/meeting")
public class MeetingController {

    @Autowired
    private MeetingReservationDao meetingReservationDao;
    @Autowired
    protected HttpServletRequest request;

    @GetMapping("/getMeetingById")
    @ResponseBody
    public MeetingReservation getMeeting(@RequestParam String id){
        MeetingReservation meetingReservation =
                meetingReservationDao.findById(id);
        return meetingReservation;
    }

    @PostMapping("/addMeeting")
    public void addMeeting(@RequestBody MeetingReservation mReservation){
        if(StringUtils.isNotBlank(mReservation.getId())){
            MeetingReservation meetingReservation = meetingReservationDao.findById(mReservation.getId());
            BeanUtils.copyProperties(mReservation, meetingReservation);
            meetingReservationDao.save(meetingReservation);
        }
        else {
            meetingReservationDao.save(mReservation);
        }
    }


}
