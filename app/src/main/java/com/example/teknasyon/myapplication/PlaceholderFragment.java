package com.example.teknasyon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaceholderFragment extends Fragment implements OnTeamClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView postList;
    public TeamAdapter adapter;

    RestInterface restInterface;

    ArrayList<Team> teamList = new ArrayList<>();
    ArrayList<Team> firstItems = new ArrayList<>();

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        postList = rootView.findViewById(R.id.postList);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        restInterface = ApiClient.getClient().create(RestInterface.class);

        List<Team> teamList = TeamPreference.readTeams();
        if (teamList != null && teamList.isEmpty()) {
            this.teamList.addAll(teamList);
            this.firstItems.addAll(teamList);
        } else {
            int ligId = getArguments().getInt(ARG_SECTION_NUMBER);
            callService(ligId);
        }

        adapter = new TeamAdapter(getContext(), this.teamList);
        adapter.setTeamClickListener(this);
        postList.setLayoutManager(new LinearLayoutManager((getContext())));
        postList.setAdapter(adapter);
    }

    private void callService(int ligId) {
        Call<List<Team>> call = restInterface.getTeam(ligId);
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                Collections.sort(response.body());
                TeamPreference.writeTeams(response.body());

                teamList.addAll(response.body());
                firstItems.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onTeamClick(Team team) {
        Intent teamContent = new Intent(getActivity(), TeamDetailActivity.class);
        teamContent.putExtra("deger", team.team_id);
        startActivity(teamContent);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem item = menu.findItem(R.id.action_search);


        SearchView sv = new SearchView(getContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("search query submit");
                List<Team> search_list = new ArrayList<>();

                for (Team team : teamList) {
                    if (team.getTeamName().toLowerCase().contains(query)) {
                        search_list.add(team);
                    }
                }
                adapter.setItems(search_list);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("tap");
                return false;
            }
        });
        sv.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                adapter.setItems(firstItems);
                return false;
            }
        });
    }


}