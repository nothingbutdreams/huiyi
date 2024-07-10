package org.sh.huiyi.meeting.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.meeting.dao.MeetingDao;
import org.sh.huiyi.meeting.model.Meeting;
import org.sh.huiyi.meeting.service.MeetingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/meeting")
public class MeetingController {

    @Autowired
    private MeetingDao meetingDao;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/getById")
    @ResponseBody
    public Meeting getMeeting(@RequestParam String id){
        Meeting meeting = meetingDao.findById(id);
        return meeting;
    }

    @PostMapping("/add")
    public void addMeeting(@RequestBody Meeting mt){
        if(StringUtils.isNotBlank(mt.getId())){
            Meeting meeting = meetingDao.findById(mt.getId());
            BeanUtils.copyProperties(mt, meeting);
            meetingDao.save(meeting);
        }
        else {
            meetingDao.save(mt);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Result> list(@RequestParam(defaultValue = "1") Integer pageNumber,
                                       @RequestParam(defaultValue = "50") Integer pageSize,
                                       @RequestParam(required = false) String name){
        Pageable pageable = PageRequest.of(pageNumber <=0 ? 0 : pageNumber-1, pageSize < 1 ? 50 : pageSize);
        return new ResponseEntity(meetingService.getMeetingList(name, pageable), HttpStatus.OK);
    }

}
