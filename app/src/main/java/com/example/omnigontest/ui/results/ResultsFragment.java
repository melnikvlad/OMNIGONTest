package com.example.omnigontest.ui.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omnigontest.R;
import com.example.omnigontest.base.AbstractMvpView;


public class ResultsFragment extends AbstractMvpView<IResultsContract.Presenter> implements IResultsContract.View {

    public static ResultsFragment getInstance() {
        return new ResultsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_results, container, false);
        return root;
    }

    @Override
    public void setLoading(boolean start) {
        mPresenter.load();
    }

    @Override
    public void renderLoadingState() {

    }

    @Override
    public void renderDataState() {

    }

    @Override
    public void renderErrorState() {

    }
}
