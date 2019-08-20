package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieSubjectService {
    @GET("/v2/movie/subject/{path}")
    Observable<MovieDetailsBean> getMovie(@Path("path") String id);
}
