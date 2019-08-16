package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.ComingSoonModule;
import com.ryg.chapter_2.demo4.mvp.contract.ComingSoonContract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.ComingSoonActivity;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.ComingSoonFragment;


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
@ActivityScope
@Component(modules = ComingSoonModule.class, dependencies = AppComponent.class)
public interface ComingSoonComponent {
    void inject(ComingSoonActivity activity);

    void inject(ComingSoonFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ComingSoonComponent.Builder view(ComingSoonContract.View view);

        ComingSoonComponent.Builder appComponent(AppComponent appComponent);

        ComingSoonComponent build();
    }
}