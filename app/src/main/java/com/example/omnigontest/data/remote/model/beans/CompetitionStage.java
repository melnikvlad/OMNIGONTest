package com.example.omnigontest.data.remote.model.beans;

import com.example.omnigontest.data.remote.model.beans.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompetitionStage {
    @SerializedName("competition")
    @Expose
    public Competition competition;
    @SerializedName("stage")
    @Expose
    public String stage;
    @SerializedName("leg")
    @Expose
    public String leg;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }
}
