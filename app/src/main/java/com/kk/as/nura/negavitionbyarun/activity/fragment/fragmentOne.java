package com.kk.as.nura.negavitionbyarun.activity.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.TopUP;
import com.kk.as.nura.negavitionbyarun.activity.activities.searchresultactivity;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.listviewallcities;
import com.kk.as.nura.negavitionbyarun.activity.seatactivites.seatRow11;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class fragmentOne extends Fragment implements View.OnClickListener{
   private CardView cardview1,cardview2,cardview3;
   private Button button;
    private List<String> list;
    private  String departcity;
    private String arrivalcity;
    private TextView depart,arrival;
    private ViewPager viewPager;
    private String[] text1;
    private DatabaseHelper database;
    DatePickerDialog datePickerDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.onefragment, container, false);
        cardview1= (CardView) v.findViewById(R.id.cardview1);
        cardview2= (CardView) v.findViewById(R.id.cardview2);
        cardview3= (CardView) v.findViewById(R.id.cardview3);
        cardview1.setOnClickListener(this);
        cardview2.setOnClickListener(this);
        cardview3.setOnClickListener(this);
        depart= (TextView) v.findViewById(R.id.depart);
         arrival= (TextView) v.findViewById(R.id.arrival);
        button= (Button) v.findViewById(R.id.button);
        button.setOnClickListener(this);
        text1= new String[]{"aung", "thu", "aye", "this is all for now"};
        database=new DatabaseHelper(getContext());
        list=new ArrayList<>();
        list.addAll(database.getAllCities());
        viewPager= (ViewPager) v.findViewById(R.id.viewpager);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardview1:depart();break;
            case R.id.cardview2:arrival();break;
            case R.id.cardview3:
                time();
                break;
            case R.id.button:seat();
                break;
        }

    }

    private void time() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();


}




    private void arrival() {
        new MaterialDialog.Builder(getContext()).items(list)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        arrivalcity = text.toString();
                        arrival.setText(arrivalcity);
                    }
                })
                .show();
    }

    private void depart() {
        new MaterialDialog.Builder(getContext()).items(list)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        departcity = text.toString();
                        depart.setText(departcity);
                    }
                })
                .show();
    }



    private void seat() {
        if(departcity==null||arrivalcity==null){
            Toast.makeText(getView().getContext(),"please choose city", Toast.LENGTH_SHORT).show();
        }
        else if(departcity==arrivalcity){
            Toast.makeText(getView().getContext(),"please choose different city", Toast.LENGTH_SHORT).show();
        }
        else if(departcity!=null&&arrivalcity!=null){
            Toast.makeText(getView().getContext(),"Successful", Toast.LENGTH_SHORT).show();
            Bundle bd=new Bundle();
            bd.putString("departcity",departcity);
            bd.putString("arrivalcity",arrivalcity);
            Intent intent=new Intent(getActivity(),searchresultactivity .class);
            intent.putExtras(bd);
            startActivity(intent);

        }

    }
}

/*
*/
