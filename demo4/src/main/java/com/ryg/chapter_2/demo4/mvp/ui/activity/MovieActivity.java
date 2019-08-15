package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.app.utils.ThemeUtils;
import com.ryg.chapter_2.demo4.di.component.DaggerMovieComponent;
import com.ryg.chapter_2.demo4.mvp.contract.MovieContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MoviePresenter;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.MyViewpagerAdapter;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmLiveFragment;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmTop250Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/14/2019 16:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MovieActivity extends BaseActivity<MoviePresenter> implements MovieContract.View ,ViewPager.OnPageChangeListener{
    @BindView(R.id.tab_layout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    List<Fragment> fragmentList;
    String[] titles;
    private MyViewpagerAdapter mViewPagerAdapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMovieComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_movie; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        titles = getResources().getStringArray(R.array.tab_film);
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(FilmLiveFragment.newInstance());
        fragmentList.add(FilmTop250Fragment.newInstance());
        mViewPagerAdapter = new MyViewpagerAdapter(getSupportFragmentManager(), titles, fragmentList);
        viewPager.setAdapter(mViewPagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        viewPager.setOffscreenPageLimit(3);
        // 给ViewPager添加页面动态监听器（为了让Toolbar中的Title可以变化相应的Tab的标题）
        viewPager.addOnPageChangeListener(this);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        //todo 用于实现风格切换
//        tablayout.setSelectedTabIndicatorColor(ThemeUtils.getThemeColor());
//        tablayout.setTabTextColors(getResources().getColor(R.color.text_gray_6),ThemeUtils.getThemeColor());
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        tablayout.setupWithViewPager(viewPager);

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
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void setDataList(FilmLiveBean dataList) {

    }
}
