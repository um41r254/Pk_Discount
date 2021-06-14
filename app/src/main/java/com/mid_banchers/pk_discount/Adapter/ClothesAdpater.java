package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.Frag_cloths1;
import com.mid_banchers.pk_discount.Frag_cloths2;
import com.mid_banchers.pk_discount.Frag_cloths3;

public class ClothesAdpater extends FragmentStateAdapter {
    public ClothesAdpater(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Frag_cloths1();
        } else if (position == 1) {
            return new Frag_cloths2();
        } else {
            Frag_cloths3 fr_ch3 = new Frag_cloths3();
            return fr_ch3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
