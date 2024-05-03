package com.hit.webhomework.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hit.webhomework.enums.AppHttpCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseResult ok(T data) {
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),AppHttpCodeEnum.SUCCESS.getMsg(),data);
    }
    public static <T> ResponseResult ok(T data,String msg) {
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),msg,data);
    }
    public static <T> ResponseResult ok() {
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),AppHttpCodeEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseResult error(int code,String msg) {
        return new ResponseResult(code,msg);
    }

    public static ResponseResult error(AppHttpCodeEnum appHttpCodeEnum) {
        return new ResponseResult(appHttpCodeEnum.getCode(),appHttpCodeEnum.getMsg());
    }

}


