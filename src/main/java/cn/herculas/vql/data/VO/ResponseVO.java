package cn.herculas.vql.data.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO<T> {

    private Integer code;
    private String msg;

    private T data;
}
