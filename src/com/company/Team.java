package com.company;

/**
 * @author James Kiernan
 * @version 0.0.1
 *
 * #TODO: Finish getters and setters for this class.
 */
enum TeamType{INTERNATIONAL, CLUB}

public class Team {
    private String t_name;
    private TeamType t_type;
    private int t_gamesWon = 0;
    private int t_gamesLost = 0;
    private int t_gamesDraw = 0;
    private int t_goalsScored = 0;
    private int t_goalsAgainst = 0;


    /**
     * Called for loading existing data from database into Team object.
     * @param name name of Team
     * @param isClub Boolean to determine if club or international team
     * @param gamesWon Games won by team so far or in total
     * @param gamesDraw Games drawn by team so far or in total
     * @param gamesLost Games lost by team so far or in total
     * @param goalsScored Goals scored by team so far or in total
     * @param goalsAgainst Goals conceded by team so far or in total
     */
    public Team(String name, boolean isClub, int gamesWon, int gamesDraw, int gamesLost,
                int goalsScored, int goalsAgainst){
        setName(name);
        setClubType(isClub);
        t_gamesWon = gamesWon;
        t_gamesDraw = gamesDraw;
        t_gamesLost = gamesLost;
        t_goalsScored = goalsScored;
        t_goalsAgainst = goalsAgainst;
    }

    /**
     * Called when new team is created or a new season starts.
     * @param name name of Team
     * @param isClub Boolean to determine if club or international team
     */
    public Team(String name, boolean isClub){
        setName(name);
        setClubType(isClub);
    }
    /*
    Team functions
     */

    /**
     * Set the type of the club
     * @param isClub The type of the club
     */
    private void setClubType(boolean isClub){
        if(isClub){
            t_type = TeamType.CLUB;
        }
        else{
            t_type = TeamType.INTERNATIONAL;
        }
    }

    public TeamType getClubType(){
        return t_type;
    }
    /**
     * Enter the match results of the Fixture played by the Team
     * @param goalsScored The goals scored by the Team in the Fixture
     * @param goalsConceded The goals conceded by the Team in the Fixture
     */
    public void determineMatchResult(int goalsScored, int goalsConceded){
        if(goalsScored > goalsConceded){
            this.t_gamesWon++;
        }
        else if(goalsScored < goalsConceded){
            this.t_gamesLost++;
        }
        else{
            this.t_gamesDraw++;
        }
        this.t_goalsScored = goalsScored;
        this.t_goalsAgainst = goalsConceded;
    }

    /**
     * Generates and returns the amount of points generated by the Team
     * @return Total points (int)
     */
    public int getTotalPoints(){
        return (this.t_gamesWon * 3) + this.t_gamesDraw;
    }

    /**
     * Generates and returns the difference in goals scored and conceded by the Team
     * @return Goal Difference (int)
     */
    public int getGoalDifference(){
        return (this.getGoalsScored() - this.getGoalsAgainst());
    }

    public int getGamesPlayed(){
        return (this.t_gamesWon + this.t_gamesDraw + this.t_gamesLost);
    }

    public String generateTeamStats(){
        return "Name: " + this.getName() + "\t" +
                "Games Played: " + this.getGamesPlayed() + "\t" +
                "Points: " + this.getTotalPoints() + "\t" +
                "Games Won: " + this.getGamesWon() + "\t" +
                "Games Drawn: " + this.getGamesDraw() + "\t" +
                "Games Lost: " + this.getGamesLost() + "\t" +
                "Goals Scored: " + this.getGoalsScored() + "\t" +
                "Goals Against: " + this.getGoalsAgainst() + "\t" +
                "Goal Difference: " + this.getGoalDifference() + "\t";
    }

    /*
    Getters and setters
     */
    /**
     * Get the name of the Team
     * @return Team name (String)
     */
    public String getName() {
        return t_name;
    }

    /**
     * Set the name of the Team
     * @param t_name Team name (String)
     */
    private void setName(String t_name) {
        this.t_name = t_name;
    }

    /**
     * Returns the amount of games won by the Team
     * @return Games won by Team (int)
     */
    public int getGamesWon() {
        return t_gamesWon;
    }

    /**
     * Returns the amount of games lost by the Team
     * @return Games lost by the Team (int)
     */
    public int getGamesLost() {
        return t_gamesLost;
    }

    /**
     * Returns the amount of games drawn by the Team
     * @return Games drawn by the Team (int)
     */
    public int getGamesDraw() {
        return t_gamesDraw;
    }

    /**
     * Returns the amount of goals scored by the Team
     * @return Goals scored by the Team (int)
     */
    public int getGoalsScored() {
        return t_goalsScored;
    }

    /**
     * Returns the amount of goals conceded by the Team
     * @return Goals conceded by the Team (int)
     */
    public int getGoalsAgainst() {
        return t_goalsAgainst;
    }
}
