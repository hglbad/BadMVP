package com.bad.mvp;

public interface CallBack<V> {
    /**
     * 成功回调
     * @param v 返回的bean
     * @param isSuccess 业务是否成功
     * @param Msg 返回消息
     */
    void onSuccess(V v, boolean isSuccess, String Msg);

    /**
     * 失败回调
     * @param fail
     */
    void onFailure(String fail);
}
