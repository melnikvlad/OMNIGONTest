package com.example.omnigontest.data.source;

import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.model.result.beans.Result;

import java.util.List;

import io.reactivex.Flowable;

public interface IRemoteDataSource {

    Flowable<List<Fixture>> fetchFixtures();

    Flowable<List<Result>> fetchResults();

}
