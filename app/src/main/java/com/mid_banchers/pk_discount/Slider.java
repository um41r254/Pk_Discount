package com.mid_banchers.pk_discount;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.zip.Inflater;

public class Slider extends ArrayAdapter<String> {
    private Context context;
    private int resource;
    private List<String> list;



    public Slider(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createSliderView(position, convertView, parent);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createSliderView(position, convertView, parent);

    }


    private View createSliderView (int position, View convertView , ViewGroup parent){
        return LayoutInflater.from(context).inflate(resource,parent,false);
    }

}