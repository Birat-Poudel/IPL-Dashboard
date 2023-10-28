package com.biratpoudel.ipldashboard.service;

import com.biratpoudel.ipldashboard.model.Match;
import com.biratpoudel.ipldashboard.repository.MatchRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService{

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getMatchesByTeamBetweenDates(String teamName, LocalDate dateStart, LocalDate dateEnd){
        return matchRepository.getMatchesByTeamBetweenDates(teamName, dateStart, dateEnd);
    }

    @Override
    public List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable) {
        return matchRepository.getByTeam1OrTeam2OrderByDateDesc(team1, team2, pageable);
    }
}
