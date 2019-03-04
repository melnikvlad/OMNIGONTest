package com.example.omnigontest.data.repository.fixture;


import com.example.omnigontest.App;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.repository.IFixturesRepository;
import com.example.omnigontest.data.source.local.LocalDataSource;
import com.example.omnigontest.data.source.remote.RemoteDataSource;
import com.example.omnigontest.data.model.fixture.FixtureUI;
import com.example.omnigontest.data.model.UIObject;
import com.example.omnigontest.utils.DateUtils;

import java.text.ParseException;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class FixtureRepository implements IFixturesRepository {

    private RemoteDataSource mRemoteSource;
    private LocalDataSource mLocalSource;
    private String currDate = null;

    public FixtureRepository() {
        mRemoteSource = new RemoteDataSource();
        mLocalSource = new LocalDataSource(App.getInstance());
    }

    @Override
    public Single<Integer> clearCache() {
        return Single.fromCallable(mLocalSource::clear);
    }

    @Override
    public Flowable<List<FixtureUI>> getFixtures() {

        return mRemoteSource.fetchFixtures()
                .filter(list -> !list.isEmpty())
                .flatMapIterable(source -> source)
                .map(fixture -> {

                    mLocalSource.write(fixture);

                    return wrapEntity(fixture);

                })
                .toList()
                .toFlowable();
    }

    @Override
    public Flowable<List<FixtureUI>> getCachedFixtures() {
        return mLocalSource.getAllFixtures()
                .filter(list -> !list.isEmpty())
                .flatMapIterable(source -> source)
                .map(this::wrapEntity)
                .toList()
                .toFlowable();
    }

    private FixtureUI wrapEntity(Fixture fixture) throws ParseException {

        if (!DateUtils.sameMonth(fixture.date, currDate)) {
            currDate = fixture.date;
            FixtureUI fixtureUI = new FixtureUI(UIObject.TYPE_FIXTURE_AND_DATE);
            fixtureUI.setDate(currDate);
            fixtureUI.setFixture(fixture);
            return fixtureUI;
        }

        FixtureUI fixtureUI = new FixtureUI(UIObject.TYPE_FIXTURE);
        fixtureUI.setFixture(fixture);
        return fixtureUI;

    }
}
