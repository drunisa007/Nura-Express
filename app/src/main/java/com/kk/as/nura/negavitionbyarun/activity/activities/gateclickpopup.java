package com.kk.as.nura.negavitionbyarun.activity.activities;


import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.model.Gates;
import com.kk.as.nura.negavitionbyarun.activity.seatactivites.seatRow11;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gateclickpopup extends AppCompatActivity implements View.OnClickListener {
    private  CardView cardaddress,cardcity,cardservice,cardticket;
    private Toolbar toolbarcollpsing;
    private ViewPager viewpager;
    private List<String> addressAndPhone;
    private Gates gate;
    private List<String>  routeAndPrice;
    private String route,price;
    private String gateName;
    private String routepath;
    private int postition1;
    private int postition2=0;
    private String departcity=null,arrivalcity=null,departcityone=null,arrivalcityone=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticketall);
        toolbarcollpsing= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarcollpsing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bd=getIntent().getExtras();
        routepath= bd.getString("routepath");
         gateName=bd.getString("gateName");
        postition2=bd.getInt("id2");
        postition1=bd.getInt("id1");
       departcityone=bd.getString("departcityone");
         arrivalcityone=bd.getString("arrivalcityone");
        departcity=bd.getString("departcity");
        arrivalcity=bd.getString("arrivalcity");
        getSupportActionBar().setTitle(gateName);
        int[] id={R.drawable.mylikebusone,R.drawable.mylikebus,R.drawable.mylikebustwo
        };
        viewpager= (ViewPager) findViewById(R.id.viewpagerticketall);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimeTask(),3000,3000);
        viewpager.setAdapter(new MyViewpagerAdapter(id,getApplicationContext()));
        cardaddress= (CardView) findViewById(R.id.cardaddress);
        cardcity= (CardView) findViewById(R.id.cardcity);
        cardservice= (CardView) findViewById(R.id.cardservice);
        cardticket= (CardView) findViewById(R.id.cardticket);
        cardaddress.setOnClickListener(this);
        cardcity.setOnClickListener(this);
        cardservice.setOnClickListener(this);
        cardticket.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.cardaddress:
                cardaddress();
                break;
            case R.id.cardcity:
                cardcity();
                break;

            case R.id.cardservice:
                cardservice();
                break;

            case R.id.cardticket:
                cardticket();
                break;
        }

    }


    private void cardaddress() {
        Intent intent=new Intent(getApplicationContext(),gateAbout.class);
        Bundle bd=new Bundle();
        bd.putString("GateName",gateName);
        if(postition1==500){
        bd.putInt("id",postition1);}
        else if(postition2>1){
            bd.putInt("id",postition2);
        }
        bd.putString("routepath",routepath);
        intent.putExtras(bd);
        startActivity(intent);}
    private void cardcity() {
        Intent intent=new Intent(getApplicationContext(),CityLayout.class);
        Bundle bd=new Bundle();
        bd.putString("cityName",gateName);
        intent.putExtras(bd);
        startActivity(intent);
    }
    private void cardservice() {
        startActivity(new Intent(this,protocol.class));
    }
    private void cardticket() {
        Intent in=new Intent(this, seatRow11.class);
        Bundle bd=new Bundle();
        if(departcity!=null){
            bd.putString("departcity",departcity);
            bd.putString("gatename",gateName);
            bd.putString("routeprice","5000 Kyats");
            bd.putString("arrivalcity",arrivalcity);}
        else if (departcityone!=null){
            bd.putString("departcity",departcityone);
            bd.putString("gatename",gateName);
            bd.putString("arrivalcity",arrivalcityone);
            bd.putString("routeprice","5000 Kyats");
        }
        in.putExtras(bd);
        startActivity(in);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyTimeTask extends TimerTask{
        int position=1;

        @Override
        public void run() {

            gateclickpopup.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewpager.getCurrentItem()==0){
                        viewpager.setCurrentItem(1);
                    }

                 else  if(viewpager.getCurrentItem()==1){
                        if(position==1){
                        viewpager.setCurrentItem(2);
                            position=2;
                        }
                        else if(position==2){
                            viewpager.setCurrentItem(0);
                            position=1;
                        }
                    }
                else  if(viewpager.getCurrentItem()==2){
                        if(position==2) {
                            viewpager.setCurrentItem(1);
                            position=2;
                        }
                    }

                }
            });
        }

    }

}

