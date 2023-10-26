package com.biratpoudel.ipldashboard.controller;

import com.biratpoudel.ipldashboard.model.Team;

import com.biratpoudel.ipldashboard.repository.MatchRepository;
import com.biratpoudel.ipldashboard.service.TeamService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class TeamController {

    private final TeamService teamService;
    private final MatchRepository matchRepository;

    public TeamController(TeamService teamService, MatchRepository matchRepository) {
        this.teamService = teamService;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName) {

        Pageable pageable = PageRequest.of(0,4);

        Team team = teamService.findByTeamName(teamName);
        team.setMatches(matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable));
        return team;
    }

    @GetMapping("/teams")
    public String getTeams() {
        return "Hello";
    }
}
