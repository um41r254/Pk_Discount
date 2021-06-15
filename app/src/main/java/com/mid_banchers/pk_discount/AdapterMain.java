package com.mid_banchers.pk_discount;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    Context context;
    List<DataModel> data;

    public AdapterMain(Context context, List<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_main, parent, false);
        AdapterMain.ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMain.ViewHolder holder, int position) {

        // Image
        Glide.with(context)
                .load(data.get(position).getImage())
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        CardView cv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.imghot1);
            cv = itemView.findViewById(R.id.hotdeals1);

            cv.setOnClickListener(view -> {

                MainActivity.productData = data.get(getAdapterPosition());
                context.startActivity(new Intent(context, ProductDetail.class));

            });

        }
    }
}
