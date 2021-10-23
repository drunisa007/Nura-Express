package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by arun on 7/25/17.
 */
public class MyrecyclercardAdaper extends RecyclerView.Adapter<MyrecyclercardAdaper.MyViewHolder> {
    private List<String> addressAndPhone;
    private String add = " ", ph = " ";


    public MyrecyclercardAdaper(List<String> items) {
        this.addressAndPhone=items;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclergatecard,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      final String s=addressAndPhone.get(position);
        splitAddPh(s);
        holder.textviewaddress.setText(add);
        holder.textviewphoneno.setText(ph);
        holder.cardviewclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitAddressPhone(s,view.getContext());
            }
        });

    }

    @Override
    public int getItemCount() {

        return addressAndPhone.size();
    }

    private void splitAddPh(String text) {
        StringTokenizer st = new StringTokenizer(text, "Ph:");
        add = st.nextToken();
        ph =  st.nextToken();
    }
    private void splitAddressPhone(String text, Context context) {
        String addressLine = " ", allphone = " ";
        ArrayList<String> phone = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(text, "Ph:");
        addressLine = st.nextToken();
        allphone = st.nextToken();
        st = new StringTokenizer(allphone, ",");
        while (st.hasMoreElements()) {
            phone.add(st.nextToken());
        }
        new MaterialDialog.Builder(context)
                .title(addressLine)
                .adapter(new DialogCallAdapter(phone), null)
                .negativeText("Cancel")
                .show();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textviewaddress,textviewphoneno;
        CardView cardviewclick;
        public MyViewHolder(View itemView) {
            super(itemView);
            textviewaddress= (TextView) itemView.findViewById(R.id.textviewaddress);
            textviewphoneno= (TextView) itemView.findViewById(R.id.textviewphoneno);
            cardviewclick= (CardView) itemView.findViewById(R.id.cardviewclick);

        }

    }
}
