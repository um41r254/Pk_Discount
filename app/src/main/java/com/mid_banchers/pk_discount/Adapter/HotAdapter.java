package com.mid_banchers.pk_discount.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mid_banchers.pk_discount.Frag_hot1;
import com.mid_banchers.pk_discount.Frag_hot2;
import com.mid_banchers.pk_discount.Frag_hot3;

public class HotAdapter  extends FragmentStateAdapter {

    public HotAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Frag_hot1();
        } else if (position == 1) {
            return new Frag_hot2();
        } else {
            Frag_hot3 fr_hot3 = new Frag_hot3();
            return fr_hot3;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

