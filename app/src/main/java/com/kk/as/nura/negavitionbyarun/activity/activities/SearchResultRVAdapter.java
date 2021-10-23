package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Intent;
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
import com.kk.as.nura.negavitionbyarun.activity.model.Gates;
import com.kk.as.nura.negavitionbyarun.activity.seatactivites.seatRow11;

import java.util.List;

/**
 * Created by Arun on 8/3/2017.
 */
public class SearchResultRVAdapter extends RecyclerView.Adapter<SearchResultRVAdapter.MyViewHoldre> {
    private List<Gates> gates;
    private int i;
    private String arrivalcity,departcity;
    public SearchResultRVAdapter(List<Gates> gates,String departcity,String arrivalcity,int i) {
        this.gates=gates;
        this.i=i;
        this.departcity=departcity;
        this.arrivalcity=arrivalcity;
    }

    @Override
    public MyViewHoldre onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerallgate,parent,false);
        return new MyViewHoldre(v);
    }

    @Override
    public void onBindViewHolder(MyViewHoldre holder, int position) {
        Gates g = gates.get(position);
        final String gates = g.getName();
        final String routes = g.getRoute();
        final int id = g.getId();
        holder.Gimage.setImageResource(R.drawable.arun);
        holder.Gtextview.setText(gates);
        holder.Gtextview2.setText(routes);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                Intent intent=new Intent(view.getContext(),gateclickpopup.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Bundle bd=new Bundle();

                    bd.putInt("id2",id);
                    bd.putString("routepath",routes);
                    bd.putString("gateName",gates);
                    bd.putString("departcityone",departcity);
                    bd.putString("arrivalcityone",arrivalcity);
                intent.putExtras(bd);
                view.getContext().startActivity(intent);}
                else if(i==1){
                    Toast.makeText(view.getContext(),"Sorry For That We cannot give u any such data.Try another city. . .Thank You ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return gates.size();
    }

    public class MyViewHoldre extends RecyclerView.ViewHolder {
        ImageView Gimage;
        TextView Gtextview2,Gtextview;
        CardView cardview;
        public MyViewHoldre(View itemView) {
            super(itemView);
            Gimage= (ImageView) itemView.findViewById(R.id.Gimage);
            Gtextview=(TextView) itemView.findViewById(R.id.Gtextview);
            Gtextview2= (TextView) itemView.findViewById(R.id.Gtextview2);
            cardview=(CardView) itemView.findViewById(R.id.cardviewallgate);
        }
    }
}
