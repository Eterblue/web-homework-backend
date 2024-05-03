package com.hit.webhomework.enums;

import lombok.Getter;

@Getter
public enum AppHttpCodeEnum {
    SUCCESS(200,"操作成功"),
    NEED_LOGIN(401,"需要登录后操作"),
    SYSTEM_ERROR(500,"出现错误"),
    LOGIN_FAILED(601, "登录失败"),
    FILE_TYPE_ERROR(700, "文件上传格式错误");

    final int code;
    final String msg;
    AppHttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
    }
}