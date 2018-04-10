package com.company;
import java.util.ArrayList;
import java.util.Comparator;

public class League {
    /**
     * This is the comparator to sort the league table.
     * Sorts by points first, than goal difference, than finally goals scored
     */
    private class TeamComparator implements Comparator<Team> {
        @Override
        public int compare(Team one, Team two){
            int byPoints = Integer.compare(two.getTotalPoints(), one.getTotalPoints());
            if(byPoints == 0){
                int byGoalDiff = Integer.compare(two.getGoalDifference(), one.getGoalDifference());
                if(byGoalDiff == 0){
                    return Integer.compare(two.getGoalsScored(), one.getGoalsScored());
                }
                return byGoalDiff;
            }
            return byPoints;
        }
    }

    private ArrayList<Team> l_teams;

    public League(ArrayList<Team> teams){
        l_teams = teams;
    }

    public void sortLeagueTable(){
        l_teams.sort(new TeamComparator());
    }

    public void printLeagueTable(){
        for(int i=0; i < l_teams.size(); i++){
            System.out.println(l_teams.get(i).generateTeamStats());
            System.out.println();
        }
    }
}
