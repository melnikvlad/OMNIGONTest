package com.example.omnigontest.data.remote.model;

import com.example.omnigontest.data.results.model.Result;

import java.util.List;

public class ResultUI extends UIObject {

    private Result result = null;

    public ResultUI(int type) {
        super(type);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result results) {
        this.result = results;
    }
}
