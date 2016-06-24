package com.hyd.hd_36hr_news.utils.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/6/17 0017.
 */
public class Diver extends RecyclerView.ItemDecoration {
    private  int mDiverHeight=1;
    private Drawable mDiveder;
    private static final int[] ATTRsS= new int[]{android.R.attr.listDivider};
    private Paint paint;
    public Diver(Context context) {
        final TypedArray a = context.obtainStyledAttributes(ATTRsS);
        mDiveder=a.getDrawable(0);
        a.recycle();
    }

    /**
     * 自定义分割线
     * @param context
     * @param color 分割线颜色
     * @param height 分割线高度
     */
    public Diver(Context context, Resources color, int height){
        this(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(1);
        paint.setStyle(Paint.Style.FILL);
    }

    /**
     * 绘制分割线
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left=parent.getPaddingLeft();
        int right = parent.getMeasuredWidth()-parent.getPaddingRight();
        int childSize = parent.getChildCount();
        for(int i=0;i<childSize;i++){
            View child= parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
           int top = child.getBottom()+layoutParams.bottomMargin;
            int bottom=top+mDiverHeight;
            if(mDiveder!=null){
                mDiveder.setBounds(left,top,right,bottom);
                mDiveder.draw(c);
            }
            if(paint!=null){
                c.drawRect(left,top,right,bottom,paint);
            }
        }
    }

    /**
     * 获取分割线的尺寸
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,0,0,mDiverHeight);
    }
}
