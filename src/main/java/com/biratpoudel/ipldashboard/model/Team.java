package com.biratpoudel.ipldashboard.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String teamName;
    private long totalMatches;
    private long totalWins;

    @Getter
    @Setter
    @Transient
    private List<Match> matches;

}
