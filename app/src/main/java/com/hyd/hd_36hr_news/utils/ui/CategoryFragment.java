package com.hyd.hd_36hr_news.utils.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hyd.hd_36hr_news.utils.OkHttpUtils;
import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.utils.Contants;
import com.hyd.hd_36hr_news.utils.adapter.FixedPagerAdapter;
import com.hyd.hd_36hr_news.utils.entity.CategoryBean;
import com.squareup.okhttp.Request;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class CategoryFragment extends BaseFragment {

    private ImageView mBack;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FixedPagerAdapter mAdapter;
    private List<CategoryBean> mCategoryList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_category_tab;
    }

    @Override
    protected void initView() {

        mBack = (ImageView) mView.findViewById(R.id.category_back);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycleview);
    }

    @Override
    protected void initVarible() {

        //设置布局管理器
        mLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //设置RecyclerView的固定大小
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FixedPagerAdapter(getActivity(),0);
        OkHttpUtils.getAsync(Contants.URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {

                Document document = (Document) Jsoup.parse(result,Contants.URL);
                mCategoryList = CategoryBean.getCategoryBeanData(document);
                mAdapter.setCategoryList(Contants.getCategoryBean());
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initListener() {

        mAdapter.setRecycleronClickListner(new FixedPagerAdapter.OnRecyclerViewOnClickListner() {
            @Override
            public void onItemClick(View view, CategoryBean categoryBean) {
             //消息发送给新闻界面
                EventBus.getDefault().post(new MessageEvent(categoryBean));
                ((HomeActivity)getActivity()).closeDrawerLayout();
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeActivity)getActivity()).closeDrawerLayout();
                bindData();
            }
        });
    }

    @Override
    protected void bindData() {

    }
}
