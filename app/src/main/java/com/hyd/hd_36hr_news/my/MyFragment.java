package com.hyd.hd_36hr_news.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.my.adapter.MineAdapter;
import com.hyd.hd_36hr_news.utils.ui.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private List<LinearLayout> list;
    private MineAdapter adapter;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    protected void initView() {


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

    @Override
    public void onClick(View v) {
        
    }
}
