package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.model.ticektactivity;

public class about_ticket_activity extends AppCompatActivity  {
    private String depart, arrival, seat;
    private Bundle bd;
    private Toolbar toolbar;
    private int id;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_about_ticket);

        bd = getIntent().getExtras();
        if (bd != null) {
            depart = bd.getString("departcity");
            arrival = bd.getString("arrivalcity");
            id=bd.getInt("id");
            seat = bd.getString("seatnumber");
            Log.d("arun","bundle is not empyt i about ticket");
        } else {
            Log.d("arun", "els is working");
        }
        recyclerview= (RecyclerView) findViewById(R.id.aboutticketrecycler);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(about_ticket_activity.this);
        recyclerview.setLayoutManager(manager);
        recyclerview.setHasFixedSize(true);
        Log.d("arun","recyclerview is wroking");
        recyclerview.setAdapter(new MyAboutTicketAdapter(this,depart,arrival,seat));
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ticket Prime");
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }



}
