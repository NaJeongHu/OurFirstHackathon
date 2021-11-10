package com.voda.ourfirsthackathon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    public static int PAGE_POSITION = 4;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            //1번째 탭
            case 0:
                return ReservationFragment.newInstance();
            //2번째 탭
            case 1:
                return SearchFragment.newInstance();
            //3번째 탭
            case 2:
                return UsedFragment.newInstance();
            //4번째 탭
            case 3:
                return SettingFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 4; }
}
