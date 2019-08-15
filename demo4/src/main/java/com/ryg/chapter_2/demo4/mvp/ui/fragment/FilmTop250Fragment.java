package com.ryg.chapter_2.demo4.mvp.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.di.component.AppComponent;
import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.contract.Top250ActivityContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.Top250Bean;
import com.ryg.chapter_2.demo4.mvp.presenter.Top250ActivityPresenter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.Top250FilmAdapter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmTop250Fragment extends LazyFragment<Top250ActivityPresenter> implements Top250ActivityContract.View {
    @BindView(R.id.movie_top250_recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;
    Top250FilmAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.OnScrollListener listener;
    private int lastVisibleItem;
    private Top250Bean totalBean;
    private boolean notshake;  //防止recyclerview短时间多次刷新，造成数据重复加载。




    public static FilmTop250Fragment newInstance() {
        Bundle args = new Bundle();
        FilmTop250Fragment fragment = new FilmTop250Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void lazyLoad() {
        Log.e("zrg", "hf_FilmTop250Fragment_lazyLoad:mHasLoadedOnce:" + mHasLoadedOnce);

        if (!isInitView || !mIsVisible || mHasLoadedOnce) {
            return;
        }
        mHasLoadedOnce = true;
        //TODO UI和业务逻辑

        idSwiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getData("0", false);
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
        Log.d(TAG, "hf_Top250ActivityActivity_setDataList  recyclerview  is:" + recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        notshake=true;
        scrollRecycleView();
        mPresenter.getData("0", false);
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
//        DaggerMovieComponent //如找不到该类,请编译一下项目
//                .builder()
//                .appComponent(appComponent)
//                .view(this)
//                .build()
//                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_top250, container, false);
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
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public RxPermissions getRxPermissions() {
        return null;
    }

    @Override
    public void setDataList(Top250Bean dataList, boolean ismore) {
        if (ismore) {
            totalBean.getSubjects().addAll(dataList.getSubjects());
            adapter.notifyDataSetChanged();

        }else {
            totalBean=dataList;
            adapter = new Top250FilmAdapter(getActivity(), totalBean);
            Log.d(TAG, "hf_Top250ActivityActivity_setDataList  recyclerview1  is:" + recyclerview);
            recyclerview.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    public void showMessage(@NonNull String message) {
    }
    public void scrollRecycleView() {
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "hf_Top250ActivityActivity_scrollRecycleView  mLayoutManager.getItemCount()  is:" + mLayoutManager.getItemCount());

                    Log.d(TAG, "hf_Top250ActivityActivity_scrollRecycleView  lastVisibleItem  is:" + lastVisibleItem);
                    if (lastVisibleItem >= 249) {
                        if (adapter != null) {
                            adapter.updateLoadStatus(adapter.LOAD_NONE);
                        }
                        return;
                    }
                    if (notshake) {
                        notshake=false;
                        if (lastVisibleItem + 1 == mLayoutManager.getItemCount()) {
                            if (adapter != null) {
                                adapter.updateLoadStatus(adapter.LOAD_PULL_TO);
                                // isLoadMore = true;
                                adapter.updateLoadStatus(adapter.LOAD_MORE);
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    notshake=true;
                                    mPresenter.getData(lastVisibleItem + "", true);

                                }
                            }, 1000);
                        }

                    }
                }
//                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//
//
//                }
//                if (newState == RecyclerView.SCROLL_STATE_SETTLING) {
//
//                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


    }
}
