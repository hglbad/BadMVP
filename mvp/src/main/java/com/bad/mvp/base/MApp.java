package com.bad.mvp.base;


import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.moczul.ok2curl.CurlInterceptor;
import com.moczul.ok2curl.logger.Loggable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;


public abstract class MApp extends MultiDexApplication {

    private static MApp instance;
    private static String AppName = "com.mobi.cashday";
    private static String VersionCode = "1.0.1";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        init();
        initHttp();
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    private void initHttp() {
        MConfig config = MBaseModule.getBaseModuleConfig();
        OkGo builder = OkGo.getInstance().init(this);
        Map<String, String> params = config.getParams();
        List<Interceptor> interceptors = config.getInterceptors();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("pkgName", AppName);
        httpHeaders.put("appVersion", VersionCode);
        builder.addCommonHeaders(httpHeaders);
        if (params != null && !params.keySet().isEmpty()) {
            HttpParams httpParams = new HttpParams();
            for (String key : params.keySet()) {
                httpParams.put(key, params.get(key));
            }
            builder.addCommonParams(httpParams);
        }
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(getLoggingInterceptor());
        //打印curl
        client.addInterceptor(new CurlInterceptor(new Loggable() {
            @Override
            public void log(String message) {
                LogUtils.e(message);
            }
        })).build();

        if (interceptors != null && !interceptors.isEmpty()) {
            for (Interceptor interceptor : interceptors) {
                client.addInterceptor(interceptor);
            }
        }
        client.readTimeout(config.getReadTimeout(), TimeUnit.SECONDS);
        client.writeTimeout(config.getReadTimeout(), TimeUnit.SECONDS);
        client.connectTimeout(config.getConnectTimeout(), TimeUnit.SECONDS);
        builder.setOkHttpClient(client.build());
    }

    private HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor("HttpLog");
        interceptor.setPrintLevel((HttpLoggingInterceptor.Level.BODY));
        interceptor.setColorLevel(Level.INFO);

        return interceptor;
    }

    /**
     * 获取全局的application对象
     *
     * @return
     */
    public static MApp getInstance() {
        return instance;
    }

    /**
     * 执行相关项目的一些的初始化配置
     */
    protected abstract void init();

}

