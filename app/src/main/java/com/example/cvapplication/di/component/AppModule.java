package com.example.cvapplication.di.component;

import android.app.Application;
import android.content.Context;

import com.example.cvapplication.di.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    // here for expanding application further when context is needed
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }
}
