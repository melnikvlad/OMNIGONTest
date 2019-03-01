package com.example.omnigontest.ui.results;

import com.example.omnigontest.base.IBasePresenter;
import com.example.omnigontest.base.IBaseView;

public interface IResultsContract {

    interface View extends IBaseView<Presenter> {

        void setLoading(boolean start);

    }

    interface Presenter extends IBasePresenter {

        void load();

    }
}
