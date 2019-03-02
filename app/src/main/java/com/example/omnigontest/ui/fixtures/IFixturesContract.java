package com.example.omnigontest.ui.fixtures;

import com.example.omnigontest.base.IBasePresenter;
import com.example.omnigontest.base.IBaseView;
import com.example.omnigontest.data.remote.model.FixtureUI;

import java.util.List;

public interface IFixturesContract {

    interface View extends IBaseView<Presenter> {

        void showList(boolean show);

        void showProgress(boolean show);

        void setFixtures(List<FixtureUI> fixtures);

    }

    interface Presenter extends IBasePresenter {

        void load();

        void refresh();

    }

}
