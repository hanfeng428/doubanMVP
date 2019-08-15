package com.ryg.chapter_2.demo4.app;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
