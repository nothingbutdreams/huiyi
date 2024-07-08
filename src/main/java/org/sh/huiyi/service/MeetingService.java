package org.sh.huiyi.service;

import org.sh.huiyi.boot.utils.Result;
import org.springframework.data.domain.Pageable;

public interface MeetingService {

    Result getMeetingList(String name, Pageable pageable);

}
