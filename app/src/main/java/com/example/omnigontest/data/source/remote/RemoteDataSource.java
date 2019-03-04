package com.example.omnigontest.data.source.remote;

import com.example.omnigontest.data.network.ApiClient;
import com.example.omnigontest.data.network.IService;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.model.result.beans.Result;
import com.example.omnigontest.data.source.IRemoteDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class RemoteDataSource implements IRemoteDataSource {

    private IService mService;

    public RemoteDataSource() {
        mService = new ApiClient().api();
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
