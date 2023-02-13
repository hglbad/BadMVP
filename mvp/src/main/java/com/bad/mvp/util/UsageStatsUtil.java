package com.bad.mvp.util;

import static android.app.usage.UsageStatsManager.INTERVAL_DAILY;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.util.Log;

import com.bad.mvp.BuildConfig;
import com.blankj.utilcode.util.TimeUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UsageStatsUtil {
    public static Long getForegroundAppL(Context context, long endTime, String pkgName) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        List<UsageStats> usageStats = usageStatsManager.queryUsageStats(INTERVAL_DAILY, endTime - (10 * 60 * 1000), endTime);
        if (usageStats == null) {
            return 0L;
        }
        UsageStats usageStats1 = null;
        if (BuildConfig.DEBUG) {
            List<UsageStats> collect = usageStats.stream().filter(n -> n.getPackageName().equals(pkgName)).collect(Collectors.toList());
            Log.e("应用信息列表", ParseJsonUtil.toJson(collect));
        }
        if (usageStats.stream().anyMatch(n -> n.getPackageName().equals(pkgName) && TimeUtils.isToday(n.getLastTimeUsed()))) {
            usageStats1 = usageStats.stream().filter(n -> n.getPackageName().equals(pkgName) && TimeUtils.isToday(n.getLastTimeUsed())).findFirst().get();
        }
        if (usageStats1 == null) {
            return 0L;
        }

        if (BuildConfig.DEBUG) {
            Log.e("UsageStats", "**********************************************");
            Log.e("UsageStats", usageStats1.getPackageName());
            Log.e("UsageStats", String.format("运行时长:%s (%sms)", JDateKit.timeToStringChineChinese(usageStats1.getTotalTimeInForeground()), usageStats1.getTotalTimeInForeground()));
            String fmt = "yyyy-MM-dd HH:mm:ss.SSS";
            Log.e("UsageStats", "开始启动:" + JDateKit.timeToDate(fmt, usageStats1.getFirstTimeStamp()));
            Log.e("UsageStats", "最后启动:" + JDateKit.timeToDate(fmt, usageStats1.getLastTimeStamp()));
            Log.e("UsageStats", "最近使用:" + JDateKit.timeToDate(fmt, usageStats1.getLastTimeUsed()));
        }

        return usageStats1.getTotalTimeInForeground();
    }

}