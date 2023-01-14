package com.bad.mvp.base;

public class MBaseModule {
    private static MConfig sbaseModuleConfig;

    private MBaseModule(){

    }

    public static void initialize(MConfig baseModuleConfig) {
        sbaseModuleConfig = baseModuleConfig;
    }

    public static MConfig getBaseModuleConfig() {
        if (sbaseModuleConfig == null) {
            return MConfig.newBuilder().build();
        } else {
            return sbaseModuleConfig;
        }
    }
}
