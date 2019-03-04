package com.example.omnigontest.data.model.result.beans;

import com.example.omnigontest.data.model.fixture.beans.AwayTeam;
import com.example.omnigontest.data.model.fixture.beans.CompetitionStage;
import com.example.omnigontest.data.model.fixture.beans.HomeTeam;
import com.example.omnigontest.data.model.fixture.beans.Venue;
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
