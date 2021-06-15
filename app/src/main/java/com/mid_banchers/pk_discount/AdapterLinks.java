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

public class AdapterLinks extends RecyclerView.Adapter<AdapterLinks.ViewHolder> {

    Context context;
    List<String> links;
    List<Double> price;

    public AdapterLinks(Context context, List<String> links, List<Double> price) {
        this.context = context;
        this.links = links;
        this.price = price;
    }

    @NonNull
    @Override
    public AdapterLinks.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_links, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLinks.ViewHolder holder, int position) {

        // Links
        holder.tvLinks.setText(links.get(position));
        // Prices
        holder.tvPrice.setText(String.valueOf(price.get(position).intValue()).concat("/-"));

    }

    @Override
    public int getItemCount() {
        return links.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLinks;
        TextView tvPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLinks = itemView.findViewById(R.id.link_text1_2);
            tvPrice = itemView.findViewById(R.id.link_text1_3);


        }
    }
}
