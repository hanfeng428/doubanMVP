package com.ryg.chapter_2.demo4.mvp.model.api.cache;

import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface FilmLiveCache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<FilmLiveBean> getCache(Observable<FilmLiveBean> movies, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
