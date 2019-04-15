package com.example.cvapplication.di.component;

import android.app.Application;
import android.content.Context;

import com.example.cvapplication.di.scope.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    // here for expanding application further when context is needed
    private Application application;
    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @ApplicationContext
    public Context provideContext(){
        return application;
    }
}
