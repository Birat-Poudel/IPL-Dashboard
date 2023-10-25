package com.biratpoudel.ipldashboard.repository;

import com.biratpoudel.ipldashboard.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

}