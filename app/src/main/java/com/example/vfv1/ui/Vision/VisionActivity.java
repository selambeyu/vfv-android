package com.example.vfv1.ui.Vision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.vfv1.R;
import com.example.vfv1.ui.training.CarrierPathFragment;
import com.example.vfv1.ui.training.CenterFragment;
import com.example.vfv1.ui.training.ProfessionalFragment;
import com.example.vfv1.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class VisionActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //TODO: STRINGS HAVE TO BE CHANGED FROM THE RESOURCE VALUE FOLDER - STRING
        adapter.addFragment(new Articles(), "Vision");
        adapter.addFragment(new Education(), "Education");
        adapter.addFragment(new vision(), "Vision");

        viewPager.setAdapter(adapter);
    }
}
