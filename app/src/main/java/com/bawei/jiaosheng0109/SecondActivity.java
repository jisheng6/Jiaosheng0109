package com.bawei.jiaosheng0109;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/1/9.
 */

public class SecondActivity extends Activity{
    private ViewPager viewPager;
    private Button button;
    private LinearLayout layout;
    private List<ImageView> imageList;//小圆点的集合
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);
        button = (Button) findViewById(R.id.button);
        viewPager = (ViewPager) findViewById(R.id.daohangview_pager);
        layout = (LinearLayout) findViewById(R.id.linear);

        //访问网络图片
        list = new ArrayList<>();
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207203154_yAhxW.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207204451_vUxdK.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207204612_khkBv.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/07/20150207205514_uMz5u.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201502/10/20150210133942_AaJ8R.thumb.700_0.jpeg");

        //初始化小圆点的方法
        initDoc();

        DaohangAdapter daohangAdapter = new DaohangAdapter(list, SecondActivity.this);
        viewPager.setAdapter(daohangAdapter);

        //viewpager设置页面改变的监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //小圆点与viewPager联动
                for (int i = 0; i < list.size(); i++) {
                    if (i == position) {//当前位置的小圆点应该是红色的
                        imageList.get(i).setImageResource(R.drawable.shape_02);
                    } else {
                        imageList.get(i).setImageResource(R.drawable.shape_01);

                    }
                }
                if (list.size() - 1 == position) {
                    //如果到了最后一页,就显示按钮
                    button.setVisibility(View.VISIBLE);
                } else {
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
        private void initDoc() {
            imageList = new ArrayList<ImageView>();

            //for循环创建小圆点,,,加到布局,,,加到集合.....在循环之前先清空一下集合和布局
            layout.removeAllViews();
            imageList.clear();

            for (int i = 0; i < list.size(); i++) {
                ImageView imageView = new ImageView(SecondActivity.this);
                if (i == 0) {//显示的是第一张图片的时候
                    imageView.setImageResource(R.drawable.shape_02);//选中,,,红色
                } else {
                    imageView.setImageResource(R.drawable.shape_01);
                }

                //添加...LayoutParams布局的参数...linearLayout下面的LayoutParams
                LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                //圆点之间的间距
                params.setMargins(5, 0, 5, 0);
                //添加到布局
                layout.addView(imageView, params);
                //添加到集合
                imageList.add(imageView);

            }
        }
}
