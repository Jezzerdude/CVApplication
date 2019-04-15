package com.example.cvapplication.di.component;

import com.example.cvapplication.ui.main.MainActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
