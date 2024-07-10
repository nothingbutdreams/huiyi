package org.sh.huiyi.meeting.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class MeetingReservationVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(required = true, defaultValue = "会议ID")
    private String meetingId;

    private String meetingName;

    private String startTime;

    private String endTime;

    @Schema(required = true, defaultValue = "周树人")
    private String persName;

    @Schema(required = true, defaultValue = "1311111111")
    private String mobile;

    @Schema(defaultValue = "朝花夕拾")
    private String remark;

    @Schema(required = true, defaultValue = "0")
    private String state;

}
