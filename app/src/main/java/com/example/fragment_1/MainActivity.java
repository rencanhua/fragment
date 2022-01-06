package com.example.fragment_1;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RCH";
    private Button function_but;
    private Button gesture_but;
    private function_Fragment Function_fragment;
    private gesture_Fragment Gesture_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        function_but = findViewById(R.id.bu1);
        gesture_but = findViewById(R.id.bu2);
        function_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在系统中原生的Fragment是通过getFragmentManager获得的。
                FragmentManager fm = getFragmentManager();
                //2.开启一个事务，通过调用beginTransaction方法开启。
                FragmentTransaction ft = fm.beginTransaction();
                //把自己创建好的fragment创建一个对象
                Function_fragment = new function_Fragment();
                //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例
                ft.replace(R.id.frame_main,Function_fragment,"Function");
                Log.d(TAG, "onClick:点击功能设置按钮");
                //提交事务，调用commit方法提交。
                ft.commit();
            }
        });
        gesture_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在系统中原生的Fragment是通过getFragmentManager获得的。
                FragmentManager fm = getFragmentManager();
                //2.开启一个事务，通过调用beginTransaction方法开启。
                FragmentTransaction ft = fm.beginTransaction();
                //把自己创建好的fragment创建一个对象
                Gesture_fragment = new gesture_Fragment();
                //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例
                ft.replace(R.id.frame_main,Gesture_fragment,"Gesture");
                //提交事务，调用commit方法提交。
                Log.d(TAG, "onClick:点击手势设置按钮11");
                ft.commit();
            }
        });
    }
}