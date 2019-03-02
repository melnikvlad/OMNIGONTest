package com.example.omnigontest.data.results.model;

import com.example.omnigontest.data.remote.model.beans.AwayTeam;
import com.example.omnigontest.data.remote.model.beans.CompetitionStage;
import com.example.omnigontest.data.remote.model.beans.HomeTeam;
import com.example.omnigontest.data.remote.model.beans.Venue;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("homeTeam")
    @Expose
    public HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    public AwayTeam awayTeam;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("competitionStage")
    @Expose
    public CompetitionStage competitionStage;
    @SerializedName("venue")
    @Expose
    public Venue venue;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("score")
    @Expose
    public Score score;
    @SerializedName("penaltyScore")
    @Expose
    public PenaltyScore penaltyScore;
    @SerializedName("aggregateScore")
    @Expose
    public AggregateScore aggregateScore;
}
