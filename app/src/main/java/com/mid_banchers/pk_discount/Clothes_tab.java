package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.pk_discount.Adapter.ClothesAdpater;
import com.mid_banchers.pk_discount.Adapter.HotAdapter;

public class Clothes_tab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_tab);
        TabLayout tabLayout_clothes = findViewById(R.id.tablayout_clothes);
        ViewPager2 viewPager_clothes = findViewById(R.id.pag_clothes);

        ClothesAdpater clothesAdpater = new ClothesAdpater(this);
        viewPager_clothes.setAdapter(clothesAdpater);
        new TabLayoutMediator(tabLayout_clothes,viewPager_clothes,(TabLayout.Tab tab, int position )-> {
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