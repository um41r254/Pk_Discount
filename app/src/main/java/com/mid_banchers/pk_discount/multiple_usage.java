package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class multiple_usage extends AppCompatActivity {
CardView mul_u1;
ImageView filter_ly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_usage);
        mul_u1=findViewById(R.id.mul_u1);
        mul_u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(multiple_usage.this , product_detail.class);
                startActivity(intent);
            }
        });
        filter_ly = findViewById(R.id.filter_ly);
        filter_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(multiple_usage.this,filters.class);
                startActivity(intent);
            }
        });

    }
}