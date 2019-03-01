package com.example.omnigontest.data;

import com.example.omnigontest.data.remote.ApiClient;
import com.example.omnigontest.data.remote.IService;
import com.example.omnigontest.data.remote.model.FixturesResponse;
import com.example.omnigontest.data.remote.model.beans.Fixture;

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
}
