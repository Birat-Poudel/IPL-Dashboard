package com.biratpoudel.ipldashboard.service;

import com.biratpoudel.ipldashboard.model.Team;
import com.biratpoudel.ipldashboard.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }
}