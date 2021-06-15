package com.mid_banchers.pk_discount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;


public class FragCloths2 extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvCloth2;
    ChipGroup chipGroupType;
    ChipGroup chipGroupSize;

    public FragCloths2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_cloths2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCloth2 = view.findViewById(R.id.recycler_cloth_2);
        chipGroupType = view.findViewById(R.id.chipGroupX);
        chipGroupSize = view.findViewById(R.id.chipGroupy);

        getData("stitched", "S");


        // Chip Group Type
        chipGroupType.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();
            if (checkedId == R.id.chip1X) {
                chipGroupSize.setVisibility(View.VISIBLE);
                if (chipGroupSize.getCheckedChipId() == R.id.chip1y) {
                    getData("stitched", "S");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2y) {
                    getData("stitched", "M");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3y) {
                    getData("stitched", "L");
                }


            }
            if (checkedId == R.id.chip2X) {

                chipGroupSize.setVisibility(View.GONE);
                getData("unstitch", "null");
            }
        });


        // Chip Group Size
        chipGroupSize.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();
            if (checkedId == R.id.chip1y) {
                getData("stitched", "S");
            }
            if (checkedId == R.id.chip2y) {
                getData("stitched", "M");
            }
            if (checkedId == R.id.chip3y) {
                getData("stitched", "L");
            }

        });


    }

    private void getData(String style, String size) {
        Query query;
        if (size.equals("null")) {

            query = db.collection("Products")
                    .whereEqualTo("category", "women")
                    .whereEqualTo("type", "clothes")
                    .whereEqualTo("style", style);
        } else {
            query = db.collection("Products")
                    .whereEqualTo("category", "women")
                    .whereEqualTo("type", "clothes")
                    .whereEqualTo("style", style)
                    .whereEqualTo("size", size);
        }


        query.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }


                    AdapterRecycler adapter = new AdapterRecycler(getContext(), data);
                    rvCloth2.setAdapter(adapter);
                    rvCloth2.setLayoutManager(new GridLayoutManager(getContext(), 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "getData: " + e.getMessage());
        });
    }
}