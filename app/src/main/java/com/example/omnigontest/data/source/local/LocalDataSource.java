package com.example.omnigontest.data.source.local;

import android.app.Application;

import com.example.omnigontest.data.database.MyDB;
import com.example.omnigontest.data.model.fixture.beans.Fixture;
import com.example.omnigontest.data.source.ILocalDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LocalDataSource implements ILocalDataSource {

    @Inject
    MyDB sDB;

    public LocalDataSource(MyDB db) {
        sDB = db;
    }

    @Override
    public void write(Fixture entity) {
        sDB.getDao().insert(entity);
    }

    @Override
    public Integer clear() {
        return sDB.getDao().clear();
    }

    @Override
    public Flowable<List<Fixture>> getAllFixtures() {
        return Flowable.fromCallable(() -> sDB.getDao().getAllFixtures());
    }
}
