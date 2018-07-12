package com.example.teknasyon.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ImageView rButton, lButton, saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rButton = (ImageView) findViewById(R.id.right_ImageView);
        rButton.setOnClickListener(this);

        lButton = (ImageView) findViewById(R.id.left_ImageView);
        lButton.setOnClickListener(this);

        saveButton = (ImageView) findViewById(R.id.save_Button);
        saveButton.setOnClickListener(this);

        /*rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int plus_Tab = mViewPager.getCurrentItem();
                plus_Tab++;
                mViewPager.setCurrentItem(plus_Tab);

            }
        });

        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int minus_Tab = mViewPager.getCurrentItem();
                minus_Tab--;
                mViewPager.setCurrentItem(minus_Tab);

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    @Override
    public void onClick(View view) {
        int tab = mViewPager.getCurrentItem();

        switch (view.getId()) {
            case R.id.right_ImageView:
                tab++;
                mViewPager.setCurrentItem(tab);
                break;
            case R.id.left_ImageView:
                tab--;
                mViewPager.setCurrentItem(tab);
                break;
            default:
                break;

        }

    }
}