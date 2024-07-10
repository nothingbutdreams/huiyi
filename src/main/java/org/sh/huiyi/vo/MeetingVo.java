package org.sh.huiyi.vo;

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
public class MeetingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(required = true, defaultValue = "会议名称")
    private String name;

    @Schema(required = true, defaultValue = "2024-01-01 00:00:00")
    private String startTime;

    @Schema(required = true, defaultValue = "2024-01-01 23:00:00")
    private String endTime;

}
