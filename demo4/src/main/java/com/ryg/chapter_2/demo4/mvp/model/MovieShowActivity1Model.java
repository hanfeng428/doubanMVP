package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.mvp.contract.MovieShowActivity1Contract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.DangbeiCache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.DangbeiService;
import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 06/24/2019 09:35
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class MovieShowActivity1Model extends BaseModel implements MovieShowActivity1Contract.Model {
    private static final String TAG = "MovieShowActivity1Model";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MovieShowActivity1Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<DangBeiBean> getMovie(int lastIdQueried, boolean update) {
        Log.d(TAG, "DangBeiBean  setDataList  running" );

        Observable observable = mRepositoryManager
                .obtainRetrofitService(DangbeiService.class)
                .getMovie();
        return mRepositoryManager.obtainCacheService(DangbeiCache.class)
                .getUsers(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));


        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
//        return Observable.just(mRepositoryManager
//                .obtainRetrofitService(DangbeiService.class)
//                .getMovie())
//                .flatMap(new Function<Observable<List<DangBeiBean>>, ObservableSource<List<DangBeiBean>>>() {
//                    @Override
//                    public ObservableSource<List<DangBeiBean>> apply(@NonNull Observable<List<DangBeiBean>> listObservable) throws Exception {
//                        return mRepositoryManager.obtainCacheService(DangbeiCache.class)
//                                .getUsers(listObservable
//                                        , new DynamicKey(lastIdQueried)
//                                        , new EvictDynamicKey(update))
//                                .map(listReply -> listReply.getData());
//                    }
//                });


    }
}