package com.example.nadya.posyandu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class splashscreen extends AppCompatActivity {
    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;
    private SliderAdapater sliderAdapater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        mSlideViewpager =(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        sliderAdapater = new SliderAdapater(this);
        mSlideViewpager.setAdapter(sliderAdapater);



    }
}
