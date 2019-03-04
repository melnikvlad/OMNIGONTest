package com.example.omnigontest.data.repository.result;

import com.example.omnigontest.data.repository.IResultsRepository;
import com.example.omnigontest.data.source.remote.RemoteDataSource;
import com.example.omnigontest.data.model.result.ResultUI;
import com.example.omnigontest.data.model.UIObject;
import com.example.omnigontest.utils.DateUtils;

import java.util.List;

import io.reactivex.Flowable;

public class ResultsRepository implements IResultsRepository {

    private RemoteDataSource mRemoteSource;
    private String currDate = null;

    public ResultsRepository() {
        mRemoteSource = new RemoteDataSource();
    }

    @Override
    public Flowable<List<ResultUI>> getResults() {

        return mRemoteSource.fetchResults()
                .filter(list -> !list.isEmpty())
                .flatMapIterable(source -> source)
                .map(result -> {

                    if (!DateUtils.sameMonth(result.date, currDate)) {
                        currDate = result.date;
                        ResultUI resultUI = new ResultUI(UIObject.TYPE_RESULT_AND_DATE);
                        resultUI.setDate(currDate);
                        resultUI.setResult(result);
                        return resultUI;
                    }

                    ResultUI resultUI = new ResultUI(UIObject.TYPE_RESULT);
                    resultUI.setResult(result);
                    return resultUI;

                })
                .toList()
                .toFlowable();

    }
}
