package com.google.mvp.https;

import java.io.Serializable;

public class BaseRes<D> implements Serializable {

    private static final int SUCCESS = 200;

    private boolean success;
    private int code;
    private String msg;
    private D data;

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
