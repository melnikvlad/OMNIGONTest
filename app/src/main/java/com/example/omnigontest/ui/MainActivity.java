package com.example.omnigontest.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.omnigontest.R;
import com.example.omnigontest.ui.fixtures.FixturesFragment;
import com.example.omnigontest.ui.fixtures.FixturesPresenter;
import com.example.omnigontest.ui.results.ResultsFragment;
import com.example.omnigontest.ui.results.ResultsPresenter;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_PAGER_SELECTED_TAB = "last selected tab";

    private PagerAdapter mPagerAdapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tablayout);

        init();

        if (savedInstanceState != null) {
            int restorePos = savedInstanceState.getInt(STATE_PAGER_SELECTED_TAB);
            viewPager.setCurrentItem(restorePos);
        }

        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_PAGER_SELECTED_TAB, mPagerAdapter.getSelectedPos());
        super.onSaveInstanceState(outState);
    }

    private void init() {
        FixturesFragment fixturesFragment = FixturesFragment.getInstance();
        FixturesPresenter fixturesPresenter = new FixturesPresenter();
        fixturesPresenter.bind(fixturesFragment);

        ResultsFragment resultsFragment = ResultsFragment.getInstance();
        ResultsPresenter resultsPresenter = new ResultsPresenter();
        resultsPresenter.bind(resultsFragment);

        mPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        mPagerAdapter.addFragment(fixturesFragment);
        mPagerAdapter.addFragment(resultsFragment);
    }
}
