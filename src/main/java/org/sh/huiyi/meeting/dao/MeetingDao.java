package org.sh.huiyi.meeting.dao;

import org.sh.huiyi.meeting.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingDao extends JpaRepository<Meeting,Integer>, JpaSpecificationExecutor {

    Meeting findById(String id);

}
