package com.example.omnigontest.base;

public interface IBaseView<T extends IBasePresenter> {

    void setPresenter(T presenter);

    void renderLoadingState();

    void renderDataState();

    void renderErrorState();

}
