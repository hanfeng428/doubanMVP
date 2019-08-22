package com.ryg.chapter_2.demo4.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.jess.arms.utils.RxLifecycleUtils;
import com.ryg.chapter_2.demo4.mvp.contract.MovieSubjectContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;

import java.util.List;


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
public class MovieSubjectPresenter extends BasePresenter<MovieSubjectContract.Model, MovieSubjectContract.View> {
    private static final String TAG = "MovieSubjectPresenter";
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public MovieSubjectPresenter(MovieSubjectContract.Model model, MovieSubjectContract.View rootView) {
        super(model, rootView);
    }

    public void getData(String id){
        Log.d(TAG, "hf_MovieSubjectPresenter_getData  is  running");

        mModel.getMovie(11, true,id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {

                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<MovieDetailsBean>(mErrorHandler) {
                    @Override
                    public void onNext(MovieDetailsBean movies) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onNext  is  :"+movies);
                        mRootView.setDataList(movies);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onError  is  :"+t);
                        super.onError(t);
                    }
                });
    }

    public void getLikeMovieID(String id){
        mModel.getLikeMovieID(id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {

                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<List<String>>(mErrorHandler) {
                    @Override
                    public void onNext(List<String> movies) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onNext1 is  :"+movies);
                        mRootView.setLikeMoiveId(movies);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onError1  is  :"+t);
                        super.onError(t);
                    }
                });
    }

    public void getLikeMovieTitle(String id){
        mModel.getLikeMovieTitle(id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {

                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<List<String>>(mErrorHandler) {
                    @Override
                    public void onNext(List<String> movies) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onNext2 is  :"+movies);
                        mRootView.setLikeMoiveTitle(movies);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onError2  is  :"+t);
                        super.onError(t);
                    }
                });
    }

    public void getLikeMovieImg(String id){
        mModel.getLikeMovieimg(id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {

                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<List<String>>(mErrorHandler) {
                    @Override
                    public void onNext(List<String> movies) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onNext3 is  :"+movies);
                        mRootView.setLikeMoiveImg(movies);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "hf_MovieSubjectPresenter_onError3  is  :"+t);
                        super.onError(t);
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
