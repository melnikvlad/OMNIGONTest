package com.example.omnigontest.data.remote;

import com.example.omnigontest.data.remote.model.FixturesResponse;
import com.example.omnigontest.data.remote.model.beans.Fixture;
import com.example.omnigontest.utils.Constants;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface IService {

    @GET("fixtures" + Constants.URL_POSTFIX)
    Flowable<List<Fixture>> fetchFixtures();

    @GET("results" + Constants.URL_POSTFIX)
    void fetchResults();
}
