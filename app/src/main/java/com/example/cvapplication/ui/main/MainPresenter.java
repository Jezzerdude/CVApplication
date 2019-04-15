package com.example.cvapplication.ui.main;

import com.example.cvapplication.data.Network.Model.CV;
import com.example.cvapplication.data.Network.WebService;
import com.example.cvapplication.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainView> {
    private WebService webService;

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
