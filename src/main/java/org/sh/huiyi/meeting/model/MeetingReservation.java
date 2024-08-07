package org.sh.huiyi.meeting.model;

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

    @Column(name = "CREATE_TIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime = new Date();

    @ManyToOne
    @JoinColumn(name = "MEETING_ID")
    private Meeting meeting;

    @Column(name = "PERS_NAME", length = 50)
    private String persName;

    @Column(name = "MOBILE", length = 50)
    private String mobile;

    @Column(name = "REMARK", length = 50)
    private String remark;

    @Column(name = "STATE", length = 50)
    private String state;

}
