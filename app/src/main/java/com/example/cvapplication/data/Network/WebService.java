package com.example.cvapplication.data.network;

import com.example.cvapplication.data.network.model.CV;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebService {
    @GET("bins/bl4kg")
    Single<List<CV>> getCVs();
}
