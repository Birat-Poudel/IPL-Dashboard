package com.biratpoudel.ipldashboard.service;

import com.biratpoudel.ipldashboard.model.Team;

public interface TeamService {

    Team findByTeamName(String name);
    Iterable<Team> findAll();

}
