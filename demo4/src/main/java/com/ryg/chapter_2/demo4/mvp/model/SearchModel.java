package com.ryg.chapter_2.demo4.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.ryg.chapter_2.demo4.mvp.contract.SearchContract;
import com.ryg.chapter_2.demo4.mvp.model.api.cache.SearchBookCache;
import com.ryg.chapter_2.demo4.mvp.model.api.service.SearchBookService;
import com.ryg.chapter_2.demo4.mvp.model.entity.BookSearchBean;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


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
public class SearchModel extends BaseModel implements SearchContract.Model {
    private static final String TAG = "SearchModel";
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public SearchModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<BookSearchBean> getBook(int lastIdQueried, boolean update, String start,String q) {
        Log.d(TAG, "hf_SearchModel_getBook  is  running" );
        Observable observable = mRepositoryManager
                .obtainRetrofitService(SearchBookService.class)
                .getBook(start,q);
        return mRepositoryManager.obtainCacheService(SearchBookCache.class)
                .getCache(observable
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update));
    }
}