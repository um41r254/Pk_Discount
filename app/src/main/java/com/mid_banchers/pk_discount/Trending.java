package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.pk_discount.Adapter.TreAdapter;

public class Trending extends AppCompatActivity {
CardView tre1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

//        tre1=findViewById(R.id.tre1);
//        tre1.setOnClickListener(v -> {
//            Intent intent = new Intent(trending.this , product_detail.class);
//            startActivity(intent);
//        });

        TabLayout tabLayout_tri = findViewById(R.id.tabLayout_tre);
        ViewPager2 viewPager_tri =findViewById(R.id.pag_tre);
        TreAdapter treAdapter = new TreAdapter(this);
        viewPager_tri.setAdapter(treAdapter);
        new TabLayoutMediator(tabLayout_tri,viewPager_tri,(TabLayout.Tab tab, int position) -> {

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