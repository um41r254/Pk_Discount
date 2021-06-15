package com.mid_banchers.pk_discount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Button arrow1, arrow2, arrow3;
    CardView tre1, tre2, brn1, brn2, men_c, men_sh, women_c, women_sh, kid_c, kid_sh;
    ImageView imghot1;

    ImageView ivTrend1, ivTrend2;
    RecyclerView rvHotDeals;
    RecyclerView rvTrending;
    RecyclerView rvBrands;


    // Saving single product data
    public static DataModel productData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHotDeals = findViewById(R.id.rvHome);
        rvTrending = findViewById(R.id.rvTrending);
        rvBrands = findViewById(R.id.rvBrands);

        getHotDeals();
        getTrending();
        getBrands();


        arrow1 = findViewById(R.id.button1);
        arrow2 = findViewById(R.id.button2);
        arrow3 = findViewById(R.id.button3);
        arrow1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HotDeals.class);
            startActivity(intent);
        });
        arrow2.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Trending", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Trending.class);
            startActivity(intent);

        });
        arrow3.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Brands", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AllBrands.class);
            startActivity(intent);
        });

        men_c = findViewById(R.id.men_c);
        women_c = findViewById(R.id.women_c);
        kid_c = findViewById(R.id.kid_c);
        men_c.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Mens Clothes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ClothesTab.class);
            startActivity(intent);
        });
        women_c.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Women Clothes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ClothesTab.class);
            startActivity(intent);
        });
        kid_c.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Kids Cloths", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ClothesTab.class);
            startActivity(intent);
        });
        men_sh = findViewById(R.id.men_sh);
        women_sh = findViewById(R.id.women_sh);
        kid_sh = findViewById(R.id.kid_sh);

        men_sh.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Mens Shoes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShoeTab.class);
            startActivity(intent);
        });
        women_sh.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Women Shoes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShoeTab.class);
            startActivity(intent);
        });
        kid_sh.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Kids Shoes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShoeTab.class);
            startActivity(intent);
        });

    }

    private void getBrands() {

        List<DataModelBrand> data = new ArrayList<>();
        // Dummy data
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());

        rvBrands.setAdapter(new AdapterBrands(this, data));
        rvBrands.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        db.collection("Brands")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    data.clear();

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModelBrand.class));
                    }

                    rvBrands.setAdapter(new AdapterBrands(this, data));
                    rvBrands.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "onFailure: " + e.getLocalizedMessage());
            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    private void getTrending() {

        List<DataModel> data = new ArrayList<>();
        // Dummy data
        data.add(new DataModel());
        data.add(new DataModel());
        data.add(new DataModel());

        rvTrending.setAdapter(new AdapterMain(this, data));
        rvTrending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        db.collection("Products")
                .whereEqualTo("trending", true)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    data.clear();

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }

                    rvTrending.setAdapter(new AdapterMain(this, data));
                    rvTrending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "onFailure: " + e.getLocalizedMessage());
            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });

    }


    private void getHotDeals() {

        List<DataModel> data = new ArrayList<>();
        // Dummy data
        data.add(new DataModel());
        data.add(new DataModel());
        data.add(new DataModel());

        rvHotDeals.setAdapter(new AdapterMain(this, data));
        rvHotDeals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        db.collection("Products")
                .whereEqualTo("hot_deals", true)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    data.clear();

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }

                    rvHotDeals.setAdapter(new AdapterMain(this, data));
                    rvHotDeals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "onFailure: " + e.getLocalizedMessage());
            Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });

    }
}