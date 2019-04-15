package com.example.cvapplication.data.network;

public class RestAPIHelper {
    private final WebService webService;

    public RestAPIHelper(WebService service) {
        this.webService = service;
    }

    public WebService getWebService() {
        return webService;
    }
}
