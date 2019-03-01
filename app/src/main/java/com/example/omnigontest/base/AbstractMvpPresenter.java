package com.example.omnigontest.base;

import com.example.omnigontest.base.exception.MvpException;
import com.example.omnigontest.base.exception.ViewUnboundException;

import java.lang.ref.WeakReference;

public abstract class AbstractMvpPresenter<V extends IBaseView> implements IBasePresenter {

    private WeakReference<V> mView;

    public void bind(V view) {
        mView = new WeakReference<>(view);
        view.setPresenter(this);
    }

    protected V getView() throws ViewUnboundException {
        if (mView == null || mView.get() == null) {
            throw new ViewUnboundException();
        } else {
            return mView.get();
        }
    }

    @Override
    public void handleException(MvpException e) {
        e.printStackTrace();
    }
}
