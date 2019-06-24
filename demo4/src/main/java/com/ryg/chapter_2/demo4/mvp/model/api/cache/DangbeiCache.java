package com.ryg.chapter_2.demo4.mvp.model.api.cache;

import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

public interface DangbeiCache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<DangBeiBean>>> getUsers(Observable<List<DangBeiBean>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
