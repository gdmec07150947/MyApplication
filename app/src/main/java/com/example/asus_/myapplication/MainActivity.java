package com.example.asus_.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2;
    private int num1,num2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView);
        num1=0;
        num2=0;
        tv1.setText("在onCreate方法中赋值"+num1);
        tv2.setText("在onCreate方法中赋值"+num2);
    }
    protected void onSaveInstanceState(Bundle outState) {
         num1++;
         num2++;
        outState.putString("tv1","onSaveInstanceState 保存的是："+num1);
        outState.putString("tv2",String.valueOf(num2));
        super.onSaveInstanceState(outState);
    }

    protected void onRestorInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv2"));
        tv2.setText("保存的是："+savedInstanceState.getString("tv2"));
        num2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }
    protected void onRestar(){
        super.onRestart();
        tv1.setText("触发restart");
        tv2.setText("触发restart");
    }
}
