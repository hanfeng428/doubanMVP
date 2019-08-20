package com.ryg.chapter_2.demo4.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.cache.Cache;
import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.app.utils.ScreenUtils;
import com.ryg.chapter_2.demo4.di.component.DaggerMovieComponent;
import com.ryg.chapter_2.demo4.mvp.contract.MovieContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MoviePresenter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.EasyRecyclerViewAdapter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.FilmLiveAdapter;
import com.ryg.chapter_2.demo4.mvp.widget.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmLiveFragment extends LazyFragment<MoviePresenter> implements MovieContract.View {
    @BindView(R.id.movie_live_recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;
    private LinearLayoutManager mLayoutManager;
    private FilmLiveAdapter adapter;

    public static FilmLiveFragment newInstance() {

        Bundle args = new Bundle();
        FilmLiveFragment fragment = new FilmLiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        Log.e("zrg", "hf_FilmLiveFragment_lazyLoad:mHasLoadedOnce:" + mHasLoadedOnce);

        if (!isInitView || !mIsVisible || mHasLoadedOnce) {
            return;
        }
        mHasLoadedOnce = true;
        //TODO UI和业务逻辑

        idSwiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getData("50");
                idSwiperefreshlayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (idSwiperefreshlayout != null) {
                            idSwiperefreshlayout.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
        adapter=new FilmLiveAdapter(getActivity());
        mLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerview.setLayoutManager(mLayoutManager);
        SpacesItemDecoration spacesItemDecoration=new SpacesItemDecoration(ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),0);
        recyclerview.addItemDecoration(spacesItemDecoration);
        recyclerview.setAdapter(adapter);
        Log.d(TAG, "hf_FilmLiveFragment_lazyLoad  mPresenter  is:" + mPresenter);
        mPresenter.getData("50");

    }


    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fim_live, container, false);
        ButterKnife.bind(this, view);
        isInitView = true;
        return view;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        lazyLoad();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMovieComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public void setDataList(FilmLiveBean dataList) {
        Log.e("zrg", "hf_FilmLiveFragment_setDataList:dataList:" + dataList);

        adapter.setDatas(dataList.getSubjects());
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new EasyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, Object data) {
                Toast.makeText(getActivity(),"item is clicked",Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public void setBanerList(List<String> list) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
