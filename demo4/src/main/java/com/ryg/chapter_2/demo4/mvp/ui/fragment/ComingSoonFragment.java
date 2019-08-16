package com.ryg.chapter_2.demo4.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.app.utils.ScreenUtils;
import com.ryg.chapter_2.demo4.di.component.DaggerComingSoonComponent;
import com.ryg.chapter_2.demo4.mvp.contract.ComingSoonContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.ComingBean;
import com.ryg.chapter_2.demo4.mvp.presenter.ComingSoonPresenter;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.presenter.Top250ActivityPresenter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.FilmSoonAdapter;
import com.ryg.chapter_2.demo4.mvp.widget.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/15/2019 17:18
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class ComingSoonFragment extends LazyFragment<ComingSoonPresenter> implements ComingSoonContract.View {
    @BindView(R.id.movie_live_recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;

    private GridLayoutManager mLayoutManager;
    private FilmSoonAdapter adapter;
    private boolean notshake;  //防止recyclerview短时间多次刷新，造成数据重复加载。
    private int lastVisibleItem;
    private ComingBean totalBean;


    public static ComingSoonFragment newInstance() {
        Bundle args = new Bundle();
        ComingSoonFragment fragment = new ComingSoonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerComingSoonComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coming_soon, container, false);
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
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void setDataList(ComingBean dataList, boolean ismore) {
        if (ismore) {
            totalBean.getSubjects().addAll(dataList.getSubjects());
            adapter.notifyDataSetChanged();

        } else {
            totalBean = dataList;
            adapter = new FilmSoonAdapter(getActivity(), totalBean);
            Log.d(TAG, "hf_ComingSoonFragment_setDataList  recyclerview1  is:" + recyclerview);
            recyclerview.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void lazyLoad() {
        Log.e("zrg", "hf_ComingSoonFragment_lazyLoad:mHasLoadedOnce:" + mHasLoadedOnce);

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
        Log.d(TAG, "hf_ComingSoonFragment_setDataList  recyclerview  is:" + recyclerview);
        mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.d(TAG, "hf_ComingSoonFragment_getSpanSize  position  is:" + position+"  adapter.getItemCount():"+adapter.getItemCount());
                if (position+1 == adapter.getItemCount()) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        recyclerview.setLayoutManager(mLayoutManager);
        SpacesItemDecoration spacesItemDecoration=new SpacesItemDecoration(ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),0);
        recyclerview.addItemDecoration(spacesItemDecoration);
        notshake = true;
        scrollRecycleView();
        mPresenter.getData("0", false);

    }

    public void scrollRecycleView() {
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "hf_ComingSoonFragment_scrollRecycleView  mLayoutManager.getItemCount()  is:" + mLayoutManager.getItemCount());

                    Log.d(TAG, "hf_ComingSoonFragment_scrollRecycleView  lastVisibleItem  is:" + lastVisibleItem);
                    if (lastVisibleItem >= 90) {
                        if (adapter != null) {
                            adapter.updateLoadStatus(adapter.LOAD_NONE);
                        }
                        return;
                    }
                    if (notshake) {
                        notshake = false;
                        if (lastVisibleItem + 1 == mLayoutManager.getItemCount()) {
                            if (adapter != null) {
                                adapter.updateLoadStatus(adapter.LOAD_PULL_TO);
                                // isLoadMore = true;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.updateLoadStatus(adapter.LOAD_MORE);
                                    }
                                }, 200);
                            }

                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                notshake = true;
                                mPresenter.getData(lastVisibleItem + "", true);

                            }
                        }, 1000);

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
