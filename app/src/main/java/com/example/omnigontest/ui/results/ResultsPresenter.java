package com.example.omnigontest.ui.results;

public class ResultsPresenter implements IResultsContract.Presenter {

    private IResultsContract.View mView;

    public ResultsPresenter(IResultsContract.View view) {
        if (view != null) {
            mView = view;
            mView.setPresenter(this);
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
