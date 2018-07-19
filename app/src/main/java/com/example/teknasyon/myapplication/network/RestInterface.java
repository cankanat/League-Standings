package com.example.teknasyon.myapplication.network;

import com.example.teknasyon.myapplication.network.model.Team;
import com.example.teknasyon.myapplication.network.model.TeamDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestInterface {

    @GET("2.0/standings/{ligId}?Authorization=565ec012251f932ea4000001fa542ae9d994470e73fdb314a8a56d76")
    Call<List<Team>> getTeam(@Path("ligId") int ligId);

    @GET("2.0/team/{teamId}?Authorization=565ec012251f932ea4000001fa542ae9d994470e73fdb314a8a56d76")
    Call<TeamDetails> getTeamDetails(@Path("teamId") String teamId);



}
