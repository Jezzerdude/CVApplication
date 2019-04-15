package com.example.cvapplication.data.Network;

import com.example.cvapplication.data.Network.Model.CV;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("bins/ah01o")
    Call<List<CV>> getCVs();
}
