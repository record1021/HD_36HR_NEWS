package com.hyd.hd_36hr_news.news.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.utils.entity.CategoryBean;
import com.hyd.hd_36hr_news.utils.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class mainFragment extends BaseFragment {

    private static  final String KEY="EXTRA";
    private TextView textView;
    private CategoryBean mCategoryBean;

    @Override
    protected int getLayout() {
        return R.layout.fragment_news_main_layout;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if(bundle!=null){
            mCategoryBean= (CategoryBean) bundle.getSerializable(KEY);
        }
        textView= (TextView) mView.findViewById(R.id.text_tv);
    }

    @Override
    protected void initVarible() {

        textView.setText(mCategoryBean.getmTitle());

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

    }

    /**
     * 用于新建category对应的fragment实例，实现fragment复用
     * @param categoryBean
     * @return
     */
    public static final mainFragment newInstance(CategoryBean categoryBean){

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, categoryBean);
        mainFragment fragment = new mainFragment();
        fragment.setArguments(bundle);
        return fragment;

    }


}
