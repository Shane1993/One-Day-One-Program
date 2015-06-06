package net.lee.tab04_viewpager_indicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by LEE on 2015/6/6.
 */
public class TabAdapter extends FragmentPagerAdapter {

    public static String TITLES[] = new String[]{"abc", "bcd", "efg", "hij"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TabFragment(position);
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return TITLES[position];

    }
}
