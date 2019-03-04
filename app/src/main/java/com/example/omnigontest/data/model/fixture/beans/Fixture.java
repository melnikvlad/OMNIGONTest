package com.example.omnigontest.data.model.fixture.beans;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.omnigontest.data.database.DataConverter;
import com.example.omnigontest.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = Constants.TABLE_NAME)
public class Fixture {

    @PrimaryKey(autoGenerate = true)
    private int entityId;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    public int id;

    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    public String type;
    @ColumnInfo(name = "homeTeam")
    @TypeConverters(DataConverter.class)
    @SerializedName("homeTeam")
    @Expose
    public HomeTeam homeTeam;
    @ColumnInfo(name = "awayTeam")
    @TypeConverters(DataConverter.class)
    @SerializedName("awayTeam")
    @Expose
    public AwayTeam awayTeam;
    @ColumnInfo(name = "date")
    @SerializedName("date")
    @Expose
    public String date;
    @ColumnInfo(name = "competitionStage")
    @TypeConverters(DataConverter.class)
    @SerializedName("competitionStage")
    @Expose
    public CompetitionStage competitionStage;
    @ColumnInfo(name = "venue")
    @TypeConverters(DataConverter.class)
    @SerializedName("venue")
    @Expose
    public Venue venue;
    @ColumnInfo(name = "state")
    @TypeConverters(DataConverter.class)
    @SerializedName("state")
    @Expose
    public String state;

    public Fixture(int entityId, int id, String type, HomeTeam homeTeam, AwayTeam awayTeam, String date,
                   CompetitionStage competitionStage, Venue venue, String state) {
        this.entityId = entityId;
        this.id = id;
        this.type = type;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.competitionStage = competitionStage;
        this.venue = venue;
        this.state = state;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CompetitionStage getCompetitionStage() {
        return competitionStage;
    }

    public void setCompetitionStage(CompetitionStage competitionStage) {
        this.competitionStage = competitionStage;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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
