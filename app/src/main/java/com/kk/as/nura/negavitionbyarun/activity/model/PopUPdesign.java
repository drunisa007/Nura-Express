package com.kk.as.nura.negavitionbyarun.activity.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.model.topupdialog;

/**
 * Created by Aung Thu on 7/31/2017.
 */

public class PopUPdesign extends AppCompatActivity implements View.OnClickListener,topupdialog.onCompleteListener {
    private  Button topupbutton;
    private Toolbar toolbar;
    private ImageView imageviewatmcard;
    private TextView textviewusernamepopup,textviewbalancepopup;
    private String balance;
    private int bal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupdesign);
        textviewbalancepopup=(TextView) findViewById(R.id.textviewbalancepopup);
        if(savedInstanceState==null){
        SharedPreferences spf=getSharedPreferences("codedo",MODE_PRIVATE);
        if(spf!=null) {
            bal = spf.getInt("bal",0);
            textviewbalancepopup.setText(String.valueOf(bal).toString()+" Kyats");
        }
            else if(spf==null){
            Log.d("arun", "spf is  null");

        }
        }
        imageviewatmcard= (ImageView) findViewById(R.id.imageviewatmcard);
        textviewusernamepopup=(TextView)  findViewById(R.id.textviewusernamepopup);
        textviewbalancepopup=(TextView) findViewById(R.id.textviewbalancepopup);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data Of Card");
        topupbutton= (Button) findViewById(R.id.topupbutton);
        topupbutton.setOnClickListener(this);
        Bundle bd=getIntent().getExtras();
      int i=  bd.getInt("one");
        if(i==1){
        imageviewatmcard.setImageResource(R.drawable.adver2);}
        else if(i==2){
            imageviewatmcard.setImageResource(R.drawable.atmcardkbz);
        }

    }


    @Override
    public void onClick(View view) {
        topupdialog dialog=new topupdialog();
        getSupportFragmentManager().beginTransaction().add(dialog,"dialog").commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onComplete(String balance) {
        this.balance=balance;
        bal+=Integer.parseInt(this.balance);
        textviewbalancepopup.setText(String.valueOf(bal).toString()+" Kyats");
        SharedPreferences sharedPreferences=getSharedPreferences("codedo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("bal",bal);
        editor.commit();



    }



}
