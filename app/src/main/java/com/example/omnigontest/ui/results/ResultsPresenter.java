package com.example.omnigontest.ui.results;


import com.example.omnigontest.base.AbstractMvpPresenter;
import com.example.omnigontest.base.exception.ViewUnboundException;


public class ResultsPresenter extends AbstractMvpPresenter<IResultsContract.View> implements IResultsContract.Presenter {

    @Override
    public void load() {
        try {
            getView().setLoading(true);
        } catch (ViewUnboundException e) {
            handleException(e);
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
