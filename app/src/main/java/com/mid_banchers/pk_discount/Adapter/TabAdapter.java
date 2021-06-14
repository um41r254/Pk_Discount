package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.Tab1Fragment;
import com.mid_banchers.pk_discount.Tab2Fragment;
import com.mid_banchers.pk_discount.Tab3Fragment;

public class TabAdapter extends FragmentStateAdapter {


    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new Tab1Fragment();
        } else if (position == 1) {
            return new Tab2Fragment();
        } else {
            Tab3Fragment frag3 = new Tab3Fragment();
            return frag3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
