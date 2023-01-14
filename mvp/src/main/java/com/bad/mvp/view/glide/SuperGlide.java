package com.bad.mvp.view.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;

import java.io.File;

/**
 * @author: MaGua
 * @create_on:2022/12/12 9:35
 * @description Glide超级封装
 */
public class SuperGlide {

    private Context sub;
    private RequestManager requestManager;
    private boolean isGray = false;

    private SuperGlide(Context context) {
        sub = context;
    }

//    public static SuperGlide with(Subgrade subgrade) {
//        SuperGlide sg = new SuperGlide(subgrade.getSubgradeContext());
//        sg.requestManager = Glide.with(sg.sub);
//        sg.isGray = subgrade.isGray();
//        return sg;
//    }

    public static SuperGlide with(Context context) {
        SuperGlide sg = new SuperGlide(context);
        sg.requestManager = Glide.with(context);
        return sg;
    }

    /**
     * 加载出的图片以Drawable对象读取出
     *
     * @param obj
     * @return
     */

    public SubGlide asDrawable(String obj) {
        RequestBuilder<Drawable> requestBuilder = requestManager.asDrawable().load(obj);
        return new SubGlide<RequestBuilder<Drawable>, Drawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asDrawable(int obj) {
        RequestBuilder<Drawable> requestBuilder = requestManager.asDrawable().load(obj);
        return new SubGlide<RequestBuilder<Drawable>, Drawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asDrawable(Drawable obj) {
        RequestBuilder<Drawable> requestBuilder = requestManager.asDrawable().load(obj);
        return new SubGlide<RequestBuilder<Drawable>, Drawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asDrawable(Bitmap obj) {
        RequestBuilder<Drawable> requestBuilder = requestManager.asDrawable().load(obj);
        return new SubGlide<RequestBuilder<Drawable>, Drawable>("drawable", isGray).init(requestBuilder);
    }


    /**
     * 加载出的图片以Bitmap对象读取出
     *
     * @param obj
     * @return
     */

    public SubGlide asBitmap(String obj) {
        RequestBuilder<Bitmap> requestBuilder = requestManager.asBitmap().load(obj);
        return new SubGlide<RequestBuilder<Bitmap>, Bitmap>("bitmap", isGray).init(requestBuilder);
    }

    public SubGlide asBitmap(int obj) {
        RequestBuilder<Bitmap> requestBuilder = requestManager.asBitmap().load(obj);
        return new SubGlide<RequestBuilder<Bitmap>, Bitmap>("bitmap", isGray).init(requestBuilder);
    }

    public SubGlide asBitmap(Drawable obj) {
        RequestBuilder<Bitmap> requestBuilder = requestManager.asBitmap().load(obj);
        return new SubGlide<RequestBuilder<Bitmap>, Bitmap>("bitmap", isGray).init(requestBuilder);
    }

    public SubGlide asBitmap(Bitmap obj) {
        RequestBuilder<Bitmap> requestBuilder = requestManager.asBitmap().load(obj);
        return new SubGlide<RequestBuilder<Bitmap>, Bitmap>("bitmap", isGray).init(requestBuilder);
    }

    /**
     * 加载出Gif的图片以Drawable对象读取出
     *
     * @param obj
     * @return
     */

    public SubGlide asGif(String obj) {
        RequestBuilder<GifDrawable> requestBuilder = requestManager.asGif().load(obj);
        return new SubGlide<RequestBuilder<GifDrawable>, GifDrawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asGif(int obj) {
        RequestBuilder<GifDrawable> requestBuilder = requestManager.asGif().load(obj);
        return new SubGlide<RequestBuilder<GifDrawable>, GifDrawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asGif(Drawable obj) {
        RequestBuilder<GifDrawable> requestBuilder = requestManager.asGif().load(obj);
        return new SubGlide<RequestBuilder<GifDrawable>, GifDrawable>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asGif(Bitmap obj) {
        RequestBuilder<GifDrawable> requestBuilder = requestManager.asGif().load(obj);
        return new SubGlide<RequestBuilder<GifDrawable>, GifDrawable>("drawable", isGray).init(requestBuilder);
    }


    /**
     * 加载图片以File对象读取出
     *
     * @param obj
     * @return
     */

    public SubGlide asFile(String obj) {
        RequestBuilder<File> requestBuilder = requestManager.asFile().load(obj);
        return new SubGlide<RequestBuilder<File>, File>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asFile(int obj) {
        RequestBuilder<File> requestBuilder = requestManager.asFile().load(obj);
        return new SubGlide<RequestBuilder<File>, File>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asFile(Drawable obj) {
        RequestBuilder<File> requestBuilder = requestManager.asFile().load(obj);
        return new SubGlide<RequestBuilder<File>, File>("drawable", isGray).init(requestBuilder);
    }

    public SubGlide asFile(Bitmap obj) {
        RequestBuilder<File> requestBuilder = requestManager.asFile().load(obj);
        return new SubGlide<RequestBuilder<File>, File>("drawable", isGray).init(requestBuilder);
    }

}
