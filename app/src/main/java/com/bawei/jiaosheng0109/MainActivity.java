package com.bawei.jiaosheng0109;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    private int time = 5;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0://第三个
                    if (time>0){
                        time--;
                        text.setText("倒计时:"+ time+"秒");
                    //    Message message = handler.obtainMessage(0);
                        handler.sendEmptyMessageDelayed(0,1000);
                    }else{
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                    break;
                case 1://第二个
                    Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
            }
        };
    };

    private TextView text;
    private TextView tiao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        tiao = findViewById(R.id.tiao);
        SharedPreferences preferences = getSharedPreferences("config", 0);
        boolean flag = preferences.getBoolean("flag",false);

        if(flag){
            //第二次进入页面,不延迟直接跳转
            handler.sendEmptyMessage(1);
        }else{

            //第一次进入页面,,存值为true,,,延迟跳转
            preferences.edit().putBoolean("flag",true).commit();
           // Message message = handler.obtainMessage(0);
            handler.sendEmptyMessageDelayed(0,1000);
        }

    }
}
