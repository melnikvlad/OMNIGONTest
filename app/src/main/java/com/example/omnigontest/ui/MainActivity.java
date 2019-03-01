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

    private PagerAdapter mPagerAdapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tablayout);

        FixturesFragment fixturesFragment = FixturesFragment.getInstance();
        FixturesPresenter fixturesPresenter = new FixturesPresenter();
        fixturesPresenter.bind(fixturesFragment);

        ResultsFragment resultsFragment = ResultsFragment.getInstance();
        ResultsPresenter resultsPresenter = new ResultsPresenter();
        resultsPresenter.bind(resultsFragment);

        mPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        mPagerAdapter.addFragment(fixturesFragment);
        mPagerAdapter.addFragment(resultsFragment);

        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
