package com.hyd.hd_36hr_news.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyd.hd_36hr_news.R;
import com.hyd.hd_36hr_news.news.entity.ArticleBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16 0016.
 */
public class NewsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int NORMAL=0;
    private static final int OTHER=1;
    private int mType=0;
    private static final int FOOTER=2;
    private LayoutInflater mInflater;
    private Context context;
    private OnRecyclerViewClickListner mOnRecyclerViewClickListner;

//获取数据
    private List<ArticleBean> mArticleBeanList;
    public void setArticleBeanList(List<ArticleBean> mArticleBeanList) {
        this.mArticleBeanList = mArticleBeanList;
    }

    public NewsRecyclerAdapter(int mType, Context context) {
        this.mType = mType;
        this.context = context;
        mInflater=LayoutInflater.from(context);
    }

    /**
     * 根据viewtype去加载不同的viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView =null;
       if(viewType==NORMAL){
           if(itemView==null){
               itemView=mInflater.inflate(R.layout.items_news_layout,parent,false);
               return new NewsNormalViewHolder(itemView);
           }
       }else if(viewType==FOOTER) {
        View footItemView=mInflater.inflate(R.layout.items_news_layout,parent,false);
           FooterItemViewHolder footItemViewHolder = new FooterItemViewHolder(footItemView);
           return footItemViewHolder;
       }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof NewsNormalViewHolder) {
            ArticleBean articleBean = mArticleBeanList.get(position);
            holder.itemView.setTag(articleBean);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnRecyclerViewClickListner != null) {
                        mOnRecyclerViewClickListner.onItemClick(v, (ArticleBean) v.getTag(), position);
                    }
                }
            });
            Picasso.with(context).load(articleBean.getmImgUrl()).into(((NewsNormalViewHolder) holder).mNewsLogo);
            ((NewsNormalViewHolder) holder).mNewsTitle.setText(articleBean.getmTitle());
            ((NewsNormalViewHolder) holder).mNewsType.setText(articleBean.getmMask());
            ((NewsNormalViewHolder) holder).mNewsAuther.setText(articleBean.getmAuthor().getmName());
            ((NewsNormalViewHolder) holder).mNewsTime.setText(articleBean.getmDateText());

        } else if(holder instanceof FooterItemViewHolder){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mOnRecyclerViewClickListner!=null){
                            mOnRecyclerViewClickListner.onItemClick(v, (ArticleBean) v.getTag(),position);
                        }
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return mArticleBeanList.size();
    }
        /**
         * 判断receycleview记载的是哪一个视图
         * @param position
         * @return
         */
        @Override
        public int getItemViewType ( int position){
            if (mType == 0) {
                return NORMAL;
            } else {
                return OTHER;
            }
        }

//    public void setCategoryBeanList(List<CategoryBean> categoryBeanList) {
//        this.categoryBeanList = categoryBeanList;
//    }

    /**
     * x新闻列表的视图
     */
    public  class NewsNormalViewHolder extends RecyclerView.ViewHolder{

        private TextView mNewsTitle,mNewsType,mNewsAuther,mNewsTime;
        private ImageView mNewsLogo;

        public NewsNormalViewHolder(View itemView) {
            super(itemView);
            mNewsTitle= (TextView) itemView.findViewById(R.id.news_items_title);
            mNewsType= (TextView) itemView.findViewById(R.id.news_items_type);
            mNewsAuther=   (TextView) itemView.findViewById(R.id.news_items_auther);
            mNewsTime=(TextView) itemView.findViewById(R.id.news_items_time);
            mNewsLogo= (ImageView) itemView.findViewById(R.id.news_items_logo);
        }
    }

    /**
     * 上拉刷新加载更多布局
     */
    private class FooterItemViewHolder extends RecyclerView.ViewHolder {
        public FooterItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 提供给外部调用者的一个监听接口
     */
    public interface OnRecyclerViewClickListner{
        void onItemClick(View view, ArticleBean categoryBean, int position);
    }
    /**
     * 将这个监听接口暴露给外部调用者
     * @param
     */
    public void setmOnRecyclerViewClickListner(OnRecyclerViewClickListner mOnRecyclerViewClickListner){
        this.mOnRecyclerViewClickListner=mOnRecyclerViewClickListner;
    }
}
