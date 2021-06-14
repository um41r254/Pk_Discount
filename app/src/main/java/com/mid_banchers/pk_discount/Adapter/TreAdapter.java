package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.Frag_tre1;
import com.mid_banchers.pk_discount.Frag_tre2;
import com.mid_banchers.pk_discount.Frag_tre3;


public class TreAdapter  extends FragmentStateAdapter {
    public TreAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Frag_tre1();
        } else if (position == 1) {
            return new Frag_tre2();
        } else {
            Frag_tre3 fr_tri3 = new Frag_tre3();
            return fr_tri3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
