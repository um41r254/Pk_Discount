package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.FragShoe1;
import com.mid_banchers.pk_discount.FragShoe2;
import com.mid_banchers.pk_discount.FragShoe3;

public class ShoeAdapter  extends FragmentStateAdapter {
    public ShoeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FragShoe1();
        } else if (position == 1) {
            return new FragShoe2();
        } else {
            FragShoe3 fr_sh3 = new FragShoe3();
            return fr_sh3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
