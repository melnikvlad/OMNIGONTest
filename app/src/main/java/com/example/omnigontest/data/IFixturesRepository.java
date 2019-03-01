package com.example.omnigontest.data;


import com.example.omnigontest.data.remote.model.beans.Fixture;

import java.util.List;

import io.reactivex.Flowable;

public interface IFixturesRepository {
    Flowable<List<Fixture>> getFixtures();
}
