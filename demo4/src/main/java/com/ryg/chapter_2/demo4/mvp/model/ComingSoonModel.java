package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.mvp.contract.ComingSoonContract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.ComingCache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.ComingService;
import com.ryg.chapter_2.demo4.mvp.model.entity.ComingBean;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


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
public class ComingSoonModel extends BaseModel implements ComingSoonContract.Model {
    private static final String TAG = "ComingSoonModel";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ComingSoonModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<ComingBean> getMovie(int lastIdQueried, boolean update, String start) {
        Log.d(TAG, "hf_Top250ActivityModel_getMovie  is  running" );
        Observable observable = mRepositoryManager
                .obtainRetrofitService(ComingService.class)
                .getMovie(start);
        return mRepositoryManager.obtainCacheService(ComingCache.class)
                .getCache(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));
    }
}