package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.app.utils.SnackBarUtils;
import com.ryg.chapter_2.demo4.app.utils.StringUtils;
import com.ryg.chapter_2.demo4.app.utils.UIUtils;
import com.ryg.chapter_2.demo4.di.component.DaggerMovieSubjectComponent;
import com.ryg.chapter_2.demo4.mvp.contract.MovieSubjectContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MovieSubjectPresenter;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.ActorAdapter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.BaseRecyclerAdapter;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.LikeMovieAdapter;


import java.util.List;

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
public class MovieSubjectActivity extends BaseActivity<MovieSubjectPresenter> implements MovieSubjectContract.View, AppBarLayout.OnOffsetChangedListener {
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_IMAGE_URL = "image_url";
    String movieID;
    String imageURL;
    private List<String> movieTitle;
    private List<String> movieId;
    private List<String> movieimg;

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
    private MovieDetailsBean mSubject;
    private ActorAdapter mAdapter;
    private LikeMovieAdapter mLikeAdapter;


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
        initListener();
        imageURL="https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549234765.webp";
        mPresenter.getData("25924056");
        mPresenter.getLikeMovieID();
        mPresenter.getLikeMovieTitle();
        mPresenter.getLikeMovieImg();
        activitymdrefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        activitymdrefresh.setProgressViewOffset(false, 0, 48);
        activitymdtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        activitymdtoolbar.inflateMenu(R.menu.menu_moviedetails_toolbar);
        //初始化Menu
        Menu menu = activitymdtoolbar.getMenu();
        updateMovieImg();
        menu.getItem(0).setIcon(R.drawable.collection_true);
    }

    private void initListener(){
        activitymdrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //todo   刷新未做处理
                activitymdrefresh.setRefreshing(true);

                activitymdrefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (activitymdrefresh != null) {
                            activitymdrefresh.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
        activitymdfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSubject != null) {
                    WebViewActivity webactivity = new WebViewActivity();
                    webactivity.toWebActivity(MovieSubjectActivity.this, mSubject.getAlt(), mSubject.getTitle());
                }
            }
        });
        activitymdappbar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //当Appbar完全显示时才启用SwipeRefreshLayout
        activitymdrefresh.setEnabled(verticalOffset == 0);
    }

    private void updateMovieImg() {
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        int color = getColor(resource);
                        activitymdcolltl.setContentScrimColor(color);
                        activitymdcolltl.setBackgroundColor(color);
                        activitymdiv.setImageBitmap(resource);
                    }
                });
    }

    private int getColor(Bitmap bitmap) {
        if (bitmap != null) {
            Palette p = Palette.from(bitmap).generate();
            Palette.Swatch s_dm = p.getDarkMutedSwatch();
            Palette.Swatch s_dv = p.getDarkVibrantSwatch();
            if (s_dm != null) {
                return s_dm.getRgb();
            } else {
                if (s_dv != null) {
                    return s_dv.getRgb();
                } else {
                    return UIUtils.getColor(getApplicationContext(), R.color.colorPrimary);
                }
            }
        } else {
            return UIUtils.getColor(getApplicationContext(), R.color.colorPrimary);
        }
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
        mSubject = dataList;
        likeMovie();
        updateView();
    }

    @Override
    public void setLikeMoiveId(List<String> list) {
        for (String ss : list) {
            Log.d(TAG, "hf_MovieSubjectActivity_setLikeMoiveId  ss is  :" + ss);
        }
        movieId = list;
        likeMovie();
    }

    @Override
    public void setLikeMoiveTitle(List<String> list) {
        for (String ss : list) {
            Log.d(TAG, "hf_MovieSubjectActivity_setLikeMoiveTitle  ss is  :" + ss);
        }
        movieTitle = list;
        likeMovie();
    }

    @Override
    public void setLikeMoiveImg(List<String> list) {
        for (String ss : list) {
            Log.d(TAG, "hf_MovieSubjectActivity_setLikeMoiveImg  ss is  :" + ss);
        }
        movieimg = list;
    }

    /**
     * 加载同类喜欢列表
     */
    private void likeMovie() {
        if (movieId != null && movieTitle != null && movieimg != null) {
            activity_md_recommend_movie.setText(UIUtils.getString(MovieSubjectActivity.this, R.string.md_load_likemovie));
            activity_md_rv_movie.setVisibility(View.VISIBLE);
            activity_md_rv_movie.setLayoutManager(new LinearLayoutManager(MovieSubjectActivity.this,
                    LinearLayoutManager.HORIZONTAL, false));
            mLikeAdapter = new LikeMovieAdapter(MovieSubjectActivity.this, movieTitle, movieimg, movieId);
            activity_md_rv_movie.setAdapter(mLikeAdapter);

            mLikeAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(String id, String url) {
                    if (id != null && url != null) {
                        MovieSubjectActivity.toActivity(MovieSubjectActivity.this, id, url);
                    } else {
                        SnackBarUtils.showSnackBar(activitymdcoorl, UIUtils.getString(MovieSubjectActivity.this, R.string.error));
                    }
                }
            });

        } else {
            activity_md_recommend_movie.setText(UIUtils.getString(MovieSubjectActivity.this, R.string.md_load_error));
        }
    }


    /**
     * 获取到数据，加载View
     */
    private void updateView() {
        activitymdll.setVisibility(View.VISIBLE);

        if (mSubject.getRating() != null) {
            float rate = (float) (mSubject.getRating().getAverage() / 2);
            activity_md_ratingbar.setRating(rate);
            activity_md_ratingnumber.setText(rate * 2 + "");
            activity_md_ratings_count.setText(mSubject.getRatings_count() + "人评价");
        }

        activity_md_subject_title.setText(mSubject.getTitle());
        if (mSubject.getGenres() != null) {
            activity_md_subject_genres.setText("");
            List<String> genres = mSubject.getGenres();
            activity_md_subject_genres.append(UIUtils.getString(this, R.string.md_movie_type));
            StringUtils.addViewString(genres, activity_md_subject_genres);
        }
        if (mSubject.getCountries() != null) {
            activity_md_subject_countries.setText("");
            List<String> countries = mSubject.getCountries();
            activity_md_subject_countries.append(UIUtils.getString(this, R.string.md_movie_country));
            StringUtils.addViewString(countries, activity_md_subject_countries);

        }
        activity_md_subject_year.setText(UIUtils.getString(this, R.string.md_movie_year) + mSubject.getYear());
        if (mSubject.getAka() != null) {
            activity_md_subject_aka.setText("");
            List<String> aka = mSubject.getAka();
            activity_md_subject_aka.append(UIUtils.getString(this, R.string.md_movie_original));
            StringUtils.addViewString(aka, activity_md_subject_aka);
        }
        if (mSubject.getSummary() != null) {
            activitymdsummarytitle.setText(UIUtils.getString(this, R.string.md_movie_brief));
            activitymdsummary.setText(mSubject.getSummary());
            activitymdsummartmore.setText(UIUtils.getString(this, R.string.md_more));
        }

        activitymdactortitle.setText(UIUtils.getString(this, R.string.md_movie_actor));

        activitymdrvactor.setVisibility(View.VISIBLE);
        activitymdrvactor.setLayoutManager(new LinearLayoutManager(MovieSubjectActivity.this,
                LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new ActorAdapter(this, mSubject);
        activitymdrvactor.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String id, String url) {
                Log.d(TAG, "hf_MovieSubjectActivity_onItemClick  is  :");

            }
        });
        activity_md_recommend_movie.setText(UIUtils.getString(MovieSubjectActivity.this, R.string.md_load_ing));
        likeMovie();

    }
}
