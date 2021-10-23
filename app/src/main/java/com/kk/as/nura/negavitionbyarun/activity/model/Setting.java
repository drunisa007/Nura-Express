package com.kk.as.nura.negavitionbyarun.activity.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.kk.as.nura.negavitionbyarun.R;

/**
 * Created by Aung Thu on 7/31/2017.
 */
public class Setting
 extends AppCompatActivity implements View.OnClickListener {
    private CardView cardview1;
    private CardView cardview2;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        cardview1= (CardView) findViewById(R.id.cardviewforbank1);
        cardview1.setOnClickListener(this);
        cardview2= (CardView) findViewById(R.id.cardviewforbank2);
        cardview2.setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ATM CARD");
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.cardviewforbank1){
         Intent in=   new Intent(view.getContext(), PopUPdesign.class);
            Bundle bd=new Bundle();
            bd.putInt("one",1);
            in.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            in.putExtras(bd);
        startActivity(in);}
        else if(id==R.id.cardviewforbank2){
            Intent in=   new Intent(view.getContext(), PopUPdesign.class);
            in.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            Bundle bd=new Bundle();
            bd.putInt("one",2);
            in.putExtras(bd);
            startActivity(in);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
