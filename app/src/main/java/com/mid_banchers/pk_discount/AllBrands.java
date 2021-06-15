package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class AllBrands extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView rvAllBrands;
    List<DataModelBrand> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_brands);

        rvAllBrands = findViewById(R.id.rvAllBrands);

        // Dummy data
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());
        data.add(new DataModelBrand());

        rvAllBrands.setAdapter(new AdapterBrands(this, data));
        rvAllBrands.setLayoutManager(new GridLayoutManager(this, 2));

        getBrands();
    }

    private void getBrands() {


        db.collection("Brands")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    data.clear();

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModelBrand.class));
                    }

                    rvAllBrands.setAdapter(new AdapterBrands(this, data));
                    rvAllBrands.setLayoutManager(new GridLayoutManager(this, 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "onFailure: " + e.getLocalizedMessage());
            Toast.makeText(AllBrands.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}