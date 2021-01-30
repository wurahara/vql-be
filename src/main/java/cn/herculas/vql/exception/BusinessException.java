package cn.herculas.vql.exception;

import cn.herculas.vql.enumeration.ExceptionEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;

    public BusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getDesc());
        this.code = exceptionEnum.getCode();
    }
}
