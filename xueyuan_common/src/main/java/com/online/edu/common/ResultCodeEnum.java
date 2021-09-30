package com.online.edu.common;

import lombok.Getter;

/**
 * @author ：HaiShun
 * @date ：2021/9/29
 * @description：
 **/
@Getter
public enum ResultCodeEnum {


    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误");

    private Boolean success;

    private Integer code;

    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
