package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;
import com.ryg.chapter_2.demo4.mvp.model.entity.Top250Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Top250Service {
    @GET("/v2/movie/top250")
    Observable<Top250Bean> getMovie(@Query("start")String start);
}
