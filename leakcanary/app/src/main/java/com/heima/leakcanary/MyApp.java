package com.heima.leakcanary;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by lidongzhi on 2017/2/3.
 */

public class MyApp extends Application {

    //在自己的Application中添加如下代码
    public static RefWatcher getRefWatcher(Context context) {
        MyApp application = (MyApp) context
                .getApplicationContext();
        return application.refWatcher;
    }

    //在自己的Application中添加如下代码
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //在自己的Application中添加如下代码
        refWatcher = LeakCanary.install(this);
    }

}