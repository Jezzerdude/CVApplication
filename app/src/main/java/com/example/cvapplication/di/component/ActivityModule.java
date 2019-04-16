package com.example.cvapplication.di.component;

import android.app.Activity;
import android.content.Context;

import com.example.cvapplication.di.qualifier.ActivityContext;
import com.example.cvapplication.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
class ActivityModule {
    private final Activity activity;

    ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    @ActivityScope
    Context provideContext() {
        return activity;
    }
}
