package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.pk_discount.Adapter.HotAdapter;
import com.mid_banchers.pk_discount.Adapter.ShoeAdapter;

public class Shoe_tab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_tab);
        TabLayout tabLayout_shoe = findViewById(R.id.tablayout_shoe);
        ViewPager2 viewPager_shoe = findViewById(R.id.pag_shoe);

        ShoeAdapter shoeAdapter = new ShoeAdapter(this);
        viewPager_shoe.setAdapter(shoeAdapter);
        new TabLayoutMediator(tabLayout_shoe,viewPager_shoe,(TabLayout.Tab tab, int position )-> {
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