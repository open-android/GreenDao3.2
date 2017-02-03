package com.heima.greendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by lidongzhi on 2017/2/3.
 */

public class MyApplication extends Application {
    private static MyApplication sContext;

    public static Context getApplication() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
