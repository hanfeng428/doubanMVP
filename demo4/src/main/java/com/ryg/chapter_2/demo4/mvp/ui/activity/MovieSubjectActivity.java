package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.di.component.DaggerMovieSubjectComponent;
import com.ryg.chapter_2.demo4.mvp.contract.MovieSubjectContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MovieSubjectPresenter;

import com.ryg.chapter_2.demo4.R;


import butterknife.BindView;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;
import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/20/2019 14:58
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MovieSubjectActivity extends BaseActivity<MovieSubjectPresenter> implements MovieSubjectContract.View {
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_IMAGE_URL = "image_url";
    String movieID;
    String imageURL;


    @BindView(R.id.activity_md_iv)
    android.widget.ImageView activitymdiv;
    @BindView(R.id.activity_md_toolbar)
    android.support.v7.widget.Toolbar activitymdtoolbar;
    @BindView(R.id.activity_md_colltl)
    android.support.design.widget.CollapsingToolbarLayout activitymdcolltl;
    @BindView(R.id.activity_md_appbar)
    android.support.design.widget.AppBarLayout activitymdappbar;
    @BindView(R.id.activity_md_summary_title)
    android.widget.TextView activitymdsummarytitle;
    @BindView(R.id.activity_md_summary)
    android.widget.TextView activitymdsummary;
    @BindView(R.id.activity_md_summart_more)
    android.widget.TextView activitymdsummartmore;
    @BindView(R.id.activity_md_actor_title)
    android.widget.TextView activitymdactortitle;
    @BindView(R.id.activity_md_rv_actor)
    android.support.v7.widget.RecyclerView activitymdrvactor;
    @BindView(R.id.activity_md_ll)
    android.widget.LinearLayout activitymdll;
    @BindView(R.id.activity_movie_nested)
    android.support.v4.widget.NestedScrollView activitymovienested;
    @BindView(R.id.activity_md_fab)
    android.support.design.widget.FloatingActionButton activitymdfab;
    @BindView(R.id.activity_md_coorl)
    android.support.design.widget.CoordinatorLayout activitymdcoorl;
    @BindView(R.id.activity_md_refresh)
    android.support.v4.widget.SwipeRefreshLayout activitymdrefresh;
    @BindView(R.id.activity_md_subject_title)
    TextView activity_md_subject_title;
    @BindView(R.id.activity_md_subject_aka)
    TextView activity_md_subject_aka;
    @BindView(R.id.activity_md_subject_countries)
    TextView activity_md_subject_countries;
    @BindView(R.id.activity_md_subject_genres)
    TextView activity_md_subject_genres;
    @BindView(R.id.activity_md_subject_year)
    TextView activity_md_subject_year;
    @BindView(R.id.activity_md_ratingbar)
    RatingBar activity_md_ratingbar;
    @BindView(R.id.activity_md_ratings_count)
    TextView activity_md_ratings_count;
    @BindView(R.id.activity_md_ratingnumber)
    TextView activity_md_ratingnumber;
    @BindView(R.id.activity_md_recommend_movie)
    TextView activity_md_recommend_movie;
    @BindView(R.id.activity_md_rv_movie)
    RecyclerView activity_md_rv_movie;
    @BindView(R.id.activity_md_include)
    View activity_md_include;


    public static void toActivity(Activity activity, String id, String imageUrl) {
        Intent intent = new Intent(activity, MovieSubjectActivity.class);
        intent.putExtra(KEY_MOVIE_ID, id);
        intent.putExtra(KEY_IMAGE_URL, imageUrl);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            activity.startActivity(intent,
                    makeSceneTransitionAnimation(activity).toBundle());
        } else {
            activity.startActivity(intent);
        }
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMovieSubjectComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_movie_subject; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            movieID = getIntent().getStringExtra(KEY_MOVIE_ID);
            imageURL = getIntent().getStringExtra(KEY_IMAGE_URL);
        }
        mPresenter.getData("25924056");
        activitymdrefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        activitymdrefresh.setProgressViewOffset(false, 0, 48);
        activitymdtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        activitymdtoolbar.inflateMenu(R.menu.menu_moviedetails_toolbar);
        //初始化Menu
        Menu menu = activitymdtoolbar.getMenu();
        menu.getItem(0).setIcon(R.drawable.collection_true);
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
        finish();
    }

    @Override
    public void setDataList(MovieDetailsBean dataList) {
        Log.d(TAG, "hf_MovieSubjectActivity_setDataList  dataList.getTitle() is  :" + dataList.getTitle());
    }
}
