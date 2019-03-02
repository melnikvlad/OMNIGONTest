package com.example.omnigontest.ui.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.omnigontest.R;
import com.example.omnigontest.base.AbstractMvpView;
import com.example.omnigontest.data.remote.model.ResultUI;
import com.example.omnigontest.ui.adapter.FixturesAdapter;
import com.example.omnigontest.ui.adapter.ResultsAdapter;
import com.example.omnigontest.ui.fixtures.IFixturesContract;

import java.util.ArrayList;
import java.util.List;


public class ResultsFragment extends AbstractMvpView<IResultsContract.Presenter> implements IResultsContract.View {

    private ResultsAdapter mAdapter;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    public static ResultsFragment getInstance() {
        return new ResultsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ResultsAdapter(getContext(), new ArrayList<>());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_results, container, false);
        progressBar = root.findViewById(R.id.progress);
        recyclerView = root.findViewById(R.id.rv);

        initRecyclerView();

        return root;
    }

    @Override
    public void setResults(List<ResultUI> results) {
        mAdapter.add(results);
    }

    @Override
    public void renderLoadingState() {
        showProgress(true);
        showList(false);
    }

    @Override
    public void renderDataState() {
        showProgress(false);
        showList(true);
    }

    @Override
    public void renderErrorState() {
        showProgress(false);
        showList(false);
    }

    @Override
    public void showList(boolean show) {
        recyclerView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }
}
