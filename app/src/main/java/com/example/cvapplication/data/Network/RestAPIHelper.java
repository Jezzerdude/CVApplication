package com.example.cvapplication.data.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIHelper {

    private static final String BASE_URL = "https://api.myjson.com";
    private Retrofit retrofit;
    private WebService webService;

    public RestAPIHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebService.class);
    }

    public WebService getWebService() {
        return webService;
    }
}
