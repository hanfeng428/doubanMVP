package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.di.component.DaggerMovieShowActivity1Component;
import com.ryg.chapter_2.demo4.mvp.contract.MovieShowActivity1Contract;
import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MovieShowActivity1Presenter;

import com.ryg.chapter_2.demo4.R;
import com.tbruyelle.rxpermissions2.RxPermissions;


import java.util.List;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 06/24/2019 09:35
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MovieShowActivity1Activity extends BaseActivity<MovieShowActivity1Presenter> implements MovieShowActivity1Contract.View {

    public MovieShowActivity1Activity() {
        super();
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMovieShowActivity1Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_movie_show1; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.getData();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return null;
    }

    @Override
    public void setDataList(List<DangBeiBean> dataList) {
        Log.d(TAG, "DangBeiBean  setDataList  running" );

        for (int i = 0; i < dataList.size(); i++) {
            for(int j=0;j<dataList.get(i).getRows().size();j++) {
                Log.d(TAG, "DangBeiBean" + dataList.get(i).getRows().get(j).getTitle());
            }

        }
    }
}
