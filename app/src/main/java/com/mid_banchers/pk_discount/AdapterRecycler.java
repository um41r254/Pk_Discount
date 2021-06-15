package com.mid_banchers.pk_discount;

import android.content.Context;
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

// Adapter
public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    Context context;
    List<DataModel> data;

    public AdapterRecycler(Context context, List<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_cloths, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Image
        Glide.with(context)
                .load(data.get(position).getImage())
                .into(holder.ivMain);

        // Article Name
        holder.tvArticleName.setText(data.get(position).getArticleName());

        // Article Number
        holder.tvArticleNumber.setText(data.get(position).getArticleNo());

        // Price
        holder.tvPrice.setText(String.valueOf(data.get(position).getPrice().get(0).intValue()).concat("/-"));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMain;
        TextView tvArticleName;
        TextView tvArticleNumber;
        TextView tvPrice;
        CardView cv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMain = itemView.findViewById(R.id.imageView);
            tvArticleName = itemView.findViewById(R.id.textView6);
            tvArticleNumber = itemView.findViewById(R.id.textView7);
            tvPrice = itemView.findViewById(R.id.textView8);
            cv = itemView.findViewById(R.id.mul_u1);

        }
    }
}
