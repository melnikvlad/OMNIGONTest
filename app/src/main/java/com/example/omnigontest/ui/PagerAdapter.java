package com.example.omnigontest.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;

import com.example.omnigontest.R;
import com.example.omnigontest.ui.fixtures.FixturesFragment;
import com.example.omnigontest.ui.results.ResultsFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_FIXTURES = 0;
    private static final int TAB_RESULTS = 1;
    private static final int TAB_COUNT = 2;

    private final Context mContext;
    private final List<Fragment> mList;

    PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        mList = new ArrayList<>();
    }

    void addFragment(Fragment fragment) {
        mList.add(fragment);
    }

    @Override
    public Fragment getItem(int pos) {
        return mList.get(pos);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case TAB_FIXTURES:
                title = mContext.getString(R.string.fixtures);
                break;
            case TAB_RESULTS:
                title = mContext.getString(R.string.results);
                break;
        }

        return title;
    }
}
