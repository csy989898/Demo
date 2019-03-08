package com.example.mayn.elevatorapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.mayn.elevatorapplication.Fragment.CleancircleFragment;
import com.example.mayn.elevatorapplication.Fragment.HomeFragment;
import com.example.mayn.elevatorapplication.Fragment.MessgeFragment;
import com.example.mayn.elevatorapplication.Fragment.MineFragment;
import com.example.mayn.elevatorapplication.Fragment.ToolsFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 5;
    private Fragment myFragment1 = null;
    private Fragment myFragment2 = null;
    private Fragment myFragment3 = null;
    private Fragment myFragment4 = null;
    private Fragment myFragment5 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new HomeFragment();
        myFragment2 = new MessgeFragment();
        myFragment3 = new ToolsFragment();
        myFragment4 = new CleancircleFragment();
        myFragment5 = new MineFragment();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
            case MainActivity.PAGE_FIVE:
                fragment = myFragment5;
                break;
        }
        return fragment;
    }


}

