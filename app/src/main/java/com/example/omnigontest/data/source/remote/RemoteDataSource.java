package com.example.omnigontest.data.source.remote;

import com.example.omnigontest.data.network.ApiClient;
import com.example.omnigontest.data.network.IService;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.model.result.beans.Result;
import com.example.omnigontest.data.source.IRemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RemoteDataSource implements IRemoteDataSource {
    @Inject
    public IService mService;

    public RemoteDataSource(IService service) {
        mService = service;
    }

    @Override
    public Flowable<List<Fixture>> fetchFixtures() {
        return mService.fetchFixtures();
    }

    @Override
    public Flowable<List<Result>> fetchResults() {
        return mService.fetchResults();
    }
}
