package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.kk.as.nura.negavitionbyarun.R;

import org.w3c.dom.Text;

public class CityLayout extends AppCompatActivity {
    private Toolbar toolbarforcitylayout;
    private String cityName;
    private TextView textviewforcitylayout,textviewgeographycitylayout;
    private ImageView imageviewforcitylayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citylayout);
        textviewforcitylayout= (TextView) findViewById(R.id.textviewcitylayout);
        textviewgeographycitylayout=(TextView)  findViewById(R.id.textviewgeographycitylayout);
        imageviewforcitylayout=(ImageView)  findViewById(R.id.imageviewcitylayout);
        Bundle bd=getIntent().getExtras();
        toolbarforcitylayout= (Toolbar) findViewById(R.id.toolbarforcitylayout);
        setSupportActionBar(toolbarforcitylayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cityName=bd.getString("cityName");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(cityName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
