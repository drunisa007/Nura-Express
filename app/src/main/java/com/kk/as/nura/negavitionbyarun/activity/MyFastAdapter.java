package com.kk.as.nura.negavitionbyarun.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;

import java.util.List;

/**
 * Created by Arun on 8/13/2017.
 */
public class MyFastAdapter extends RecyclerView.Adapter<MyFastAdapter.MyViewHolder> {
    private List<String> list;
    public MyFastAdapter(List<String> list) {
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fastrecyclerlayout,parent,false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
                 holder.textchange.setText(list.get(position));
        holder.textchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),list.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textchange;
        public MyViewHolder(View itemView) {
            super(itemView);
            textchange= (TextView) itemView.findViewById(R.id.textchange);
        }
    }
}
