package org.sh.huiyi.meeting.dao;

import org.sh.huiyi.meeting.model.MeetingReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingReservationDao extends JpaRepository<MeetingReservation,Integer>, JpaSpecificationExecutor {

    MeetingReservation findById(String id);

}
