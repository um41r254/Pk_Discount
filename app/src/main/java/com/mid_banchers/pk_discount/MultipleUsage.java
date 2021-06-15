package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.pk_discount.Adapter.TabAdapter;

public class MultipleUsage extends AppCompatActivity {

    public static int brandID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_usage);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.pager);

        TabAdapter adapter = new TabAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (TabLayout.Tab tab, int position) -> {
            if (position == 0) {
                tab.setText("MEN");
            }
            if (position == 1) {
                tab.setText("WOMEN");
            }
            if (position == 2) {
                tab.setText("KIDS");
            }

        }).attach();


    }
}