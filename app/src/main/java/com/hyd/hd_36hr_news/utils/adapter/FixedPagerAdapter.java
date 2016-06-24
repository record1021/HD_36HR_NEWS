package com.hyd.hd_36hr_news.utils.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.utils.entity.CategoryBean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class FixedPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements View.OnClickListener {
    private static final int CATEGORY=0;
    private LayoutInflater mInflater;
    private List<CategoryBean> CategoryList;
    private int mType;
    private OnRecyclerViewOnClickListner clickListner;

    public FixedPagerAdapter(Context context, int type) {
        this.mType = type;
        mInflater = LayoutInflater.from(context);
    }


    public void setCategoryList(List<CategoryBean> categoryList) {
        CategoryList = categoryList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView;
      if(viewType==CATEGORY){
          itemView = mInflater.inflate(R.layout.category_items,parent,false);
         //注册点击事件
          itemView.setOnClickListener(this);
          ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
          return itemViewHolder;
      }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ItemViewHolder){
            CategoryBean categoryBean =CategoryList.get(position);
            holder.itemView.setTag(categoryBean);
            ((ItemViewHolder) holder).mItemType.setBackgroundColor(Color.RED);
            ((ItemViewHolder)holder).mItemName.setText(CategoryList.get(position).getmTitle());

        }
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }

    @Override
    public int getItemCount() {
        return CategoryList.size();
    }




    class ItemViewHolder extends RecyclerView.ViewHolder {
        private View mItemType;
        private TextView mItemName;
        public ItemViewHolder(View itemView) {
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.category_item_name);
            mItemType = itemView.findViewById(R.id.category_item_type);
        }
    }

    /**
     * 提供给外部调用的接口
     */
    public static interface OnRecyclerViewOnClickListner{

        void onItemClick(View view,CategoryBean categoryBean);

    }

    /**声明接口对象
     * 提供给外部的调用方法
     */
    private OnRecyclerViewOnClickListner RecycleronClickListner;

    public void setRecycleronClickListner(OnRecyclerViewOnClickListner recycleronClickListner) {
        RecycleronClickListner = recycleronClickListner;
    }

    /**
     * 绑定
     * @param v
     */
    @Override
    public void onClick(View v) {

        if(RecycleronClickListner!=null){

            RecycleronClickListner.onItemClick(v, (CategoryBean) v.getTag());
        }
    }


}
