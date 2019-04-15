package com.example.cvapplication.data.network;

import com.example.cvapplication.data.network.model.CV;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("bins/ah01o")
    Call<List<CV>> getCVs();
}
