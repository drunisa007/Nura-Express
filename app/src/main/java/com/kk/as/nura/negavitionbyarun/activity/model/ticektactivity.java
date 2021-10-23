package com.kk.as.nura.negavitionbyarun.activity.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.kk.as.nura.negavitionbyarun.R;

/**
 * Created by Chan Myae Thu on 8/5/2017.
 */

public class ticektactivity extends AppCompatActivity {
    private TextView textviewGatename,textviewJourney,textviewseatnumber;
    private String departcity,arrivalcity,seatnumber;
    private final static String shared="codo";
    private ImageView qrcodeimageview;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("arun","oncrete isworkig");
        setContentView(R.layout.activity_ticket);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("YOUR TICKET");
            SharedPreferences spp =getSharedPreferences(shared, Context.MODE_PRIVATE);
            if (spp!= null) {
                departcity = spp.getString("departcity","erroe happen");
                arrivalcity = spp.getString("arrivalcity","error happen");
                seatnumber = spp.getString("seatnumber","error happen");
            }


        textviewGatename= (TextView) findViewById(R.id.textviewGatename);
        textviewJourney= (TextView) findViewById(R.id.textviewJourney);
        textviewseatnumber=(TextView) findViewById(R.id.textviewseatnumber);
        qrcodeimageview=(ImageView)  findViewById(R.id.qrcodeimageview);
        Bundle bd=getIntent().getExtras();
        if(bd!=null){
       departcity=bd.getString("departcity");
        arrivalcity=bd.getString("arrivalcity");
        seatnumber=bd.getString("seatnumber");}
        textviewGatename.setText(departcity);
        textviewJourney.setText(departcity+" to "+arrivalcity);
        textviewseatnumber.setText(seatnumber);
        generateqrcode();

        SharedPreferences spf=getSharedPreferences(shared,MODE_PRIVATE);
        SharedPreferences.Editor editor=spf.edit();
        editor.putString("departcity",departcity);
        editor.putString("arrivalcity",arrivalcity);
        editor.putString("seatnumber",seatnumber);
        editor.commit();


    }

    private void generateqrcode() {
        MultiFormatWriter multi=new MultiFormatWriter();
        try{
            String all=departcity+"\n"+arrivalcity+"\n"+seatnumber;
            BitMatrix bitmatrix=multi.encode(all, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeencoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeencoder.createBitmap(bitmatrix);
            qrcodeimageview.setImageBitmap(bitmap);
        }
        catch (WriterException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
            return super.onOptionsItemSelected(item);

        }
    }

