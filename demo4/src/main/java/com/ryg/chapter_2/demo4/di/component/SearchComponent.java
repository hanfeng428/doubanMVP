package com.ryg.chapter_2.demo4.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.ryg.chapter_2.demo4.di.module.SearchModule;
import com.ryg.chapter_2.demo4.mvp.contract.SearchContract;

import com.jess.arms.di.scope.ActivityScope;
import com.ryg.chapter_2.demo4.mvp.ui.activity.SearchActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/22/2019 17:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = SearchModule.class, dependencies = AppComponent.class)
public interface SearchComponent {
    void inject(SearchActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        SearchComponent.Builder view(SearchContract.View view);

        SearchComponent.Builder appComponent(AppComponent appComponent);

        SearchComponent build();
    }
}