package org.sh.huiyi.boot.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "message", "data" })
public class Result implements Serializable {

    private static final long serialVersionUID = 8235210184968338941L;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private transient Object data;

    public Result(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, @Nullable Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public Result getResultEntity(String code, String message, Object object) {
        return new Result(code, message, object);
    }

    public Result getResultEntity(String code, String message) {
        return new Result(code, message);
    }

}
