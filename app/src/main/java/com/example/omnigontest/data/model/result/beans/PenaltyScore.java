package com.example.omnigontest.data.model.result.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PenaltyScore {
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
