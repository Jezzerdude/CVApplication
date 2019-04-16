package com.example.cvapplication.ui.main;

import com.example.cvapplication.data.temp.WebService;
import com.example.cvapplication.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {
    private final WebService webService;

    private final CompositeDisposable disposable;

    public MainPresenter(WebService webService) {
        this.webService = webService;
        disposable = new CompositeDisposable();
    }

    public void getCVs() {
        disposable.add(
                webService.getCVs()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> getView().showProgress())
                        .doOnEvent(((cvs, throwable) -> getView().hideProgress()))
                        .subscribe(cvList -> getView().displayData(cvList),
                                throwable -> getView().displayMessage(throwable.getLocalizedMessage())));
    }

    @Override
    public void detach() {
        disposable.clear();
        super.detach();
    }
}
