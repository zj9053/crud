package com.zhou.crud.util;

import java.io.Serializable;

/**
 * Json格式的数据进行响应
 */
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;
    /** 描述信息 */
    private String message;
    /** 数据 */
    private E date;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    //Throwable类是所有异常类的父类 直接返回异常描述信息
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }



    public JsonResult(Integer state, E date) {
        this.state = state;
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getDate() {
        return date;
    }

    public void setDate(E date) {
        this.date = date;
    }
}
