package com.example.cvapplication.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CV {

    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("projectId")
    @Expose
    private long projectId;
    @SerializedName("roleDescription")
    @Expose
    private String roleDescription;
    @SerializedName("techStack")
    @Expose
    private List<String> techStack;

    public CV(String company, String duration, long projectId, String roleDescription, List<String> techStack) {
        this.company = company;
        this.duration = duration;
        this.projectId = projectId;
        this.roleDescription = roleDescription;
        this.techStack = techStack;
    }

    public String getCompany() {
        return company;
    }

    public String getDuration() {
        return duration;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public List<String> getTechStack() {
        return techStack;
    }
}

