package com.example.omnigontest.data.remote.model.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeTeam {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("shortName")
    @Expose
    public String shortName;
    @SerializedName("abbr")
    @Expose
    public String abbr;
    @SerializedName("alias")
    @Expose
    public String alias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
