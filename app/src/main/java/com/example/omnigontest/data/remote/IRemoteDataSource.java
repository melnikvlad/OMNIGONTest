package com.example.omnigontest.data.remote;

import com.example.omnigontest.data.remote.model.beans.Fixture;
import com.example.omnigontest.data.results.model.Result;

import java.util.List;

import io.reactivex.Flowable;

public interface IRemoteDataSource {

    Flowable<List<Fixture>> fetchFixtures();

    Flowable<List<Result>> fetchResults();

}
