package com.example.omnigontest.ui.fixtures;

public class FixturesPresenter implements IFixturesContract.Presenter {
    private IFixturesContract.View mView;

    public FixturesPresenter(IFixturesContract.View view) {
        if (view != null) {
            mView = view;
            mView.setPresenter(this);
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
