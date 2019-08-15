package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.MovieModule;
import com.ryg.chapter_2.demo4.mvp.contract.MovieContract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.MovieActivity;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmLiveFragment;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmTop250Fragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/14/2019 16:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = MovieModule.class, dependencies = AppComponent.class)
public interface MovieComponent {
    void inject(MovieActivity activity);
    void inject(FilmLiveFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MovieComponent.Builder view(MovieContract.View view);

        MovieComponent.Builder appComponent(AppComponent appComponent);

        MovieComponent build();
    }
}