package com.kk.as.nura.negavitionbyarun.activity.fragmentAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentFour;
import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentOne;
import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentThree;
import com.kk.as.nura.negavitionbyarun.activity.fragment.fragmentTwo;

public class MyAdapter extends FragmentPagerAdapter{
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:fragment=new fragmentOne();
                break;
            case 1:fragment=new fragmentTwo();
                    break;
            case 2:fragment=new fragmentThree();
                        break;
            case 3:fragment=new fragmentFour();
        }

        return fragment;
    }

    @Override
    public int getCount() {
         return 4;
    }
}
