package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.model.Gates;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Chan Myae Thu on 8/3/2017.
 */

public class searchresultactivity extends AppCompatActivity {
    private FastScrollRecyclerView fast_scrollersearch;
    private int i=0;
    private List<String> routeandprice=new ArrayList<>();
    private String departcity,arrivalcity;
    private List<Gates> lstGate,foundGates = new ArrayList<>(), notFoundGates = new ArrayList<>();
    private String route;
    private boolean found = false;
    private ArrayList<ArrayList> alllist=new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private List<Gates> getlistfromroute = new ArrayList<>();
    private List<Gates> getlisttoroute = new ArrayList<>();
    private List<Gates> getfinallist = new ArrayList<>();
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Bundle bd= getIntent().getExtras();
        toolbar= (Toolbar) findViewById(R.id.toolbar);
       departcity= bd.getString("departcity");
        arrivalcity=bd.getString("arrivalcity");
        databaseHelper = new DatabaseHelper(this);
        lstGate = databaseHelper.getAllGates();
        getAllList();
        searchFrom(departcity);
        searchTo(arrivalcity);
        notFoundGates=getlistfromroute;

        if (searchFound()) {
            i=0;
            showRV(foundGates);
            setToolbar(departcity + " - " + arrivalcity);

        } else {
            i=1;
            showRV(notFoundGates);
            setToolbar(departcity);
            new MaterialDialog.Builder(this).title(R.string.titleNotFound).content(R.string.notFound).positiveText("Cancel").show();
        }

    }

    private void showRV(List<Gates> gates) {
        setContentView(R.layout.activitysearchresult);
        fast_scrollersearch = (FastScrollRecyclerView) findViewById(R.id.fast_scrollersearch);
        fast_scrollersearch.setHasFixedSize(true);
        fast_scrollersearch.setLayoutManager(new LinearLayoutManager(this));
        fast_scrollersearch.setAdapter(new SearchResultRVAdapter(gates,departcity,arrivalcity,i));

    }

    private boolean searchFound() {
        found = false;
        for (int i = 0; i < getlistfromroute.size(); i++) {

            for (int k = 0; k < getlisttoroute.size(); k++) {

                if (getlistfromroute.get(i).getRoute().equals(getlisttoroute.get(k).getRoute())) {
//
                    foundGates.add(getlistfromroute.get(i));
                    found = true;
                    break;
                }
            }

        }
        return found;
    }
    private void getAllList() {
        for (int i = 0; i < lstGate.size(); i++) {
            route = lstGate.get(i).getRoute();
            StringTokenizer st = new StringTokenizer(route, "-");
            ArrayList<String> namelist = new ArrayList<>();
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                namelist.add(name);
            }
            alllist.add(namelist);
        }
    }
    private void searchFrom(String deparcity) {
        for (int i = 0; i < alllist.size(); i++) {
            for (int j = 0; j < alllist.get(i).size(); j++) {
                if (departcity.equals(alllist.get(i).get(j))) {
                    getlistfromroute.add(lstGate.get(i));
                    break;
                }
            }
        }
    }

    private void searchTo(String acity) {
        for (int i = 0; i < alllist.size(); i++) {
            for (int j = 0; j < alllist.get(i).size(); j++) {
                if (acity.equals(alllist.get(i).get(j))) {
                    getlisttoroute.add(lstGate.get(i));

                    break;
                }
            }
        }
    }
    private void setToolbar(String name) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
