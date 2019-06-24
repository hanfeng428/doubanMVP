package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.MovieShowActivity1Module;
import com.ryg.chapter_2.demo4.mvp.contract.MovieShowActivity1Contract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.MovieShowActivity1Activity;


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
@ActivityScope
@Component(modules = MovieShowActivity1Module.class, dependencies = AppComponent.class)
public interface MovieShowActivity1Component {
    void inject(MovieShowActivity1Activity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MovieShowActivity1Component.Builder view(MovieShowActivity1Contract.View view);

        MovieShowActivity1Component.Builder appComponent(AppComponent appComponent);

        MovieShowActivity1Component build();
    }
}