package com.example.cvapplication.data.network.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private List<String> techStack = null;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

}

