package com.ryg.chapter_2.demo4.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.ryg.chapter_2.demo4.mvp.contract.ComingSoonContract;
import com.ryg.chapter_2.demo4.mvp.model.ComingSoonModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/15/2019 17:18
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class ComingSoonModule {

    @Binds
    abstract ComingSoonContract.Model bindComingSoonModel(ComingSoonModel model);
}