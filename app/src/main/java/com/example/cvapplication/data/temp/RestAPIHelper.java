package com.example.cvapplication.data.temp;

public class RestAPIHelper {
    private final WebService webService;

    public RestAPIHelper(WebService service) {
        this.webService = service;
    }

    public WebService getWebService() {
        return webService;
    }
}
