package com.hyd.hd_36hr_news.news.ui;

import android.os.Bundle;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.utils.entity.CategoryBean;
import com.hyd.hd_36hr_news.utils.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class pagerFragment extends BaseFragment {

    private static  final String KEY="EXTRA";
    private CategoryBean mCategoryBean;
    @Override
    protected int getLayout() {
        return R.layout.fragment_news_pager_layout;
    }

    @Override
    protected void initView() {

        Bundle bundle = getArguments();
        if(bundle!=null){
            mCategoryBean = (CategoryBean) bundle.getSerializable(KEY);
        }
    }

    @Override
    protected void initVarible() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

    }

    public static final pagerFragment newInstance(CategoryBean categoryBean){

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, categoryBean);
        pagerFragment fragment = new pagerFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
