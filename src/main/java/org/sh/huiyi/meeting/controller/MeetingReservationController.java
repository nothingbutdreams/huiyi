package org.sh.huiyi.meeting.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.meeting.dao.MeetingReservationDao;
import org.sh.huiyi.meeting.model.MeetingReservation;
import org.sh.huiyi.meeting.service.MeetingReservationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/meetingReservation")
public class MeetingReservationController {

    @Autowired
    private MeetingReservationDao meetingReservationDao;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private MeetingReservationService meetingReservationService;

    @GetMapping("/getById")
    @ResponseBody
    public MeetingReservation getMeeting(@RequestParam String id){
        MeetingReservation meetingReservation =
                meetingReservationDao.findById(id);
        return meetingReservation;
    }

    @PostMapping("/add")
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

    @GetMapping("/list")
    public ResponseEntity<Result> list(@RequestParam(defaultValue = "1") Integer pageNumber,
                                       @RequestParam(defaultValue = "50") Integer pageSize,
                                       @RequestParam(required = false) String name){
        Pageable pageable = PageRequest.of(pageNumber <=0 ? 0 : pageNumber-1, pageSize < 1 ? 50 : pageSize);
        return new ResponseEntity(meetingReservationService.getMeetingReservationList(name, pageable), HttpStatus.OK);
    }

}
