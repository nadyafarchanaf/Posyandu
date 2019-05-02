package com.example.nadya.posyandu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapater extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapater(Context context) {
        this.context = context;
    }

    //Array
    public int[] slide_images = {
            R.drawable.ibuhamil_icon,
            R.drawable.ibudananak_icon,
            R.drawable.perkembangananak_icon
    };
    public String[] slide_headings= {
            "Ibu Hamil",
            "Ibu dan Anak",
            "Perkembangan Anak"
    };
    public String[] slide_desk = {
            "alalal",
            "kakakka",
            "kkkkkk"
    };


    @Override
    public int getCount() {

        return slide_headings.length;
    }
    @Override
    public boolean isViewFromObject (View view, Object object) {
        return view==(RelativeLayout) object;

    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView= (ImageView) view.findViewById(R.id.slide_images);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.text_deks);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desk[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
