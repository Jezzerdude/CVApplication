package com.example.cvapplication.ui.main;

import com.example.cvapplication.data.network.WebService;
import com.example.cvapplication.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {
    private WebService webService;

    private CompositeDisposable disposable = new CompositeDisposable();

    public MainPresenter(WebService webService) {
        this.webService = webService;
    }

    public void getCVs() {
        disposable.add(
                webService.getCVs()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(cvList -> getView().displayData(cvList),
                                throwable -> getView().displayMessage(throwable.getLocalizedMessage())));
    }

    @Override
    public void detach() {
        disposable.clear();
        super.detach();
    }
}
