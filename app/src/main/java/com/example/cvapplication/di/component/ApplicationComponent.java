package com.example.cvapplication.di.component;

import android.app.Application;

import com.example.cvapplication.data.network.WebService;
import com.example.cvapplication.di.NetworkModule;

import dagger.Component;

@Component(modules = {NetworkModule.class, AppModule.class})
public interface ApplicationComponent {
    void inject(Application application);

    WebService provideWebService();
}
