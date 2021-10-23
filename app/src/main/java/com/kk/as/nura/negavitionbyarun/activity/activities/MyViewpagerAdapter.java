package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kk.as.nura.negavitionbyarun.R;

public class MyViewpagerAdapter extends PagerAdapter {
    private  int[] id;
    private  Context context;


    public MyViewpagerAdapter(int[] id,Context context) {
        this.id=id;
        this.context=context;
    }

    @Override

    public int getCount() {
        return id.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.swipelayout,container,false);
        ImageView imageView= (ImageView) v.findViewById(R.id.imageviewforviewpager);
        imageView.setImageResource(id[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
