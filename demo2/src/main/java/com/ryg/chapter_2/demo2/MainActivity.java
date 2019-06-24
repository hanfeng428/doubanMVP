package com.ryg.chapter_2.demo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.cache.Cache;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity11";
    static final int SEARCH=22;
    AsyncTaskLoaderData asyncTaskLoader=new AsyncTaskLoaderData();


    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        return super.provideCache();
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean useEventBus() {
        return super.useEventBus();
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"doing initdata");
        LoaderManager loaderManager = getSupportLoaderManager();
        if(loaderManager==null){
            Log.d(TAG,"loaderManager is null");
            return;
        }
        loaderManager.initLoader(SEARCH, null, asyncTaskLoader);
    }

    @Override
    public boolean useFragment() {
        return super.useFragment();
    }


}
