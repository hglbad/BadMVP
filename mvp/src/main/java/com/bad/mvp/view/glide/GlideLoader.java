package com.bad.mvp.view.glide;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: MaGua
 * @create_on:2022/12/12 14:41
 * @description
 */
public final class GlideLoader<T> {

    private RequestBuilder<T> main;
    protected int width, height;

    public GlideLoader(RequestBuilder<T> apply) {
        main = apply;
    }

    public GlideLoader setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * 直接获取资源
     *
     * @param callback
     */
    @SuppressLint("CheckResult")
    public void get(GlideLoadInterface<T> callback) {
        Observable.just(new Object())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(baseLayoutBean -> width + height > 0 ?
                        main.submit(width, height).get() : main.submit().get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bitmap -> {
                    if (callback != null) callback.load(bitmap);
                });
    }

    /**
     * 显示在ImageView
     *
     * @param view
     */
    public void into(ImageView view) {
        main.into(view);
    }

    /**
     * 作为组件背景
     *
     * @param view
     */
    public void intoBackgroundImageView(View view) {
        get(t -> {
            if (t instanceof Drawable) {
                view.setBackground((Drawable) t);
            }
        });
    }
}
