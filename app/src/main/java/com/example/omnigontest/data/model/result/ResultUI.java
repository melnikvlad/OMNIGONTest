package com.example.omnigontest.data.model.result;

import com.example.omnigontest.data.model.UIObject;
import com.example.omnigontest.data.model.result.beans.Result;

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
