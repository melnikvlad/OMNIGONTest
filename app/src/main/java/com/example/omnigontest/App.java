package com.example.omnigontest;

import android.app.Application;

import com.example.omnigontest.di.component.AppComponent;
import com.example.omnigontest.di.component.DaggerAppComponent;
import com.example.omnigontest.di.module.AppModule;
import com.example.omnigontest.di.module.LocalSourceModule;
import com.example.omnigontest.di.module.RemoteSourceModule;

public class App extends Application {
    private static App INSTANCE = null;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(INSTANCE))
                .localSourceModule(new LocalSourceModule())
                .remoteSourceModule(new RemoteSourceModule())
                .build();
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
