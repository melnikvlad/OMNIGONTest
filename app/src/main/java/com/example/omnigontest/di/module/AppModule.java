package com.example.omnigontest.di.module;

import android.app.Application;

import com.example.omnigontest.data.repository.IFixturesRepository;
import com.example.omnigontest.data.repository.IResultsRepository;
import com.example.omnigontest.data.repository.fixture.FixtureRepository;
import com.example.omnigontest.data.repository.result.ResultsRepository;
import com.example.omnigontest.data.source.ILocalDataSource;
import com.example.omnigontest.data.source.IRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    IFixturesRepository provideFixtureRepository(ILocalDataSource localDataSource, IRemoteDataSource remoteDataSource) {

        return new FixtureRepository(remoteDataSource, localDataSource);
    }

    @Provides
    @Singleton
    IResultsRepository provideResultRepository(IRemoteDataSource remoteDataSource) {

        return new ResultsRepository(remoteDataSource);
    }

    @Provides
    CompositeDisposable provideDisposable() {
        return new CompositeDisposable();
    }
}
