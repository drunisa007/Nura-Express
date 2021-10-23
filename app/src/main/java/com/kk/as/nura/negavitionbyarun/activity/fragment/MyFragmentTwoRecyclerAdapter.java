package com.kk.as.nura.negavitionbyarun.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.CityLayout;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/28/2017.
 */
public class MyFragmentTwoRecyclerAdapter extends RecyclerView.Adapter<MyFragmentTwoRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<String> listtext;
    private int id;
    private String url;
    private String cityName;

    public MyFragmentTwoRecyclerAdapter(Context context, List<String> listtext) {
        this.context = context;
        this.listtext = listtext;
        this.id = id;
        Uri path=Uri.parse("android.resource://com.kk.as.nura.negavitionbyarun/"+R.drawable.arun3);
        url=path.toString();
    }

    @Override


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contryfragment2layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context).load(url).into(holder.imageviewforfragmenttwo);
        holder.textviewforfragmenttwo.setText(listtext.get(position));
        holder.clicklayoutfragent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName=listtext.get(position);
                Intent intent=new Intent(view.getContext(), CityLayout.class);
                Bundle bd=new Bundle();
                bd.putString("cityName",cityName);
                intent.putExtras(bd);
                    view.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listtext.size();
    }


    public class MyViewHolder extends FastScrollRecyclerView.ViewHolder {
        ImageView imageviewforfragmenttwo;
        TextView textviewforfragmenttwo;
        RelativeLayout clicklayoutfragent2;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageviewforfragmenttwo = (ImageView) itemView.findViewById(R.id.imageviewforfragmenttwo);
            textviewforfragmenttwo = (TextView) itemView.findViewById(R.id.textviewforfragmenttwo);
            clicklayoutfragent2=(RelativeLayout) itemView.findViewById(R.id.clicklayoutfragent2);
        }
    }

    public void setFliter(List<String> list2) {
        listtext=new ArrayList<>();
        listtext.addAll(list2);
        notifyDataSetChanged();

    }
}