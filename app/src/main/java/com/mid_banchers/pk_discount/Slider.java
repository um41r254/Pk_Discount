package com.mid_banchers.pk_discount;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.slider.RangeSlider;

import java.util.List;

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

    @Override
    public boolean isEnabled(int position) {
        if (position==0){

            return false;
        }else

        return true;
    }

    private View createSliderView (int position, View convertView , ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        RangeSlider rangeSlider = view.findViewById(R.id.range_slider);
        rangeSlider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull RangeSlider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                rangeSlider.getValues();
                Toast.makeText(context, "q" + rangeSlider.getValues(), Toast.LENGTH_SHORT).show();

            }
        });
        View price = LayoutInflater.from(context).inflate(R.layout.price_lay, parent, false);
        if (position == 0){


          return price;

   }else


            return view;
        }
    }
