package com.mobile.azrinurvani.viewpager;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> model;
    Integer colors[]=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        model = new ArrayList<>();

        model.add(new Model(R.drawable.android,"Android","Android is most popular System Operation for Mobile"));
        model.add(new Model(R.drawable.firebase_logo,"Firebase","Firebase is Database No SQL created by Google"));
        model.add(new Model(R.drawable.food,"Food","You hungry ? Maybe this icon can describe your Expression "));
        model.add(new Model(R.drawable.backend,"Backend","I dont know about icon for Backend (Website), maybe this icon can be replace that"));

        adapter = new Adapter(model,this);

        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color3)
        };

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position <(adapter.getCount() - 1)&&position < colors.length - 1){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator
                                    .evaluate(positionOffset,colors[position],colors[position + 1])
                    );
                }else{
                    viewPager.setBackgroundColor(colors.length);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
