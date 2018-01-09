package com.bawei.jiaosheng0109;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/1/9.
 */

public class SecondActivity extends Activity{
    private ViewPager viewPager;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);
        button = (Button) findViewById(R.id.button);
        viewPager = (ViewPager) findViewById(R.id.daohangview_pager);
        //访问网络图片
        final List<String> list = new ArrayList<>();
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207203154_yAhxW.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207204451_vUxdK.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207204612_khkBv.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207205514_uMz5u.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/10/20150210133942_AaJ8R.thumb.700_0.jpeg");

        DaohangAdapter daohangAdapter = new DaohangAdapter(list, SecondActivity.this);
        viewPager.setAdapter(daohangAdapter);

        //viewpager设置页面改变的监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (list.size()-1 == position){
                    //如果到了最后一页,就显示按钮
                    button.setVisibility(View.VISIBLE);
                }else{
                    button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //按钮的点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
    }
}
