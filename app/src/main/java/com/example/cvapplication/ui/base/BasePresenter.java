package com.example.cvapplication.ui.base;

public class BasePresenter<T extends MVPView> {
    private T view;

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    protected T getView() {
        return view;
    }
}
