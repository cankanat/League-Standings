package com.example.teknasyon.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailActivity extends AppCompatActivity {

    RestInterface restInterface;
    ProgressBar mprogressBar;

    private TextView team_name, founded, venue_name, venue_capacity, coach_name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_content);
        String team_id = getIntent().getStringExtra("deger");

        mprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        mprogressBar.setVisibility(View.VISIBLE);


        team_name = findViewById(R.id.team_name);
        founded = findViewById(R.id.founded_year);
        venue_name = findViewById(R.id.stadium_name);
        venue_capacity = findViewById(R.id.capacity_number);
        coach_name = findViewById(R.id.coach_name);


        restInterface = ApiClient.getClient().create(RestInterface.class);
        Call<TeamDetails> detailsCall = restInterface.getTeamDetails(team_id);

        detailsCall.enqueue(new Callback<TeamDetails>() {
            @Override
            public void onResponse(Call<TeamDetails> call, Response<TeamDetails> response) {
                TeamDetails teamDetails = response.body();

                team_name.setText(teamDetails.team_name);
                founded.setText(teamDetails.founded);
                venue_name.setText(teamDetails.venue_name);
                venue_capacity.setText(teamDetails.venue_capacity);
                coach_name.setText(teamDetails.coach_name);

                mprogressBar.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<TeamDetails> call, Throwable t) {

            }
        });




    }




}
