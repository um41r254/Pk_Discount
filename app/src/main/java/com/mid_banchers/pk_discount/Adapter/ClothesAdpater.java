package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.FragCloths1;
import com.mid_banchers.pk_discount.FragCloths2;
import com.mid_banchers.pk_discount.FragCloths3;

public class ClothesAdpater extends FragmentStateAdapter {
    public ClothesAdpater(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FragCloths1();
        } else if (position == 1) {
            return new FragCloths2();
        } else {
            FragCloths3 fr_ch3 = new FragCloths3();
            return fr_ch3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
