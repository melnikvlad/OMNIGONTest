package com.example.omnigontest.data.remote.model.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fixture {
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

    @Override
    public String toString() {
        return "Fixture{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", date='" + date + '\'' +
                ", competitionStage=" + competitionStage +
                ", venue=" + venue +
                ", state='" + state + '\'' +
                '}';
    }
}
