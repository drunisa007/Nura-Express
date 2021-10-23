package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kk.as.nura.negavitionbyarun.R;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by User on 7/28/2017.
 */
public class MyrecyclerpriceAdapter extends RecyclerView.Adapter<MyrecyclerpriceAdapter.MyViewHolder> {
    private  String[] text1;
    private String  price;
    private String route;
    private List<String> routeAndPrice;


    public MyrecyclerpriceAdapter(List<String> items) {

        this.routeAndPrice=items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.pricerecyclerviewlayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      String s=  routeAndPrice.get(position);
        splitRoutePrice(s);
        holder.routetextview.setText(route);
        holder.pricetextview.setText(price);


    }

    @Override
    public int getItemCount() {
        return routeAndPrice.size();
    }

    private void splitRoutePrice(String text) {
        StringTokenizer st = new StringTokenizer(text, "(");
        route = st.nextToken();
        price = st.nextToken();
        price = price.substring(0, price.length() - 1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView pricetextview,routetextview;
        public MyViewHolder(View itemView) {
            super(itemView);
            pricetextview= (TextView) itemView.findViewById(R.id.pricetextview);
            routetextview=(TextView) itemView.findViewById(R.id.routetextview);
        }
    }
}
