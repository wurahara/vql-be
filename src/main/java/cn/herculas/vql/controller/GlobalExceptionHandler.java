package cn.herculas.vql.controller;

import cn.herculas.vql.data.VO.ResponseVO;
import cn.herculas.vql.exception.BusinessException;
import cn.herculas.vql.util.wrapper.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseVO<?> businessErrorHandler(BusinessException exception) {
        return ResponseWrapper.error(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
