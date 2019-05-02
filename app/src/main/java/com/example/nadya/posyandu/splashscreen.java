package com.example.nadya.posyandu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapater sliderAdapater;
    private Button mNext;
    private Button mBack;

    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        mSlideViewpager =(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mNext=(Button) findViewById(R.id.next);
        mBack=(Button) findViewById(R.id.preview);

        sliderAdapater = new SliderAdapater(this);
        mSlideViewpager.setAdapter(sliderAdapater);
        addDotsIndicator(0);

        mSlideViewpager.addOnPageChangeListener(viewListener);

        //OnCLickListeners
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewpager.setCurrentItem(mCurrentPage+1);
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewpager.setCurrentItem(mCurrentPage-1);
            }
        });
    }
    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        for (int i=0; i<mDots.length; i++) {
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8266;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage=i;

            if (i==0){
                mNext.setEnabled(true);
                mBack.setEnabled(false);
                mBack.setVisibility(View.INVISIBLE);

                mNext.setText("Next");
                mBack.setText("");
            } else if (i==mDots.length-1) {
                mNext.setEnabled(true);
                mBack.setEnabled(true);
                mBack.setVisibility(View.VISIBLE);

                mNext.setText("Finish");
                mBack.setText("Back");
            } else {
                mNext.setEnabled(true);
                mBack.setEnabled(true);
                mBack.setVisibility(View.VISIBLE);

                mNext.setText("Next");
                mBack.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {


        }
    };
}
