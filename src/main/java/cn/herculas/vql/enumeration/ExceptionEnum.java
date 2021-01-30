package cn.herculas.vql.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    BLOCK_NOT_EXIST(50001, "Block queried does not exist.");

    private final Integer code;
    private final String desc;
}
