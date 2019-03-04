package com.example.omnigontest.data.source;

import com.example.omnigontest.data.model.fixture.beans.Fixture;

import java.util.List;

import io.reactivex.Flowable;

public interface ILocalDataSource {

    void write(Fixture entity);

    Integer clear();

    Flowable<List<Fixture>> getAllFixtures();
}
