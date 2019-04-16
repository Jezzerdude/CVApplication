package com.example.cvapplication.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CV {

    @SerializedName("companyName")
    @Expose
    private final String companyName;
    @SerializedName("projectDuration")
    @Expose
    private final String projectDuration;
    @SerializedName("appDescription")
    @Expose
    private final String appDescription;
    @SerializedName("techUsed")
    @Expose
    private final List<String> techsUsed;

    public CV(String companyName, String projectDuration, String appDescription, List<String> techsUsed) {
        this.companyName = companyName;
        this.projectDuration = projectDuration;
        this.appDescription = appDescription;
        this.techsUsed = techsUsed;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProjectDuration() {
        return projectDuration;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public List<String> getTechsUsed() {
        return techsUsed;
    }
}

