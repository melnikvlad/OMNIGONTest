package com.example.omnigontest.data.results.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AggregateScore {
    @SerializedName("home")
    @Expose
    public int home;
    @SerializedName("away")
    @Expose
    public int away;
    @SerializedName("winner")
    @Expose
    public String winner;

}
