package com.example.omnigontest.ui.fixtures;

import com.example.omnigontest.App;
import com.example.omnigontest.base.AbstractMvpPresenter;
import com.example.omnigontest.base.exception.ViewUnboundException;
import com.example.omnigontest.data.repository.fixture.FixtureRepository;
import com.example.omnigontest.data.repository.IFixturesRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class FixturesPresenter extends AbstractMvpPresenter<IFixturesContract.View> implements IFixturesContract.Presenter {
    @Inject
    IFixturesRepository mRepository;
    @Inject
    CompositeDisposable mDisposable;

    public FixturesPresenter() {
        App.getInstance().getAppComponent().inject(this);
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

        getCache();
    }

    @Override
    public void refresh() {
        try {
            getView().renderRefreshingState();
        } catch (ViewUnboundException e) {
            handleException(e);
        }

        clearCacheAndFetch();
    }

    private void getCache() {
        mDisposable.add(
                mRepository.getCachedFixtures()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnError(throwable -> getView().renderErrorState())
                        .subscribe(
                                fixtures -> {
                                    if (fixtures == null || fixtures.isEmpty()) {
                                        fetchData();
                                    } else {
                                        getView().setFixtures(fixtures);
                                        getView().renderDataState();
                                    }
                                }
                        ));
    }

    private void clearCacheAndFetch() {
        mDisposable.add(
                mRepository.clearCache()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                code -> fetchData()
                        )
        );
    }

    private void fetchData() {
        mDisposable.add(
                mRepository.getFixtures()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnError(throwable -> getView().renderErrorState())
                        .subscribe(
                                fixtures -> {
                                    getView().setFixtures(fixtures);
                                    getView().renderDataState();
                                }
                        ));
    }
}
