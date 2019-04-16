package com.example.cvapplication.ui.main;

import com.example.cvapplication.data.network.model.CV;
import com.example.cvapplication.ui.base.MVPView;

import java.util.List;

public interface MainView extends MVPView {
    void displayData(List<CV> cvList);

    void displayMessage(String message);

    void showProgress();

    void hideProgress();

}
