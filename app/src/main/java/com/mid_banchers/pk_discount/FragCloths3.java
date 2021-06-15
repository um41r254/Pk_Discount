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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class FragCloths3 extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<DataModel> data = new ArrayList<>();
    RecyclerView rvCloth3;

    public FragCloths3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_cloths3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCloth3 = view.findViewById(R.id.recycler_kids_cloths);

        getData();

    }


    private void getData() {
        Query query;

        query = db.collection("Products")
                .whereEqualTo("category", "kids")
                .whereEqualTo("type", "clothes");
        query.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {

                    for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                        data.add(ds.toObject(DataModel.class));
                    }
                    AdapterRecycler adapter = new AdapterRecycler(getContext(), data);
                    rvCloth3.setAdapter(adapter);
                    rvCloth3.setLayoutManager(new GridLayoutManager(getContext(), 2));

                }).addOnFailureListener(e -> {
            Log.d("TAG", "getData: " + e.getMessage());
        });
    }
}
