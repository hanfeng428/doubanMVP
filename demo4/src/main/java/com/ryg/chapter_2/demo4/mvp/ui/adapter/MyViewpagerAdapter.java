package com.ryg.chapter_2.demo4.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyViewpagerAdapter extends FragmentStatePagerAdapter {
    String[] mTitle;
    List<Fragment> mFragments;

    public MyViewpagerAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
        super(fm);
       this.mTitle = titles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle == null ? "" : mTitle[position];
    }

}
