package com.example.teknasyon.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamDetails {

    @SerializedName("name")
    @Expose
    public String team_name;

    @SerializedName("founded")
    @Expose
    public String founded;

    @SerializedName("venue_name")
    @Expose
    public String venue_name;

    @SerializedName("venue_capacity")
    @Expose
    public String venue_capacity;

    @SerializedName("coach_name")
    @Expose
    public String coach_name;

    @SerializedName("squad")
    List<Player> squad;


}
