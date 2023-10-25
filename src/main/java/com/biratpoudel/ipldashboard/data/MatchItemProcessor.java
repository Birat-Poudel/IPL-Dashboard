package com.biratpoudel.ipldashboard.data;

import java.time.LocalDate;

import com.biratpoudel.ipldashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class MatchItemProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchItemProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) {

        Match match = new Match();

        match.setCity(matchInput.city());
        match.setDate(LocalDate.parse(matchInput.date()));
        match.setPlayerOfMatch(matchInput.player_of_match());
        match.setVenue(matchInput.venue());

        String firstInningsTeam, secondInningsTeam;

        if ("bat".equals(matchInput.toss_decision())) {
            firstInningsTeam = matchInput.toss_winner();
            secondInningsTeam = matchInput.toss_winner().equals(matchInput.team1())
                    ? matchInput.team2() : matchInput.team1();

        } else {
            secondInningsTeam = matchInput.toss_winner();
            firstInningsTeam = matchInput.toss_winner().equals(matchInput.team1())
                    ? matchInput.team2() : matchInput.team1();
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);

        match.setTossWinner(matchInput.toss_winner());
        match.setTossDecision(matchInput.toss_decision());
        match.setMatchWinner(matchInput.match_winner());
        match.setEliminator(matchInput.eliminator());
        match.setMethod(matchInput.method());
        match.setResult(matchInput.result());
        match.setResultMargin(matchInput.result_margin());
        match.setUmpire1(matchInput.umpire1());
        match.setUmpire2(matchInput.umpire2());

        log.info("Converting (" + matchInput + ") into (" + match + ")");
        return match;
    }
}
