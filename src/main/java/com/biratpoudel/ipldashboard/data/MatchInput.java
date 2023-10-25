package com.biratpoudel.ipldashboard.data;

public record MatchInput (String city, String date, String player_of_match,
                     String venue, String team1, String team2,
                     String toss_winner, String toss_decision, String match_winner,
                     String result, String result_margin,
                     String eliminator, String method,
                     String umpire1, String umpire2
){};