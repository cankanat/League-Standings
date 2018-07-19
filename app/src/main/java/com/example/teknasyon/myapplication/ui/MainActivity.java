package com.example.teknasyon.myapplication.ui;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.teknasyon.myapplication.R;
import com.example.teknasyon.myapplication.ui.SectionsPagerAdapter;

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