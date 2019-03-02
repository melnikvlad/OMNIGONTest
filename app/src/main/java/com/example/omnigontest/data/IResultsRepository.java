package com.example.omnigontest.data;

import com.example.omnigontest.data.remote.model.ResultUI;

import java.util.List;

import io.reactivex.Flowable;

public interface IResultsRepository {
    Flowable<List<ResultUI>> getResults();
}
