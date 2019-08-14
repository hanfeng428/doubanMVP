package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.mvp.contract.Top250ActivityContract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.DangbeiCache;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.Top250Cache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.Top250Service;
import com.ryg.chapter_2.demo4.mvp.model.entity.Top250Bean;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


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
public class Top250ActivityModel extends BaseModel implements Top250ActivityContract.Model {
    private static final String TAG = "Top250ActivityModel";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Top250ActivityModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Top250Bean> getMovie(int lastIdQueried, boolean update,String start) {
        Log.d(TAG, "hf_Top250ActivityModel_getMovie  is  running" );
        Observable observable = mRepositoryManager
                .obtainRetrofitService(Top250Service.class)
                .getMovie(start);
        return mRepositoryManager.obtainCacheService(Top250Cache.class)
                .getCache(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));
    }
}