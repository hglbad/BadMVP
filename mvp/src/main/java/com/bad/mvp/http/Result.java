package com.bad.mvp.http;

public class Result<T> {

    public State state;

    public T data;

    public boolean isSuccess() {
        return state.code == 0;
    }

    public class State {
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String msg;
        public int code;

    }
}
