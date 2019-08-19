package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.app.utils.GetVPImage;
import com.ryg.chapter_2.demo4.app.utils.ThemeUtils;
import com.ryg.chapter_2.demo4.app.utils.UIUtils;
import com.ryg.chapter_2.demo4.di.component.DaggerMovieComponent;
import com.ryg.chapter_2.demo4.mvp.contract.MovieContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;
import com.ryg.chapter_2.demo4.mvp.presenter.MoviePresenter;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.MyViewpagerAdapter;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.ComingSoonFragment;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmLiveFragment;
import com.ryg.chapter_2.demo4.mvp.ui.fragment.FilmTop250Fragment;
import com.ryg.chapter_2.demo4.mvp.ui.other.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
public class MovieActivity extends BaseActivity<MoviePresenter> implements MovieContract.View, ViewPager.OnPageChangeListener, Toolbar.OnMenuItemClickListener {
    @BindView(R.id.tab_layout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.banner)
    Banner banner;
    List<Fragment> fragmentList;
    String[] titles;
    private MyViewpagerAdapter mViewPagerAdapter;
    List<String> mList = new ArrayList<>();
    static final int BANER = 11;
    @BindView(R.id.main_toolbar)
    Toolbar main_toolbar;
    @BindView(R.id.main_drawer_layout)
    DrawerLayout maindrawerlayout;
    @BindView(R.id.main_nav)
    NavigationView mainnav;
    @BindView(R.id.main_container)
    RelativeLayout main_container;
    private View headerView;
    private ImageView nav_header_img;
    private TextView nav_header_title;

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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            for (int i = 0; i < mList.size(); i++) {
                Log.d("baner", "hefeng_TopViewPagerAdapter_imagelist:" + mList.get(i));
            }
            if (msg.what == BANER) {
                banner.setImages(mList);
                banner.setImageLoader(new GlideImageLoader());
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Log.d("baner", "hefeng_TopViewPagerAdapter_OnBannerClick:" + position);

                    }
                });
                banner.start();
            }
        }
    };

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetVPImage getVPImage = new GetVPImage();
                mList = getVPImage.getImage();
                if (mList.size() > 0) {
                    handler.sendEmptyMessage(BANER);
                }
            }
        }).start();

        titles = getResources().getStringArray(R.array.tab_film);
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(FilmLiveFragment.newInstance());
        fragmentList.add(ComingSoonFragment.newInstance());
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

        /**
         * 实现抽屉效果
         */
        main_toolbar.inflateMenu(R.menu.menu_toolbar);
        main_toolbar.setOnMenuItemClickListener(this);
        main_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maindrawerlayout.openDrawer(GravityCompat.START);
            }
        });
        headerView = mainnav.getHeaderView(0);
        nav_header_img = (ImageView) headerView.findViewById(R.id.nav_header_img);
        nav_header_title = (TextView) headerView.findViewById(R.id.nav_header_title);
        initToolbar();
        setupDrawerContent();
    }

    private void initToolbar() {
        if (main_toolbar.getTitle() == null) {
            main_toolbar.setTitle(UIUtils.getString(this, R.string.nav_menu_movie));
            mainnav.getMenu().getItem(0).setChecked(true);
        }
    }

    /**
     * nav menu点击事件
     */
    private void setupDrawerContent() {
        mainnav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                maindrawerlayout.closeDrawers();
                String title = (String) menuItem.getTitle();
                main_toolbar.setTitle(title);
                //根据menu的Title开启Fragment

                Log.d(TAG, "hf_MovieActivity_setupDrawerContent  title:" + title);
                return true;
            }
        });
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

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.toolbar_menu_search:
                Log.d(TAG, "hf_MovieActivity_onMenuItemClick  search:");

                break;
        }
        return false;
    }
}
