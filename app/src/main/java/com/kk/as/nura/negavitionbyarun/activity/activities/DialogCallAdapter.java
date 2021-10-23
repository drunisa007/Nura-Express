package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kk.as.nura.negavitionbyarun.R;

import java.util.ArrayList;

/**
 * Created by USER on 8/3/2017.
 */
public class DialogCallAdapter extends RecyclerView.Adapter<DialogCallAdapter.MyViewHolder> {
    private ArrayList<String> phone;
    public DialogCallAdapter(ArrayList<String> phone) {
        this.phone=phone;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dialogcall,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textview.setText(phone.get(position));
        holder.linearcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:"+phone.get(position).trim()));
                view.getContext().startActivity(in);
            }
        });
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:"+phone.get(position).trim()));
                view.getContext().startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return phone.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textview;
        LinearLayout linearcall;
        public MyViewHolder(View itemView) {
            super(itemView);
            textview= (TextView) itemView.findViewById(R.id.textviewcall);
            imageview=(ImageView) itemView.findViewById(R.id.imageviewcall);
            linearcall= (LinearLayout) itemView.findViewById(R.id.linearcall);
        }
    }
}
