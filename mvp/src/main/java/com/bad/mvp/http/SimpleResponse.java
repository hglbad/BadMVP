package com.bad.mvp.http;

import java.io.Serializable;

public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int code;
    public String msg;

    public Result toResultResponse() {
        Result result = new Result();
        result.state.code = code;
        result.state.msg = msg;
        return result;
    }
}
