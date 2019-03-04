package com.example.omnigontest.ui.results;

import com.example.omnigontest.base.IBasePresenter;
import com.example.omnigontest.base.IBaseView;
import com.example.omnigontest.data.model.result.ResultUI;

import java.util.List;

public interface IResultsContract {

    interface View extends IBaseView<Presenter> {

        void showList(boolean show);

        void showProgress(boolean show);

        void showRefreshingProgress(boolean show);

        void showStatusText(boolean show);

        void setResults(List<ResultUI> results);

    }

    interface Presenter extends IBasePresenter {

        void load();

        void refresh();

    }
}
