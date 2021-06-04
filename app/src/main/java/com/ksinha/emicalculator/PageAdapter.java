package com.ksinha.emicalculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PageAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        // this will calculate the tabCount in Runtime
        tabCount = behavior;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        switch (position){
            case 0:
                fragment = new RulesFragment();
                break;
            case 1:
                fragment = new EmiFragment();
                break;
            default:
                fragment = null;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
