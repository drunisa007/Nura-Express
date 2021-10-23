package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.model.ticektactivity;

/**
 * Created by Aung Thu on 8/6/2017.
 */
public class MyAboutTicketAdapter extends RecyclerView.Adapter<MyAboutTicketAdapter.MyViewHolder> {
    private  Context context;
    private String depart;
    private String arrival;
    private String seat;
    public MyAboutTicketAdapter(Context context, String depart, String arrival, String seat) {
        this.context=context;
        this.depart=depart;
        this.arrival=arrival;
        this.seat=seat;
    }

    @Override
    public MyAboutTicketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.aboutrecyclerview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAboutTicketAdapter.MyViewHolder holder, int position) {
            holder.aboutticketimageview.setImageResource(R.drawable.coin);
            holder.cardviewaboutticket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(view.getContext(),ticektactivity.class);
                    if(depart!=null){
                    Bundle bd=new Bundle();
                    bd.putString("departcity",depart);
                    bd.putString("arrivalcity",arrival);
                    bd.putString("seatnumber",seat);
                    in.putExtras(bd);
                    }

                    view.getContext().startActivity(in);

                }
            });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView aboutticketimageview;
        CardView cardviewaboutticket;
        public MyViewHolder(View itemView) {
            super(itemView);
            aboutticketimageview=(ImageView) itemView.findViewById(R.id.aboutticketimageview);
            cardviewaboutticket=(CardView) itemView.findViewById(R.id.cardviewaboutticket);
        }
    }
}
