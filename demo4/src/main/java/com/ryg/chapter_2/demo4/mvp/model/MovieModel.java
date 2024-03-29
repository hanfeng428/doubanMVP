package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.app.utils.jsoupUtils.GetVPImage;
import com.ryg.chapter_2.demo4.mvp.contract.MovieContract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.FilmLiveCache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.FilmLiveService;
import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/14/2019 16:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class MovieModel extends BaseModel implements MovieContract.Model {
    private static final String TAG = "MovieModel";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;
    List<String> mList = new ArrayList<>();
    long startTime;

    @Inject
    public MovieModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<FilmLiveBean> getMovie(int lastIdQueried, boolean update, String count) {
        Log.d(TAG, "hf_MovieModel_getMovie  is  running");
        Observable observable = mRepositoryManager
                .obtainRetrofitService(FilmLiveService.class)
                .getMovie(count);
        return mRepositoryManager.obtainCacheService(FilmLiveCache.class)
                .getCache(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));
    }


    @Override
    public Observable<String> getBaner() {
        Log.d(TAG, "hf_MovieModel_getBaner  is  running:" + mList.size());
//        startTime = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                GetVPImage getVPImage = new GetVPImage();
//                mList = getVPImage.getImage();
//
//            }
//        }).start();
//        long stopTime = System.currentTimeMillis();
//        Log.d(TAG, "hf_MovieModel_getBaner  is  running startTime1:" + startTime+"  stopTime:"+stopTime);
//
//        while (mList.size()==0 && (stopTime - startTime) < 5000) {
//            Log.d(TAG, "hf_MovieModel_getBaner  is  running startTime:" + startTime+"  stopTime:"+stopTime);
//            stopTime = System.currentTimeMillis();
//            continue;
//        }
//        Log.d(TAG, "hf_MovieModel_getBaner  is  running mList:" + mList);


        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                GetVPImage getVPImage = new GetVPImage();
                mList = getVPImage.getImage();
                for(String ss:mList){
                    emitter.onNext(ss);
                }
                emitter.onComplete();
            }
        });


        return observable;
    }
}