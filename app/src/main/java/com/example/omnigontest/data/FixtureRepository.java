package com.example.omnigontest.data;


import com.example.omnigontest.data.remote.RemoteDataSource;
import com.example.omnigontest.data.remote.model.FixtureUI;
import com.example.omnigontest.data.remote.model.UIObject;
import com.example.omnigontest.utils.DateUtils;

import java.util.List;

import io.reactivex.Flowable;

public class FixtureRepository implements IFixturesRepository {

    private RemoteDataSource mRemoteSource;
    private String currDate = null;

    public FixtureRepository() {
        mRemoteSource = new RemoteDataSource();
    }

    @Override
    public Flowable<List<FixtureUI>> getFixtures() {

        return mRemoteSource.fetchFixtures()
                .filter(list -> !list.isEmpty())
                .flatMapIterable(source -> source)
                .map(fixture -> {

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

                })
                .toList()
                .toFlowable();

    }
}
