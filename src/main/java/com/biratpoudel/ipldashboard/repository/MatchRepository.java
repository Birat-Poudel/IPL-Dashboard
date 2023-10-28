package com.biratpoudel.ipldashboard.repository;

import com.biratpoudel.ipldashboard.model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m where (m.team1 = :teamName or m.team2 = :teamName) " +
            "AND m.date BETWEEN :dateStart AND :dateEnd " +
            "ORDER BY m.date DESC")
    List<Match> getMatchesByTeamBetweenDates(
            @Param("teamName") String teamName,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd
    );

//    List<Match> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
//            String team1, LocalDate date1, LocalDate date2,
//            String team2, LocalDate date3, LocalDate date4
//    );

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable);
}