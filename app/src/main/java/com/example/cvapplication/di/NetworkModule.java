package com.example.cvapplication.di;

import com.example.cvapplication.common.Constant;
import com.example.cvapplication.data.network.RestAPIHelper;
import com.example.cvapplication.data.network.WebService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    WebService providesWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }

    @Provides
    RestAPIHelper providesRestAPIHelper(WebService service) {
        return new RestAPIHelper(service);
    }
}
