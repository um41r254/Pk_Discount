package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.FragTre1;
import com.mid_banchers.pk_discount.FragTre2;
import com.mid_banchers.pk_discount.FragTre3;


public class TreAdapter  extends FragmentStateAdapter {
    public TreAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FragTre1();
        } else if (position == 1) {
            return new FragTre2();
        } else {
            FragTre3 fr_tri3 = new FragTre3();
            return fr_tri3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
