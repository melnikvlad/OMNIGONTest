package com.example.omnigontest.base;

import com.example.omnigontest.base.exception.MvpException;

public interface IBasePresenter {

    void handleException(MvpException e);

    void subscribe();

    void unsubscribe();

}
