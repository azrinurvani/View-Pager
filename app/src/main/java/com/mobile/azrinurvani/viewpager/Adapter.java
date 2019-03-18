package com.mobile.azrinurvani.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends PagerAdapter {

    List<Model> model;
    Context context;
    LayoutInflater layoutInflater;

    public Adapter(List<Model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_page,container,false);

        ImageView imageView;
        TextView title,desc;

        imageView = view.findViewById(R.id.imgPager);
        title = view.findViewById(R.id.textBrosur);
        desc = view.findViewById(R.id.textDesc);

        imageView.setImageResource(model.get(position).getImage());
        title.setText(model.get(position).getTitle());
        desc.setText(model.get(position).getDesc());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((View)object);
    }
}
