package com.mid_banchers.pk_discount;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterBrands extends RecyclerView.Adapter<AdapterBrands.ViewHolder> {

    Context context;
    List<DataModelBrand> data;

    public AdapterBrands(Context context, List<DataModelBrand> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterBrands.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_brands, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBrands.ViewHolder holder, int position) {

        // Image
        Glide.with(context)
                .load(data.get(position).getImage())
                .into(holder.ivImage);

        // Text
        holder.tvName.setText(data.get(position).brandName);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        CardView cv;
        TextView tvName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.imageView5);
            tvName = itemView.findViewById(R.id.textView9);
            cv = itemView.findViewById(R.id.brand_1);

            cv.setOnClickListener(view -> {

                MultipleUsage.brandID = data.get(getAdapterPosition()).id.intValue();
                context.startActivity(new Intent(context, MultipleUsage.class));
            });

        }
    }
}