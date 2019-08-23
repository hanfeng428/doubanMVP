package com.ryg.chapter_2.demo4.mvp.model.api.service;

import com.ryg.chapter_2.demo4.mvp.model.entity.BookSearchBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchBookService {
    @GET("/v2/book/search")
    Observable<BookSearchBean> getBook(@Query("start")String start,@Query("q")String q);
}
