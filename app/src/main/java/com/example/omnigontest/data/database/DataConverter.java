package com.example.omnigontest.data.database;

import android.arch.persistence.room.TypeConverter;

import com.example.omnigontest.data.model.fixture.beans.AwayTeam;
import com.example.omnigontest.data.model.fixture.beans.CompetitionStage;
import com.example.omnigontest.data.model.fixture.beans.HomeTeam;
import com.example.omnigontest.data.model.fixture.beans.Venue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

    @TypeConverter
    public String fromHomeTeam(HomeTeam homeTeam) {
        if (homeTeam == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<HomeTeam>() {}.getType();

        return gson.toJson(homeTeam, type);
    }

    @TypeConverter
    public HomeTeam toHomeTeam(String homeStr) {
        if (homeStr == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<HomeTeam>() {}.getType();

        return gson.fromJson(homeStr, type);
    }

    @TypeConverter
    public String fromAwayTeam(AwayTeam obj) {
        if (obj == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<AwayTeam>() {}.getType();

        return gson.toJson(obj, type);
    }

    @TypeConverter
    public AwayTeam toAwayTeam(String str) {
        if (str == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<AwayTeam>() {}.getType();

        return gson.fromJson(str, type);
    }

    @TypeConverter
    public String fromCompetiotionStage(CompetitionStage obj) {
        if (obj == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<CompetitionStage>() {}.getType();

        return gson.toJson(obj, type);
    }

    @TypeConverter
    public CompetitionStage toCompetiotionStage(String str) {
        if (str == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<CompetitionStage>() {}.getType();

        return gson.fromJson(str, type);
    }

    @TypeConverter
    public String fromVenue(Venue obj) {
        if (obj == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Venue>() {}.getType();

        return gson.toJson(obj, type);
    }

    @TypeConverter
    public Venue toVenue(String str) {
        if (str == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Venue>() {}.getType();

        return gson.fromJson(str, type);
    }
}
