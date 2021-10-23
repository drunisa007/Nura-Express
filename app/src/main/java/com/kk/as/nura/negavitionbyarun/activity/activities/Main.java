package com.kk.as.nura.negavitionbyarun.activity.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.about;
import com.kk.as.nura.negavitionbyarun.activity.database.DatabaseHelper;
import com.kk.as.nura.negavitionbyarun.activity.fragmentAdapters.MyAdapter;
import com.kk.as.nura.negavitionbyarun.activity.model.Setting;
import com.kk.as.nura.negavitionbyarun.activity.seatactivites.seatRow11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {
    private Toolbar toolbar;
    private NavigationView navigview;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DatabaseHelper mdbHelper;
    private int i=1;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createDatabase();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigview = (NavigationView) findViewById(R.id.nevigationview);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        navigview.setNavigationItemSelectedListener(this);
        tabLayout.getTabAt(0).setIcon(R.drawable.hometap);
        tabLayout.getTabAt(1).setIcon(R.drawable.citychurch);
        tabLayout.getTabAt(2).setIcon(R.drawable.bustap);
        tabLayout.getTabAt(3).setIcon(R.drawable.contacttap);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            tabLayout.getTabAt(0).getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.tapclick), PorterDuff.Mode.SRC_IN);
             Log.d("arun","tablyout if working");

        }
        else{
            tabLayout.setSelectedTabIndicatorHeight(5);
            Log.d("arun","tablyout else if workding");
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else {

            if(viewPager.getCurrentItem()!=0){
            viewPager.setCurrentItem(0,true);}
            else {
                onExit();
            }
        }
    }

    private void onExit() {
        if(viewPager.getCurrentItem()==0) {
            new MaterialDialog.Builder(this)
                    .title("Exit")
                    .content("Are u sure want to exit")
                    .positiveText("Exit")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(MaterialDialog dialog, DialogAction which) {
                            finishAffinity();
                        }
                    })
                    .negativeText("Cancel")
                    .show();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.item2:
                viewPager.setCurrentItem(2);
                break;
            case R.id.item3:
                viewPager.setCurrentItem(1);
                break;
            case R.id.atm:
                startActivity(new Intent(getApplicationContext(), Setting.class));
                break;
            case R.id.item4:
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"arun@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose an Email Client"));
                break;
            case R.id.item5:
               startActivity(new Intent(this,about.class));
                break;
            case R.id.item6:
                new MaterialDialog.Builder(this)
                        .title("Exit")
                        .content("Are u sure want to exit")
                        .positiveText("Exit")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                finishAffinity();
                            }
                        })
                        .negativeText("Cancel")
                        .show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
        int color = ContextCompat.getColor(getApplicationContext(), R.color.tapclick);
        tab.getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);}

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            int color = ContextCompat.getColor(getApplicationContext(), R.color.black);
            tab.getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void createDatabase() {
        mdbHelper = new DatabaseHelper(this);

        File database = getApplicationContext().getDatabasePath(mdbHelper.DBName);
        if (false == database.exists()) {
            mdbHelper.getReadableDatabase();
            if (copyDatabase(this)) {
            } else {
            }
        }
    }

    private boolean copyDatabase(Context context) {
        try {
            InputStream myInput = context.getAssets().open(mdbHelper.DBName);
            String outFileName = mdbHelper.DBLocatoin + mdbHelper.DBName;
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length = 0;

            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
