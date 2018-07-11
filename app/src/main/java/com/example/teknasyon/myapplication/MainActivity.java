package com.example.teknasyon.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ImageView r_button,l_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_button = (ImageView) findViewById(R.id.right_button);
        l_button = (ImageView) findViewById(R.id.left_button);

        r_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tab = mViewPager.getCurrentItem();
                tab ++;
                mViewPager.setCurrentItem(tab);

            }
        });

        l_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tab = mViewPager.getCurrentItem();
                tab --;
                mViewPager.setCurrentItem(tab);

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

}