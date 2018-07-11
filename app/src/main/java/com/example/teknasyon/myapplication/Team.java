package com.example.teknasyon.myapplication;


import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team implements Comparable<Team> {

    @SerializedName("team_id")
    @Expose
    public String team_id;

    @SerializedName("team_name")
    @Expose
    public String teamName;

    @SerializedName("position")
    public String position;

    @SerializedName("overall_gp")
    @Expose
    public String overallGp;

    @SerializedName("points")
    @Expose
    public String points;


    @Override
    public int compareTo(@NonNull Team team) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        int thisPosition = Integer.parseInt(this.position);
        int teamPosition = Integer.parseInt(team.position);

        if (thisPosition > teamPosition) {
            return AFTER;
        } else if (thisPosition < teamPosition) {
            return BEFORE;
        } else {
            return EQUAL;
        }
    }

    public String getTeamName() {
        return teamName;
    }
}