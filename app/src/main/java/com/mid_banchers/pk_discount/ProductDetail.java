package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {

    TextView tvTitle, tvArticleNumber;
    ImageView ivMain;
    RecyclerView rvLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        tvTitle = findViewById(R.id.textView13);
        tvArticleNumber = findViewById(R.id.textView14);
        ivMain = findViewById(R.id.imageView4);
        rvLinks = findViewById(R.id.rvLinks);

        Log.d("TAG", "onCreate: " + MainActivity.productData.getArticleName());
        Log.d("TAG", "onCreate: " + MainActivity.productData.getCategory());
        Log.d("TAG", "onCreate: " + MainActivity.productData.getColor());


        tvTitle.setText(MainActivity.productData.getArticleName());
        tvArticleNumber.setText(MainActivity.productData.getArticleNo());
        Glide.with(this)
                .load(MainActivity.productData.getImage())
                .into(ivMain);

        rvLinks.setAdapter(new AdapterLinks(this, MainActivity.productData.getLink(), MainActivity.productData.getPrice()));
        rvLinks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}