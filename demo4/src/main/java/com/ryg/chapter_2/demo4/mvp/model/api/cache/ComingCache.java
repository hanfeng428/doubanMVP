package com.ryg.chapter_2.demo4.mvp.model.api.cache;

import com.ryg.chapter_2.demo4.mvp.model.entity.ComingBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface ComingCache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<ComingBean> getCache(Observable<ComingBean> movies, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
