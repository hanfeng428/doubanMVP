package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmLiveService {
    @GET("v2/movie/in_theaters")
    Observable<FilmLiveBean> getMovie(@Query("count")String count);
}
