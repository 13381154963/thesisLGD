package com.baidu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */

public class MyFragmentAdpter extends FragmentPagerAdapter{

    public MyFragmentAdpter(FragmentManager fm) {
        super(fm);
    }

    List<Fragment> list=new ArrayList<>();

    public void addFragment(Fragment fragment){
        if(fragment!=null){
            this.list.add(fragment);
        }
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
