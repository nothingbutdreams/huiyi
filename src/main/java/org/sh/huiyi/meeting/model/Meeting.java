package org.sh.huiyi.meeting.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MEETING")
@Data
@Accessors(chain=true)
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(generator = "SYSTEM-UUID")
    @GenericGenerator(name = "SYSTEM-UUID", strategy = "uuid")
    @Column(name = "ID", length = 50, nullable = false)
    private String id;

    @Column(name = "CREATE_TIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime = new Date();

    @Column(name = "MEETING_NAME", length = 50, nullable = false)
    private String meetingName;

    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

}
