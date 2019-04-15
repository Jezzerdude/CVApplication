package com.example.cvapplication.ui.main;

import com.example.cvapplication.data.network.model.CV;
import com.example.cvapplication.data.network.WebService;
import com.example.cvapplication.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainView> {
    WebService webService;

    public MainPresenter(WebService webService) {
        this.webService = webService;
    }

    public void getCVs() {
        webService.getCVs().enqueue(new Callback<List<CV>>() {
            @Override
            public void onResponse(Call<List<CV>> call, Response<List<CV>> response) {
                if (isViewAttached()) {
                    if (response.isSuccessful()) {
                        getView().displayData(response.body());
                    } else {
                        getView().displayMessage(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CV>> call, Throwable t) {
                if (isViewAttached()) {
                    getView().displayMessage(t.getLocalizedMessage());
                }
            }
        });
    }
}
