package com.ryg.chapter_2.demo4.mvp.model.api.cache;

import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface MovieSubjectCache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<MovieDetailsBean> getCache(Observable<MovieDetailsBean> movies, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
