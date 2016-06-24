package com.hyd.hd_36hr_news.utils.ui;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.RadioGroup;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.equity.EquityFragment;
import com.hyd.hd_36hr_news.find.FindFragment;
import com.hyd.hd_36hr_news.my.MyFragment;
import com.hyd.hd_36hr_news.news.NewsFragment;
import com.hyd.hd_36hr_news.utils.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener {

    private RadioGroup mHomeTabItems;
    private Context context;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<Fragment> mFragmentList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        mDrawerLayout= (DrawerLayout) findViewById(R.id.main_container);
        mHomeTabItems = (RadioGroup) findViewById(R.id.home_tab_radioGroup);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
       //获取适配器对象
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        //获取fragment的对象数组

        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add(new NewsFragment());
        mFragmentList.add(new EquityFragment());
        mFragmentList.add(new FindFragment());
        mFragmentList.add(new MyFragment());

        myViewPagerAdapter.setmFragmentList(mFragmentList);
        viewPager.setAdapter(myViewPagerAdapter);

    }

    @Override
    protected void initVarible() {

        mHomeTabItems.check(R.id.home_tab_news);
    }

    @Override
    protected void initListener() {

        mHomeTabItems.setOnCheckedChangeListener(this);
        viewPager.setOnPageChangeListener(this);
    }

    /**
     * 关闭策划菜单
     */
    public void closeDrawerLayout(){

        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    /**
     * 打开侧滑
     * 菜单
     */
    public void openDrawerLayout(){

        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    protected void bindData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home_tab_news:
            viewPager.setCurrentItem(0,true);
                break;
            case R.id.home_tab_equity:
                viewPager.setCurrentItem(1,true);
                break;
            case R.id.home_tab_find:
                viewPager.setCurrentItem(2,true);
                break;
            case R.id.home_tab_my:
                viewPager.setCurrentItem(3,true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                mHomeTabItems.check(R.id.home_tab_news);
                break;
            case 1:
                mHomeTabItems.check(R.id.home_tab_equity);
                break;
            case 2:
                mHomeTabItems.check(R.id.home_tab_find);
                break;
            case 3:
                mHomeTabItems.check(R.id.home_tab_my);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
