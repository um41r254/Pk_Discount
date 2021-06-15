package com.mid_banchers.pk_discount;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.chip.ChipGroup;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.mid_banchers.pk_discount.R;

import java.util.ArrayList;
import java.util.List;


public class FragShoe3 extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvShoe3;
    ChipGroup chipGroupType;
    ChipGroup chipGroupSize;

    public FragShoe3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_shoe1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvShoe3 = view.findViewById(R.id.recycler_shoe_1);
        chipGroupType = view.findViewById(R.id.chipGroupS);
        chipGroupSize = view.findViewById(R.id.chipGroupSS);

        getData("formal shoes", "42");


        // Chip Group Type
        chipGroupType.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();
            if (checkedId == R.id.chip1s) {
                if (chipGroupSize.getCheckedChipId() == R.id.chip1ss) {
                    getData("formal shoes", "42");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2ss) {
                    getData("formal shoes", "43");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3ss) {
                    getData("formal shoes", "44");
                }
            }

            if (checkedId == R.id.chip2s) {

                if (chipGroupSize.getCheckedChipId() == R.id.chip1ss) {
                    getData("casual shoes", "42");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2ss) {
                    getData("casual shoes", "43");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3ss) {
                    getData("casual shoes", "44");
                }
            }

        });


        // Chip Group Size
        chipGroupSize.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();

            if (checkedId == R.id.chip1ss) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1s) {
                    getData("formal shoes", "42");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2s) {
                    getData("casual shoes", "42");
                }

            }
            if (checkedId == R.id.chip2ss) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1s) {
                    getData("formal shoes", "43");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2s) {
                    getData("casual shoes", "43");
                }
            }
            if (checkedId == R.id.chip3ss) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1s) {
                    getData("formal shoes", "44");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2s) {
                    getData("casual shoes", "44");
                }
            }
        });

    }

    private void getData(String style, String size) {
        Query query;
        if (size.equals("null")) {

            query = db.collection("Products")
                    .whereEqualTo("category", "kids")
                    .whereEqualTo("type", "shoes")
                    .whereEqualTo("style", style);
        } else {
            query = db.collection("Products")
                    .whereEqualTo("category", "kids")
                    .whereEqualTo("type", "shoes")
                    .whereEqualTo("style", style)
                    .whereEqualTo("size", size);
        }

        Log.d("TAG", "getData: " + style + " " + size);

        query.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    Log.d("TAG", "getData: " + queryDocumentSnapshots.size());
                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }
                    AdapterRecycler adapter = new AdapterRecycler(getContext(), data);
                    rvShoe3.setAdapter(adapter);
                    rvShoe3.setLayoutManager(new GridLayoutManager(getContext(), 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "getData: " + e.getMessage());
        });
    }
}