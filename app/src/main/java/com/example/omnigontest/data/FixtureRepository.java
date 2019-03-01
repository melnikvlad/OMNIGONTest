package com.example.omnigontest.data;


import com.example.omnigontest.data.remote.model.beans.Fixture;

import java.util.List;

import io.reactivex.Flowable;

public class FixtureRepository implements IFixturesRepository {

    private RemoteDataSource mRemoteSource;

    public FixtureRepository() {
        mRemoteSource = new RemoteDataSource();
    }

    @Override
    public Flowable<List<Fixture>> getFixtures() {
        return mRemoteSource.fetchFixtures();
    }
}
