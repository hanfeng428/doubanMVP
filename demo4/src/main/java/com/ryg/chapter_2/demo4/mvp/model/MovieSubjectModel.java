package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.mvp.contract.MovieSubjectContract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.MovieSubjectCache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.MovieSubjectService;
import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


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
public class MovieSubjectModel extends BaseModel implements MovieSubjectContract.Model {
    private static final String TAG = "MovieSubjectModel";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MovieSubjectModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<MovieDetailsBean> getMovie(int lastIdQueried, boolean update,String id) {
        Log.d(TAG, "hf_MovieModel_getMovie  is  running");
        Observable observable = mRepositoryManager
                .obtainRetrofitService(MovieSubjectService.class)
                .getMovie(id);
        return mRepositoryManager.obtainCacheService(MovieSubjectCache.class)
                .getCache(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));
    }
}