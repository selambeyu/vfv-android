package com.example.vfv1.ui.training;

import android.os.Bundle;

import com.example.vfv1.R;
import com.example.vfv1.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class TrainingActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytrainingcenters);

//        if (getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        }
//
//        viewPager = findViewById(R.id.view_pager);
//        setupViewPager(viewPager);
//        tabLayout = findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

//        adapter.addFragment(new CenterFragment(), "Centers");
//        adapter.addFragment(new ProfessionalFragment(), "Professionals");
//        adapter.addFragment(new CarrierPathFragment(), "Carrier Path");

        viewPager.setAdapter(adapter);
    }
}