package com.wang.sc.entity;

import java.io.Serializable;

/**
 * @author dwang
 * @create 2020-03-05 14:21
 */
public class Results<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public Results(){}

    public Results(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Results(Integer code, String message){
        this(code,message,null);
    }

    public Integer getCode() {
        return this.code;
    }

    public Results<T> setCode(final Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Results<T> setMessage(final String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public Results<T> setData(final T data) {
        this.data = data;
        return this;
    }
}
