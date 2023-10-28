package com.biratpoudel.ipldashboard.service;

import com.biratpoudel.ipldashboard.model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface MatchService {
    List<Match> getMatchesByTeamBetweenDates(String teamName, LocalDate dateStart, LocalDate dateEnd);
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable);

}
