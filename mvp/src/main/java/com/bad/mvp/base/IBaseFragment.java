package com.bad.mvp.base;

import android.view.View;

public interface IBaseFragment {
    //Fragment绑定ButterKnife
    void bindButterKnife(View view);

    //Fragment解绑ButterKnife
    void unBindButterKnife();

    //绑定presenter和view
    void bindPresenterView();

    //解绑上述
    void unbindPresenterView();

    //初始化fragment的一些基础配置
    void init();

    //布局文件
    int bindLayout();

    //初始化视图
    void initView(View view);

    //加载数据
    void loadData();

}
