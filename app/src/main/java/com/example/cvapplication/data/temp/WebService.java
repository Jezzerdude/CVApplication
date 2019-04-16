package com.example.cvapplication.data.temp;

import com.example.cvapplication.data.temp.temp2.CV;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebService {
    @GET("bins/bl4kg")
    Single<List<CV>> getCVs();
}
