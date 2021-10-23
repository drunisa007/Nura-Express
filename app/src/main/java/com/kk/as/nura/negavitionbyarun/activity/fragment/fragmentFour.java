package com.kk.as.nura.negavitionbyarun.activity.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.about_ticket_activity;
import com.kk.as.nura.negavitionbyarun.activity.model.Setting;
import com.kk.as.nura.negavitionbyarun.activity.recyclerAdapters.MyFragmentfourFastAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Chan Myae Thu  on 8/2/2017.
 */

public class fragmentFour extends Fragment implements View.OnClickListener{

    private LinearLayout linearwallet;
    private LinearLayout linearlayout;
    private LinearLayout linearlayoutlogin;
    private LinearLayout linearticket;
    private TextInputEditText editextlogin1,editextlogin2;
    private Button buttonlogin,buttoncreatenewAccount;
    private String username,password;
    private TextView textviewforgotpassword;
    private int i=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fourfragment, container, false);
        linearwallet= (LinearLayout) v.findViewById(R.id.linearwallet);
        linearlayout= (LinearLayout) v.findViewById(R.id.linearlayout);
        linearlayoutlogin= (LinearLayout) v.findViewById(R.id.linearlayoutlogin);
        linearwallet.setOnClickListener(this);
        linearticket= (LinearLayout) v.findViewById(R.id.linearticket);
        linearticket.setOnClickListener(this);
        buttonlogin= (Button) v.findViewById(R.id.buttonlogin);
        textviewforgotpassword= (TextView) v.findViewById(R.id.textviewforgotpassword);
        buttoncreatenewAccount=(Button) v.findViewById(R.id.buttoncreatenewAccount);
        Log.d("arun","workinh");
        buttonlogin.setOnClickListener(this);
        buttoncreatenewAccount.setOnClickListener(this);
        SharedPreferences spf=getContext().getSharedPreferences("sharedd",MODE_PRIVATE);
        if(spf!=null){
            i=spf.getInt("one",0);
            if(i==1){
                linearlayoutlogin.setVisibility(View.GONE);
                linearlayout.setVisibility(View.VISIBLE);
            }
        }
        else{
            Log.d("arun","spf is not empty");
        }

        return v;
    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.linearwallet:
                wallet();
                break;
            case R.id.linearticket:
                aboutticket();
                break;
            case R.id.buttonlogin:
                    Toast.makeText(view.getContext(),"Successful Login", Toast.LENGTH_SHORT).show();
                    Log.d("arun","working");
                    linearlayout.setVisibility(View.VISIBLE);
                    linearlayoutlogin.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),username+password,Toast.LENGTH_SHORT).show();
                    SharedPreferences spf=view.getContext().getSharedPreferences("sharedd",MODE_PRIVATE);
                    SharedPreferences.Editor editor=spf.edit();
                    editor.putInt("one",1);
                    editor.commit();


                break;
            case R.id.buttoncreatenewAccount:
                break;
        }
    }

    private void aboutticket() {
        Intent in=new Intent(getActivity(),about_ticket_activity.class);
        startActivity(in);
    }

    private void wallet() {
      Intent in=new Intent(getActivity(), Setting.class);
        startActivity(in);
    }

}