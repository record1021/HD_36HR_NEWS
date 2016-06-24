package com.hyd.hd_36hr_news.utils.ui;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.hyd.hd_36hr_news.R;


public class WelcomeActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }


    Handler handler = new Handler(){
        public void handleMessage(Message msg){

            switch (msg.what){
                case 0:
                    Intent in= new Intent(WelcomeActivity.this,HomeActivity.class);
                startActivity(in);
            }
        }
    };



    protected void initView() {

       handler.sendEmptyMessageDelayed(0,3000);
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
}
