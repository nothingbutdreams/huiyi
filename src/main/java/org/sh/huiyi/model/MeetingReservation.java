package org.sh.huiyi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MEETING_RESERVATION")
@Data
@Accessors(chain=true)
public class MeetingReservation implements Serializable {

    @Id
    @GeneratedValue(generator = "SYSTEM-UUID")
    @GenericGenerator(name = "SYSTEM-UUID", strategy = "uuid")
    @Column(name = "ID", length = 50, nullable = false)
    private String id;

    @Column(name = "MEETING_NAME", length = 50, nullable = false)
    private String meetingName;

    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "PERS_NAME", length = 50)
    private String persName;

    @Column(name = "MOBILE", length = 50)
    private String mobile;

    @Column(name = "REMARK", length = 50)
    private String remark;

    @Column(name = "STATE", length = 50)
    private String state;

}
