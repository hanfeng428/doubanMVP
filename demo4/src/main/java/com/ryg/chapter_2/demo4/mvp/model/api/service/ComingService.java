package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.ComingBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ComingService {
    @GET("/v2/movie/coming_soon")
    Observable<ComingBean> getMovie(@Query("start")String start);
}
