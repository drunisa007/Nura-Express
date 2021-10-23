package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentFour;
import com.kk.as.nura.negavitionbyarun.activity.model.Setting;
import com.kk.as.nura.negavitionbyarun.activity.seatactivites.TempCard;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Arun  on 8/2/2017.
 */

public class TopUP extends RecyclerView.Adapter<TopUP.MyViewHolder> {
    private Context context;
    private String name;
    private String departcity,arrivalcity,seatnumber,gatename;
    private List<TempCard> list;
    private FragmentCommunication fragmentCommunication;
    public TopUP(List<TempCard> list ,Context context,String name,FragmentCommunication fragmentCommunication,String departcity
    ,String arrivalcity,String seatnumber){
        this.context=context;
        this.list=list;
        this.name=name;
        this.departcity=departcity;
        this.arrivalcity=arrivalcity;
        this.seatnumber=seatnumber;
        this.fragmentCommunication=fragmentCommunication;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.topup,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context).load(list.get(position).getImage()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.imageviewforbank);
        holder.cardbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title(name)
                        .content("Are u sure you want to buy this")
                        .positiveText("Yes")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                Bundle bd=new Bundle();
                                bd.putString("departcity",departcity);
                                bd.putString("arrivalcity",arrivalcity);
                                bd.putString("seatnumber",seatnumber);
                                bd.putInt("id",1);
                                  Intent in=new Intent(dialog.getContext(),about_ticket_activity.class);
                                Log.d("arun","going to about ticekt activity");
                                in.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                in.putExtras(bd);
                                    dialog.getContext().startActivity(in);
                            }
                        })
                        .negativeText("No")
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageviewforbank;
        CardView cardbank;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardbank=(CardView)  itemView.findViewById(R.id.cardbank);
            imageviewforbank=(ImageView) itemView.findViewById(R.id.imageviewforbank);

        }


    }
    public interface FragmentCommunication{
        public void onClick(String One);

    }

}
