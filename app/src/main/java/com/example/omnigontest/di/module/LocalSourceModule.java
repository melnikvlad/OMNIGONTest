package com.example.omnigontest.di.module;

import android.app.Application;

import com.example.omnigontest.data.database.MyDB;
import com.example.omnigontest.data.source.ILocalDataSource;
import com.example.omnigontest.data.source.local.LocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalSourceModule {

    @Provides
    @Singleton
    ILocalDataSource provideLocalDataSource(MyDB db) {
        return new LocalDataSource(db);
    }

    @Provides
    @Singleton
    MyDB provideDataBase(Application application) {
        return MyDB.getDB(application);
    }
}
