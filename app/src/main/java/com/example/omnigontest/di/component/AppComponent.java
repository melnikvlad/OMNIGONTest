package com.example.omnigontest.di.component;


import com.example.omnigontest.di.module.AppModule;
import com.example.omnigontest.di.module.LocalSourceModule;
import com.example.omnigontest.di.module.RemoteSourceModule;
import com.example.omnigontest.ui.fixtures.FixturesPresenter;
import com.example.omnigontest.ui.results.ResultsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        LocalSourceModule.class,
        RemoteSourceModule.class
})
@Singleton
public interface AppComponent {
    void inject(FixturesPresenter presenter);
    void inject(ResultsPresenter presenter);
}
