package com.example.omnigontest.ui.fixtures;

import com.example.omnigontest.base.AbstractMvpPresenter;
import com.example.omnigontest.base.exception.ViewUnboundException;
import com.example.omnigontest.data.FixtureRepository;
import com.example.omnigontest.data.IFixturesRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class FixturesPresenter extends AbstractMvpPresenter<IFixturesContract.View> implements IFixturesContract.Presenter {

    private IFixturesRepository mRepository;
    private CompositeDisposable mDisposable;

    public FixturesPresenter() {
        mRepository = new FixtureRepository();
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        load();
    }

    @Override
    public void unsubscribe() {
        mDisposable.clear();
    }

    @Override
    public void load() {
        try {
            getView().renderLoadingState();
        } catch (ViewUnboundException e) {
            handleException(e);
        }
        mDisposable.add(
                mRepository.getFixtures()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                fixtures -> {
                                    getView().setFixtures(fixtures);
                                    getView().renderDataState();
                                }
                        ));
    }

    @Override
    public void refresh() {

    }
}
