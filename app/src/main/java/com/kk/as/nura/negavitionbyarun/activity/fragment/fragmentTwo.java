package com.kk.as.nura.negavitionbyarun.activity.fragment;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragmentTwo extends Fragment implements SearchView.OnQueryTextListener, View.OnClickListener {
    private FastScrollRecyclerView fragmenttworecyclerview;
    private SearchView searchview;
   private List<String> list;
    private MyFragmentTwoRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.twofragment, container, false);
        fragmenttworecyclerview= (FastScrollRecyclerView) v.findViewById(R.id.fragmenttworecyclerview);
        searchview= (SearchView) v.findViewById(R.id.searchview);
        searchview.setOnClickListener(this);
        searchview.setOnQueryTextListener(this);
        list=new ArrayList<>();
        DatabaseHelper database=new DatabaseHelper(getContext());
        list.addAll(database.getAllCities());
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        fragmenttworecyclerview.setHasFixedSize(true);
        fragmenttworecyclerview.setLayoutManager(manager);
        adapter=new MyFragmentTwoRecyclerAdapter(getActivity(),list);
        fragmenttworecyclerview.setAdapter(adapter);
        return v;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase().trim();
        List<String> list2=new ArrayList<>();
        for(String list1:list){
            if((list1.toLowerCase()).contains(newText)){
                list2.add(list1);
            }
        }
        adapter.setFliter(list2);
        return true;
    }

    @Override
    public void onClick(View view) {
        searchview.setIconified(false);
    }
}
