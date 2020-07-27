package com.example.petstarea3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.perfil;
import fragments.pets;

public class PageAdapter extends FragmentPagerAdapter {

    private int numoftab;
    public PageAdapter(@NonNull FragmentManager fm, int numOftab) {
        super ( fm );
        this.numoftab = numOftab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new pets ();
            case 1:
                return new perfil ();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numoftab;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
    
}
