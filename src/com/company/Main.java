package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoadTestTeams test = new LoadTestTeams();
        ArrayList<Team> testTeams = test.loadSampleTeams();
        League testLeague = new League(testTeams);
        testLeague.sortLeagueTable();
        testLeague.printLeagueTable();
    }
}