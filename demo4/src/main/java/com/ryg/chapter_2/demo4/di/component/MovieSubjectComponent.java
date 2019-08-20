package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.MovieSubjectModule;
import com.ryg.chapter_2.demo4.mvp.contract.MovieSubjectContract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.MovieSubjectActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/20/2019 14:58
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = MovieSubjectModule.class, dependencies = AppComponent.class)
public interface MovieSubjectComponent {
    void inject(MovieSubjectActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MovieSubjectComponent.Builder view(MovieSubjectContract.View view);

        MovieSubjectComponent.Builder appComponent(AppComponent appComponent);

        MovieSubjectComponent build();
    }
}