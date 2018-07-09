package com.example.teknasyon.myapplication;


import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TeamPreference {

    private static final String KEY_TEAMS = "KEY_TEAMS";


    public static void writeTeams(List<Team> teams) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.applicationContext);
        SharedPreferences.Editor editor = preferences.edit();

        Gson gson = new Gson();
        String data = gson.toJson(teams);
        editor.putString(data, KEY_TEAMS);
        editor.apply();
    }

    @Nullable
    public static List<Team> readTeams() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.applicationContext);
        String myString = preferences.getString(KEY_TEAMS, "");
        Gson gson = new Gson();
        Team[] mcArray = gson.fromJson(myString, Team[].class);

        return mcArray == null ? null : new ArrayList<>(Arrays.asList(mcArray));
    }

}
