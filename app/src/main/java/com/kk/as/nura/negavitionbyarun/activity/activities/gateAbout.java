package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.model.Gates;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class gateAbout extends AppCompatActivity {
    private RecyclerView recyclerview;
    private  RecyclerView recyclerviewforprice;
    private Toolbar toolbar;
    private String gateName;
    private TextView textviewforroute;
    private String routhpath;
    private List<String> addressAndPhone;
    private Gates gate;
    private DatabaseHelper databaseHelper;
    private int id;
    private String name,routee, contact, contactTV = "",pricee, idName;
    private List<String>  routeAndPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gateabout);
        toolbar= (Toolbar) findViewById(R.id.toolbarbyaboutgate);
        textviewforroute= (TextView) findViewById(R.id.textviewforroute);
        Bundle bd=getIntent().getExtras();
        routhpath=bd.getString("routepath");
        textviewforroute.setText(routhpath);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bdd=getIntent().getExtras();
        gateName=bdd.getString("GateName");
        getSupportActionBar().setTitle(gateName);

        recyclerview= (RecyclerView) findViewById(R.id.recyclerviewcard);
        recyclerviewforprice= (RecyclerView) findViewById(R.id.recyclerviewcardforprice);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager manager1=new LinearLayoutManager(this);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(manager);
        addressAndPhone=new ArrayList<>();
        routeAndPrice=new ArrayList<>();
        onSetUp();
        recyclerviewforprice.setHasFixedSize(true);
        recyclerviewforprice.setLayoutManager(manager1);
        recyclerview.setAdapter(new MyrecyclercardAdaper(addressAndPhone));
        recyclerview.setHasFixedSize(true);
        recyclerviewforprice.setAdapter(new MyrecyclerpriceAdapter(routeAndPrice));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void onSetUp() {

        Bundle bundle = getIntent().getExtras();

        databaseHelper = new DatabaseHelper(this);
        id = bundle.getInt("id");
        if (id == 500) {
            idName = bundle.getString("GateName");
            gate = databaseHelper.getGateByName(idName);
            id = gate.getId();
        } else {
            gate = databaseHelper.getGateById(id);
        }

        name = gate.getName();
        routee = gate.getRoute();
        contact = gate.getContact();
        pricee = gate.getPrice();
        splitContact(contact);
        splitPrice(pricee);
    }
    private void splitContact(String text) {
        text = text.substring(1, text.length() - 1);
        addressAndPhone.clear();
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(text);

        while (m.find()) {
            // Log.i("Address : ", m.group(1));
            contactTV += m.group(1);
            addressAndPhone.add(m.group(1));
        }

    }


    private void splitPrice(String text) {
        text = text.substring(1, text.length() - 1);
        routeAndPrice.clear();
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(text);

        while (m.find()) {
            //  Log.i("Price : ", m.group(1));
            routeAndPrice.add(m.group(1));
        }
    }

}
