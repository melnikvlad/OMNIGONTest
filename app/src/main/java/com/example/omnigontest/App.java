package com.example.omnigontest;

import android.app.Application;

public class App extends Application {
    private static App INSTANCE = null;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static App getInstance() {
        return INSTANCE;
    }
}
