package org.sh.huiyi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/meeting")
public class meetingController {

    @GetMapping("/get")
    public String getMeeting(){
        return "meeting";
    }

}
