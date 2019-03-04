package com.example.omnigontest.data.repository;


import com.example.omnigontest.data.model.fixture.FixtureUI;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface IFixturesRepository {
    Flowable<List<FixtureUI>> getFixtures();

    Flowable<List<FixtureUI>> getCachedFixtures();

    Single<Integer> clearCache();
}
