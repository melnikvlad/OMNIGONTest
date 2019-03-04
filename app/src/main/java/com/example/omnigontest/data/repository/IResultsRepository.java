package com.example.omnigontest.data.repository;

import com.example.omnigontest.data.model.result.ResultUI;

import java.util.List;

import io.reactivex.Flowable;

public interface IResultsRepository {
    Flowable<List<ResultUI>> getResults();
}
