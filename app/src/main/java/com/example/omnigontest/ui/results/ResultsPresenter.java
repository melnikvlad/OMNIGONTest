package com.example.omnigontest.ui.results;


import com.example.omnigontest.base.AbstractMvpPresenter;
import com.example.omnigontest.base.exception.ViewUnboundException;
import com.example.omnigontest.data.IResultsRepository;
import com.example.omnigontest.data.ResultsRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class ResultsPresenter extends AbstractMvpPresenter<IResultsContract.View> implements IResultsContract.Presenter {

    private IResultsRepository mRepository;
    private CompositeDisposable mDisposable;

    public ResultsPresenter() {
        mRepository = new ResultsRepository();
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void load() {
        try {
            getView().renderLoadingState();
        } catch (ViewUnboundException e) {
            handleException(e);
        }
        mDisposable.add(
                mRepository.getResults()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                results -> {
                                    getView().setResults(results);
                                    getView().renderDataState();
                                }
                        ));
    }

    @Override
    public void refresh() {

    }

    @Override
    public void subscribe() {
        load();
    }

    @Override
    public void unsubscribe() {
        mDisposable.clear();
    }
}
