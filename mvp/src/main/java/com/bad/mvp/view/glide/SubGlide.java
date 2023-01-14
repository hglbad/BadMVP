package com.bad.mvp.view.glide;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.Rotate;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;


/**
 * @author: MaGua
 * @create_on:2022/12/12 11:20
 * @description
 */
public final class SubGlide<T extends RequestBuilder, O> {

    private String type;
    private List<Transformation<Bitmap>> applyList;
    private T builder;
    private boolean isGray = false;
    private BitmapTransformation transformation;
    private BitmapTransformation transformation2;
    private RequestOptions options;

    SubGlide(String type, boolean isGray) {
        this.type = type;
        this.applyList = new ArrayList<>();
        this.isGray = isGray;
    }

    SubGlide init(T t) {
        this.builder = t;
        return this;
    }

    public SubGlide centerInside() {
        transformation = new CenterInside();
        return this;
    }

    public SubGlide centerCrop() {
        transformation = new CenterCrop();
        return this;
    }

    public SubGlide fitCenter() {
        transformation = new FitCenter();
        return this;
    }

    public SubGlide applyOptions(RequestOptions options) {
        this.options = options;
        return this;
    }

    public SubGlide granularRoundedCorners(int lt, int rt, int lb, int rb) {
        transformation2 = new GranularRoundedCorners(lt, rt, lb, rb);
        return this;
    }

    public SubGlide roundedCorners(int val) {
        transformation2 = new RoundedCorners(val);
        return this;
    }

    public SubGlide circleCrop() {
        transformation2 = new CircleCrop();
        return this;
    }

    public SubGlide rotate(int val) {
        applyList.add(new Rotate(val));
        return this;
    }

    public SubGlide isGray(boolean is) {
        this.isGray = is;
        return this;
    }

    @SuppressLint("CheckResult")
    public GlideLoader impact() {
        if (options == null) {
            if (isGray) {
                applyList.add(new GrayscaleTransformation());
            }
            if (transformation != null) {
                applyList.add(transformation);
            }
            if (transformation2 != null) {
                applyList.add(transformation2);
            }
            options = new RequestOptions();
            if (applyList.size() != 0) {
                Transformation[] array = new Transformation[applyList.size()];
                options.transform(applyList.toArray(array));
            } else {
                options.dontTransform();
            }
        }

        builder.apply(options);
        if ("bitmap".equals(type)) {
            return new GlideLoader<Bitmap>(builder);
        } else if ("gif".equals(type)) {
            return new GlideLoader<GifDrawable>(builder);
        } else if ("file".equals(type)) {
            return new GlideLoader<File>(builder);
        } else {
            return new GlideLoader<Drawable>(builder);
        }
    }
}
