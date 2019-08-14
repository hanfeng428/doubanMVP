package com.ryg.chapter_2.demo4.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.ryg.chapter_2.demo4.mvp.contract.Top250ActivityContract;
import com.ryg.chapter_2.demo4.mvp.model.Top250ActivityModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/12/2019 10:15
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class Top250ActivityModule {

    @Binds
    abstract Top250ActivityContract.Model bindTop250ActivityModel(Top250ActivityModel model);
}