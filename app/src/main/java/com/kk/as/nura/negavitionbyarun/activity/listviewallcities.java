package com.kk.as.nura.negavitionbyarun.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class listviewallcities extends AppCompatActivity {
   private FastScrollRecyclerView re;
    private List<String> list;
    private DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewallcities);
        re= (FastScrollRecyclerView) findViewById(R.id.fastscrollallgate);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        re.setLayoutManager(manager);
        re.setHasFixedSize(true);
        database=new DatabaseHelper(this);
        list=new ArrayList<>();
        list.addAll(database.getAllCities());
        re.setAdapter(new MyFastAdapter(list));

    }
}
