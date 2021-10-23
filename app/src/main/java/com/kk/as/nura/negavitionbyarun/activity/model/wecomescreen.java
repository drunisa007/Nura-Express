package com.kk.as.nura.negavitionbyarun.activity.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.Main;

public class wecomescreen extends AppCompatActivity {
private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecomescreen);

        SharedPreferences spf=this.getSharedPreferences("welcomescreen",MODE_PRIVATE);
        if(spf!=null) {
            i = spf.getInt("three", 9);
        }
        if(i!=1) {
            SharedPreferences spf1=this.getSharedPreferences("welcomescreen",MODE_PRIVATE);
            SharedPreferences.Editor editor=spf1.edit();
            editor.putInt("three",1);
            editor.commit();

            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent i = new Intent(wecomescreen.this, Main.class);
                        startActivity(i);
                    }
                }
            };
            thread.start();
        }
        else if(i==1){
            Intent i=new Intent(wecomescreen.this,Main.class);
            startActivity(i);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    }

