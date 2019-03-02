package com.example.omnigontest.data.remote;

import com.example.omnigontest.data.remote.model.beans.Fixture;
import com.example.omnigontest.data.results.model.Result;

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
