package cn.herculas.vql.util.wrapper;

import cn.herculas.vql.data.VO.ResponseVO;
import cn.herculas.vql.exception.BusinessException;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseWrapper {

    public static <T> ResponseVO<T> success(T data) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(HttpStatus.OK.value());
        responseVO.setMsg(HttpStatus.OK.getReasonPhrase());
        responseVO.setData(data);
        return responseVO;
    }

    public static ResponseVO<?> success() {
        return ResponseWrapper.success(null);
    }

    private static ResponseVO<?> error(HttpStatus httpStatus, Map<String, Object> errMsgMap) {
        ResponseVO<Map<String, Object>> responseVO = new ResponseVO<>();
        responseVO.setCode(httpStatus.value());
        responseVO.setMsg(httpStatus.getReasonPhrase());
        responseVO.setData(errMsgMap);
        return responseVO;
    }

    public static ResponseVO<?> error(HttpStatus httpStatus, BusinessException exception) {
        Map<String, Object> errMsgMap = new LinkedHashMap<>();
        errMsgMap.put("err_code", exception.getCode());
        errMsgMap.put("err_message", exception.getMessage());
        return ResponseWrapper.error(httpStatus, errMsgMap);
    }
}
