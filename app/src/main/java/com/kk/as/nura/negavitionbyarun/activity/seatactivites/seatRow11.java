package com.kk.as.nura.negavitionbyarun.activity.seatactivites;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.TopUP;
import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentFour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun on 7/22/17.
 */

public class seatRow11 extends AppCompatActivity {
    private TextView textviewforseatroute,textviewforchooseseat,textviewseatchoose;
    private String departcity,arrivalcity;
    private String url2,url1;
    String routeprice;
    private String gatename;
    private TopUP.FragmentCommunication fragmentCommunication;
    private String s=" ";
    Button buttonbuy;
    private String[] text;
    private List<TempCard> list;
    private int seatnumberinterger;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seatrow11);
        textviewforseatroute= (TextView) findViewById(R.id.textviewforseatroute);
        textviewforchooseseat=(TextView)  findViewById(R.id.textviewforchooseseat);
        textviewforchooseseat=(TextView)  findViewById(R.id.textviewforchooseseat);
        textviewseatchoose=(TextView)  findViewById(R.id.textviewseatchoose);
        buttonbuy= (Button) findViewById(R.id.buttonbuy);
        buttonbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        if(s!=null){
            Buy();
        }
                else{
                    Toast.makeText(seatRow11.this,"you have to choose seat", Toast.LENGTH_SHORT).show();
                }

            }
        });
         text= new String[]{"NURA CARD", "KAZ CARD"};
        Uri path=Uri.parse("android.resource://com.kk.as.nura.negavitionbyarun/"+R.drawable.adver2);
        url2=path.toString();
        Uri path1=Uri.parse("android.resource://com.kk.as.nura.negavitionbyarun/"+R.drawable.atmcardkbz);
        url1=path1.toString();
         list=new ArrayList<>();
        list.add(new TempCard(url1,text[0]));
        list.add(new TempCard(url2,text[1]));

        url2=path.toString();
        Bundle bd= getIntent().getExtras();
        if(bd!=null){
        departcity=bd.getString("departcity");
        arrivalcity=bd.getString("arrivalcity");
            routeprice=bd.getString("routeprice");
            gatename=bd.getString("gatename");
        textviewforseatroute.setText(" From "+ departcity+" To "+ arrivalcity);}
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onButtonClick(View v){
        vibrator();
        int id=v.getId();
         s=" ";
        switch (id){
            case R.id.one:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.two:
                s="2";
                break;
            case R.id.three:
                s="3";
                break;
            case R.id.four:
                s="4";
                break;
            case R.id.five:
                s="5";
                break;
            case R.id.six:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.seven:s="7";
                break;
            case R.id.eight:s="8";
                break;
            case R.id.nine:s="9";
                break;
            case R.id.ten:s="10";
                break;
            case R.id.eleven:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.twelve:s="12";
                break;
            case R.id.thirteen:s="13";
                break;
            case R.id.fourteen:s="14";
                break;
            case R.id.fifthteen:s="15";
                break;
            case R.id.sixteen:s="16";
                break;
            case R.id.seventeen:s="17";
                break;
            case R.id.eighteen:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.nighteen:s="19";
                break;
            case R.id.tweenty:s="20";
                break;
            case R.id.tweentyone:s="21";
                break;
            case R.id.tweentytwo:s="22";
                break;
            case R.id.tweentythree:s="23";
                break;
            case R.id.tweentyfour:s="24";
                break;
            case R.id.tweentyfive:s="25";
                break;
            case R.id.tweentysix:s="26";
                break;
            case R.id.tweentyseven:s="27";
                break;
            case R.id.tweentyeight:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.tweentynine:
                Toast.makeText(this,"u cannot choose seat one already booked", Toast.LENGTH_SHORT).show();
                s=null;
                break;
            case R.id.thirty:s="30";
                break;
            case R.id.thirtytone:s="31";
                break;
            case R.id.thirytwo:s="32";
                break;
            case R.id.thirtythree:s="33";
                break;
            case R.id.thirtyfour:s="34";
                break;
            case R.id.thirtyfive:s="35";
                break;
            case R.id.thirtysix:s="36";
                break;
            case R.id.thirtyseven:s="37";
                break;
            case R.id.thirtyeight:s="38";
                break;
            case R.id.thirtynine:s="39";
                break;
            case R.id.fourty:s="40";
                break;
            case R.id.driver:
                Toast.makeText(this,"I AM DRIVER", Toast.LENGTH_SHORT).show();
                s=null;
                break;
        }
        Log.d("arun","parse is working");
        textviewforchooseseat.setText("You Choose Seat Number " +s);
        textviewseatchoose.setText("You Choose Seat Number " +s);
    }

    private void Buy() {
        Bundle bd=new Bundle();
        bd.putInt("one",1);
        Log.i("arun","buy is workding");
        fragmentFour frg=new fragmentFour();
        frg.setArguments(bd);
        String name=" From "+departcity+" To "+arrivalcity+". "+" seat number is "+ s+". price is "+routeprice;
        new MaterialDialog.Builder(seatRow11.this)
                .title("choose your card")
                .content(name)
                .adapter(new TopUP(list,this,name,fragmentCommunication,departcity,arrivalcity,s),null)
                .negativeText("Cancel").show();
    }

    private void vibrator() {
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(90);
    }


}
