package com.mid_banchers.pk_discount;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.slider.RangeSlider;

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


    private View createSliderView (int position, View convertView , ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(resource, parent, false);

        RangeSlider rangeSlider = view.findViewById(R.id.range_slider);
        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                Toast.makeText(context, "VAl"+ value, Toast.LENGTH_SHORT).show();
            }
        });





            return view;
        }
    }
