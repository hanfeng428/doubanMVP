package com.ryg.chapter_2.demo4.mvp.model.api.cache;

import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;
import com.ryg.chapter_2.demo4.mvp.model.entity.Top250Bean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface Top250Cache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Top250Bean> getCache(Observable<Top250Bean> movies, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
