package com.ryg.chapter_2.demo4.mvp.ui.fragment;


import android.view.View;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.IPresenter;
import com.ryg.chapter_2.demo4.mvp.presenter.MoviePresenter;

/**
在LazyFragment实现懒加载
 */
public abstract class LazyFragment<T extends IPresenter> extends BaseFragment<T> {
    protected View rootView;
    /**
     * 标志位，标志已经初始化完成
     */
    protected boolean isInitView = false;
    /**
     * 判断当前的Fragment是否可见(相对于其他的Fragment)
     */
    protected boolean mIsVisible = false;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    protected boolean mHasLoadedOnce;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //设置Fragment的可见状态
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {//getUserVisibleHint获取Fragment可见状态
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }


        //预留毁掉接口，比如可以同时用户fragment可见性变化
//        if (isResumed()) {
//
//        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
        stopLoad();
    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }


}
