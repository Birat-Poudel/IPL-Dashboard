package com.biratpoudel.ipldashboard.controller;

import com.biratpoudel.ipldashboard.model.Match;
import com.biratpoudel.ipldashboard.model.Team;

import com.biratpoudel.ipldashboard.repository.MatchRepository;
import com.biratpoudel.ipldashboard.service.TeamService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin
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

    @GetMapping("/teams/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {

        LocalDate startDate = LocalDate.of(year,1,1);
        LocalDate endDate = LocalDate.of(year + 1,1,1);

//        return matchRepository.getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
//                teamName, startDate, endDate,
//                teamName, startDate, endDate
//        );

        return matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);

    }


}
