package com.example.omnigontest.data.network;

import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.model.result.beans.Result;
import com.example.omnigontest.utils.Constants;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface IService {

    @GET("fixtures" + Constants.URL_POSTFIX)
    Flowable<List<Fixture>> fetchFixtures();

    @GET("results" + Constants.URL_POSTFIX)
    Flowable<List<Result>> fetchResults();
}
