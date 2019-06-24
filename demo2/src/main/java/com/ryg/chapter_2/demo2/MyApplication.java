package com.ryg.chapter_2.demo2;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getMyApplicationContext() {
        return mContext;
    }

}
