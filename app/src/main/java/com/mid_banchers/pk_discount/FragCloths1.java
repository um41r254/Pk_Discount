package com.mid_banchers.pk_discount;

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
import android.widget.Spinner;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.mid_banchers.pk_discount.R;

import java.util.ArrayList;
import java.util.List;


public class FragCloths1 extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvCloth1;
    ChipGroup chipGroupType;
    ChipGroup chipGroupSize;

    public FragCloths1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_cloths1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCloth1 = view.findViewById(R.id.recycler_cloth_1);
        chipGroupType = view.findViewById(R.id.chipGroupC);
        chipGroupSize = view.findViewById(R.id.chipGroupA);

        getData("formal shirt", "S");



        // Chip Group Type
        chipGroupType.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();
            if (checkedId == R.id.chip1c) {
                if (chipGroupSize.getCheckedChipId() == R.id.chip1a) {
                    getData("formal shirt", "S");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2a) {
                    getData("formal shirt", "M");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3a) {
                    getData("formal shirt", "L");
                }
            }

            if (checkedId == R.id.chip2c) {

                if (chipGroupSize.getCheckedChipId() == R.id.chip1a) {
                    getData("casual shirt", "S");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2a) {
                    getData("casual shirt", "M");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3a) {
                    getData("casual shirt", "L");
                }
            }
            if (checkedId == R.id.chip3c) {

                if (chipGroupSize.getCheckedChipId() == R.id.chip1a) {
                    getData("formal pent", "S");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2a) {
                    getData("formal pent", "M");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3a) {
                    getData("formal pent", "L");
                }
            }
            if (checkedId == R.id.chip4c) {

                if (chipGroupSize.getCheckedChipId() == R.id.chip1a) {
                    getData("causal pent", "S");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip2a) {
                    getData("casual pent", "M");
                }
                if (chipGroupSize.getCheckedChipId() == R.id.chip3a) {
                    getData("casual pent", "L");
                }
            }
        });


        // Chip Group Size
        chipGroupSize.setOnCheckedChangeListener((group, checkedId) -> {
            data.clear();

            if (checkedId == R.id.chip1a) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1c) {
                    getData("formal shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2c) {
                    getData("casual shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip3c) {
                    getData("formal pent", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip4c) {
                    getData("casual pent", "S");
                }
            }
            if (checkedId == R.id.chip2a) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1c) {
                    getData("formal shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2c) {
                    getData("casual shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip3c) {
                    getData("formal pent", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip4c) {
                    getData("casual pent", "S");
                }
            }
            if (checkedId == R.id.chip3a) {
                if (chipGroupType.getCheckedChipId() == R.id.chip1c) {
                    getData("formal shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip2c) {
                    getData("casual shirt", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip3c) {
                    getData("formal pent", "S");
                }
                if (chipGroupType.getCheckedChipId() == R.id.chip4c) {
                    getData("casual pent", "S");
                }
            }

        });


    }


    private void getData(String style, String size) {
        Query query;
        if (size.equals("null")) {

            query = db.collection("Products")
                    .whereEqualTo("category", "men")
                    .whereEqualTo("type", "clothes")
                    .whereEqualTo("style", style);
        } else {
            query = db.collection("Products")
                    .whereEqualTo("category", "men")
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
                    rvCloth1.setAdapter(adapter);
                    rvCloth1.setLayoutManager(new GridLayoutManager(getContext(), 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "getData: " + e.getMessage());
        });
    }


}