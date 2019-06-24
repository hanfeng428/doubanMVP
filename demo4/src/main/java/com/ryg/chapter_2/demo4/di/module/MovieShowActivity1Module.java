package com.ryg.chapter_2.demo4.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.ryg.chapter_2.demo4.mvp.contract.MovieShowActivity1Contract;
import com.ryg.chapter_2.demo4.mvp.model.MovieShowActivity1Model;


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
@Module
public abstract class MovieShowActivity1Module {

    @Binds
    abstract MovieShowActivity1Contract.Model bindMovieShowActivity1Model(MovieShowActivity1Model model);
}