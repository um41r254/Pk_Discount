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


public class FragTre1 extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvHotDeals;
    ChipGroup chipGroupType;

    public FragTre1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_hot1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHotDeals = view.findViewById(R.id.rvSingleBrand);
        chipGroupType = view.findViewById(R.id.groupX);


        getData("clothes");

        // Chip Group Type
        chipGroupType.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();
            if (checkedId == R.id.chip5) {
                getData("clothes");
            }
            if (checkedId == R.id.chip6) {
                getData("shoes");
            }
        });
    }

    private void getData(String type) {
        Query query;


        if (type.equals("shoes")) {

            query = db.collection("Products")
                    .whereEqualTo("category", "men")
                    .whereEqualTo("trending", true)
                    .whereEqualTo("type", type)
                    .whereEqualTo("size", "42");

        } else {
            query = db.collection("Products")
                    .whereEqualTo("category", "men")
                    .whereEqualTo("trending", true)
                    .whereEqualTo("type", type)
                    .whereEqualTo("size", "S");

        }
        Log.d("TAG", "getData(FragTrend1): " + type);

        query.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    Log.d("TAG", "getData: " + queryDocumentSnapshots.size());
                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }
                    AdapterRecycler adapter = new AdapterRecycler(getContext(), data);
                    rvHotDeals.setAdapter(adapter);
                    rvHotDeals.setLayoutManager(new GridLayoutManager(getContext(), 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "getData: " + e.getMessage());
        });
    }
}