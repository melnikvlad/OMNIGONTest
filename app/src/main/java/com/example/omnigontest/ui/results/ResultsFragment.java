package com.example.omnigontest.ui.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.omnigontest.R;
import com.example.omnigontest.base.AbstractMvpView;
import com.example.omnigontest.data.model.result.ResultUI;
import com.example.omnigontest.ui.adapter.ResultsAdapter;

import java.util.ArrayList;
import java.util.List;


public class ResultsFragment extends AbstractMvpView<IResultsContract.Presenter> implements IResultsContract.View {

    private ResultsAdapter mAdapter;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textStatus;

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
        swipeRefreshLayout = root.findViewById(R.id.swipeToRefreshView);
        textStatus = root.findViewById(R.id.text_status);

        initRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(() -> mPresenter.refresh());

        return root;
    }

    @Override
    public void setResults(List<ResultUI> results) {
        mAdapter.add(results);
    }

    @Override
    public void renderLoadingState() {
        textStatus.setText(getString(R.string.loading));
        showProgress(true);
        showStatusText(true);
        showList(false);
    }

    @Override
    public void renderDataState() {
        showProgress(false);
        showRefreshingProgress(false);
        showStatusText(false);
        showList(true);
    }

    @Override
    public void renderErrorState() {
        textStatus.setText(getString(R.string.error_loading));
        showProgress(false);
        showRefreshingProgress(false);
        showStatusText(true);
        showList(false);
    }

    @Override
    public void renderRefreshingState() {
        showProgress(false);
        showRefreshingProgress(true);
        showStatusText(false);
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

    @Override
    public void showRefreshingProgress(boolean show) {
        swipeRefreshLayout.setRefreshing(show);
    }

    @Override
    public void showStatusText(boolean show) {
        textStatus.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }
}
