package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.Top250ActivityModule;
import com.ryg.chapter_2.demo4.mvp.contract.Top250ActivityContract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.Top250ActivityActivity;


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
@ActivityScope
@Component(modules = Top250ActivityModule.class, dependencies = AppComponent.class)
public interface Top250ActivityComponent {
    void inject(Top250ActivityActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Top250ActivityComponent.Builder view(Top250ActivityContract.View view);

        Top250ActivityComponent.Builder appComponent(AppComponent appComponent);

        Top250ActivityComponent build();
    }
}