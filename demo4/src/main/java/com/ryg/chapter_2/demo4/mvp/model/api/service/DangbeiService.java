package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.DangBeiBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DangbeiService {
    @GET("http://user.xzhonline.com:8806/api/headline/homepage")
    Observable<DangBeiBean> getMovie();
}
