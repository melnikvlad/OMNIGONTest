package com.example.omnigontest.di.module;

import com.example.omnigontest.data.network.ApiClient;
import com.example.omnigontest.data.network.IService;
import com.example.omnigontest.data.source.IRemoteDataSource;
import com.example.omnigontest.data.source.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteSourceModule {

    @Provides
    @Singleton
    IRemoteDataSource provideRemoteSource(IService service) {
        return new RemoteDataSource(service);
    }

    @Provides
    @Singleton
    ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @Singleton
    IService provideApi(ApiClient client) {
        return client.api();
    }
}
