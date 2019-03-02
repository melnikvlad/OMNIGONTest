package com.example.omnigontest.data;


import com.example.omnigontest.data.remote.model.FixtureUI;

import java.util.List;

import io.reactivex.Flowable;

public interface IFixturesRepository {
    Flowable<List<FixtureUI>> getFixtures();
}
