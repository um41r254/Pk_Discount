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


public class Tab2Fragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvHotDeals;
    ChipGroup chipGroupType;

    public Tab2Fragment() {
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

        query = db.collection("Products")
                .whereEqualTo("category", "women")
                .whereEqualTo("type", type)
                .whereEqualTo("brandId", MultipleUsage.brandID);

        Log.d("TAG", "getData(TABFRAG2): " + type);
        Log.d("TAG", "getData(TABFRAG2): brand ID " + MultipleUsage.brandID);

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