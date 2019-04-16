package com.example.cvapplication.di.component;

import android.app.Application;

import com.example.cvapplication.data.temp.WebService;
import com.example.cvapplication.di.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {NetworkModule.class, AppModule.class})
@Singleton
public interface ApplicationComponent {
    void inject(Application application);

    WebService provideWebService();
}
