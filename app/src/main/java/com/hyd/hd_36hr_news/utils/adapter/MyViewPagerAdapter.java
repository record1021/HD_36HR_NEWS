package com.hyd.hd_36hr_news.utils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public MyViewPagerAdapter(FragmentManager fm) {
       super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void setmFragmentList(List<Fragment> mFragmentList) {
        this.mFragmentList = mFragmentList;
    }
}
