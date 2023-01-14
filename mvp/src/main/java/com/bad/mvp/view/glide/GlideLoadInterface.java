package com.bad.mvp.view.glide;

/**
 * @author: MaGua
 * @create_on:2022/12/12 11:22
 * @description
 */
public interface GlideLoadInterface<T> {
    /**
     * 加载
     * @param t 加载的结果
     */
    void load(T t);
}
