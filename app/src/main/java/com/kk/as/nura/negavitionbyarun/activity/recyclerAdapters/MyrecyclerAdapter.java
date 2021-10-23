package com.kk.as.nura.negavitionbyarun.activity.recyclerAdapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.MyListImage;
import com.kk.as.nura.negavitionbyarun.activity.activities.gateclickpopup;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Chan Myae Thu on 7/22/17.
 */

public class MyrecyclerAdapter extends FastScrollRecyclerView.Adapter<MyrecyclerAdapter.MyViewHolder>{
    private List<String> list;
    private  int id;
    private Context context;
    private String gateName;
    private String routhpath;
    private List<String> listimage;
    private List<String> routelist;
    public MyrecyclerAdapter(List<String> list, int id, Context context, List<String> routelist, List<String>  listimage) {
        this.context=context;
        this.list=list;
        this.id=id;
        this.listimage=listimage;
        this.routelist=routelist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerallgate,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
          holder.Gtextview.setText(list.get(position));
        holder.Gtextview2.setText(routelist.get(position));
        Picasso.with(context).load(listimage.get(position)).resize(250,250).into(holder.Gimage);
        holder .cardviewallgate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gateName=list.get(position);
                routhpath=routelist.get(position);
                Intent intent=new Intent(view.getContext(),gateclickpopup.class);
                Bundle bd=new Bundle();
                bd.putString("gateName",gateName);
                bd.putString("routepath",routhpath);
                bd.putInt("id1",500);
                intent.putExtras(bd);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       private CardView cardviewallgate;
      private   ImageView Gimage;
     private    TextView Gtextview;
     private    TextView Gtextview2;
        public MyViewHolder(View itemView) {
            super(itemView);
            Gimage= (ImageView) itemView.findViewById(R.id.Gimage);
            Gtextview= (TextView) itemView.findViewById(R.id.Gtextview);
            Gtextview2= (TextView) itemView.findViewById(R.id.Gtextview2);
            cardviewallgate=(CardView) itemView.findViewById(R.id.cardviewallgate);
        }
    }
    public  void setFliter(List<String> setList){
         list=new ArrayList<>();
        list.addAll(setList);
        notifyDataSetChanged();
    }
}
