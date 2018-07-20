package com.example.teknasyon.myapplication.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter  {

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int ligID;
            if(position == 0) {
                ligID = 1204;
            } else if(position == 1) {
               ligID = 1425;
            } else if (position == 2){
                ligID = 1269;
            } else {
                ligID = 1399;
            }
            return PlaceholderFragment.newInstance(ligID);
        }

        @Override
        public int getCount() {
            return 4;
        }



}