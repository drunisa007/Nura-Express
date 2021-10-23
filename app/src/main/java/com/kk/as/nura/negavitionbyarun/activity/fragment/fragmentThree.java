package com.kk.as.nura.negavitionbyarun.activity.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.activities.MyListImage;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.recyclerAdapters.MyrecyclerAdapter;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragmentThree extends Fragment  implements SearchView.OnQueryTextListener{
    private FastScrollRecyclerView recyclerview;
    private SearchView searchview;
    private MyrecyclerAdapter adapter;
    private List<String> list;
    private int id;
    private List<String> routelist;
    private SearchView searchviewthree;
    private List<String> listimage;
    private int[] arrayone;
    private int arraytwo[];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.threefragment, container, false);
        Log.d("arun","staring");
        recyclerview = (FastScrollRecyclerView) v.findViewById(R.id.fast_scrollerfragment);
        list = new ArrayList<>();
        listimage=new ArrayList<>();
        searchviewthree= (SearchView) v.findViewById(R.id.searchviewthree);
        searchviewthree.setOnQueryTextListener(this);
        DatabaseHelper database=new DatabaseHelper(getActivity());
        routelist=new ArrayList<>();
        arrayone= new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                R.drawable.a6,R.drawable.a7,R.drawable.a1,R.drawable.a9,R.drawable.a10,
                R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,
                R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,
                R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                R.drawable.a6,R.drawable.a7,R.drawable.a1,R.drawable.a9,R.drawable.a10
        };

      for(int x=0;x<3;x++) {
          for (int ii = 0; ii < 40; ii++) {
              Uri path1 = Uri.parse("android.resource://com.kk.as.nura.negavitionbyarun/" + arrayone[ii]);
              String url1 = path1.toString();
              listimage.add(url1);
          }

      }
        Uri path1 = Uri.parse("android.resource://com.kk.as.nura.negavitionbyarun/" +R.drawable.arun);
        String url1 = path1.toString();
        Log.d("arun", url1);
        listimage.add(url1);
        routelist.addAll(database.getAllRoute());
        list.addAll(database.getAllGateName());
        Log.d("arun", String.valueOf(list.size()));
        Log.d("arun", String.valueOf(listimage.size()));
        Log.d("arun", String.valueOf(routelist.size()));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layout);
        adapter= new MyrecyclerAdapter(list,id,getActivity(),routelist,listimage);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(adapter);
        return v;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase().trim();
        List<String> newlist=new ArrayList<>();
        for(String str:list){
            String name=str.toLowerCase().trim();
            if(name.contains(newText)){
                newlist.add(name);
            }


        }
        adapter.setFliter(newlist);

        return true;

    }


}