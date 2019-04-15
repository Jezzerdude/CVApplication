package com.example.cvapplication;

import android.app.Application;

import com.example.cvapplication.di.component.AppModule;
import com.example.cvapplication.di.component.ApplicationComponent;
import com.example.cvapplication.di.component.DaggerApplicationComponent;

public class MainApplication extends Application {
    private static MainApplication application;
    private ApplicationComponent applicationComponent;

    public static MainApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
