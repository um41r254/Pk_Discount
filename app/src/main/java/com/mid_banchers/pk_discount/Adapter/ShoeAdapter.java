package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.Frag_shoe1;
import com.mid_banchers.pk_discount.Frag_shoe2;
import com.mid_banchers.pk_discount.Frag_shoe3;

public class ShoeAdapter  extends FragmentStateAdapter {
    public ShoeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Frag_shoe1();
        } else if (position == 1) {
            return new Frag_shoe2();
        } else {
            Frag_shoe3 fr_sh3 = new Frag_shoe3();
            return fr_sh3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
