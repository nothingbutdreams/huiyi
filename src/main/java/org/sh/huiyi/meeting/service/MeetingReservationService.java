package org.sh.huiyi.meeting.service;

import org.sh.huiyi.boot.utils.Result;
import org.springframework.data.domain.Pageable;

public interface MeetingReservationService {

    Result getMeetingReservationList(String name, Pageable pageable);

    Result getMeetingReservationById(String id);

}
