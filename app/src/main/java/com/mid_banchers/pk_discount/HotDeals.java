package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.pk_discount.Adapter.HotAdapter;

public class HotDeals extends AppCompatActivity {
    CardView card1;
    TabLayout tabs;
    TabItem men, women, kids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_deals);

        TabLayout tabLayout_hot = findViewById(R.id.tabLayout_hot);
        ViewPager2 viewPager_hot = findViewById(R.id.pag_hot);

        HotAdapter hotAdapter = new HotAdapter(this);
        viewPager_hot.setAdapter(hotAdapter);
        new TabLayoutMediator(tabLayout_hot, viewPager_hot, (TabLayout.Tab tab, int position) -> {
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