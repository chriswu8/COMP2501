package ca.bcit.comp2501.lab7;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/**
 * The League Class represents an ultimate frisbee league.
 * @author Chris Wu
 * @version 1.0
 */
public class League
{
    private static final int               TOTAL_NUM_GAMES     = 3;
    private static final int               INITIAL_GAME_NUMBER = 1;
    private final        String            leagueName;
    private final        String            rules;
    private final        Map<String, Team> teams;
    private static       List<String>      gamesLocation;
    private final        List<String>      teamNames;
    private final        List<String>      coaches;
    private final        List<String>      gameTimes;
    private final        List<Player>      matchingAgainstMen;
    private final        List<Player>      matchingAgainstWomen;

    /**
     * The League constructor
     * @param leagueName           is the league's game
     * @param teams                is the hashmap that contains the teams
     * @param gamesLocation        is the array list that contains the game locations
     * @param teamNames            is the array list that contains the team names
     * @param coaches              is the array list that contains the coaches' names
     * @param gameTimes            is the array list that contains the start time of the games
     * @param matchingAgainstMen   is the array list that contains the players who match against men
     * @param matchingAgainstWomen is the array list that contains the players who match against women
     */
    public League(
            final String leagueName,
            final HashMap<String, Team> teams,
            final ArrayList<String> gamesLocation,
            final ArrayList<String> teamNames,
            final ArrayList<String> coaches,
            final ArrayList<String> gameTimes,
            final ArrayList<Player> matchingAgainstMen,
            final ArrayList<Player> matchingAgainstWomen
    )
    {
        this.leagueName = leagueName;
        this.rules = "See https://www.vul.ca/content/rules";
        this.teams = teams;
        this.gamesLocation = gamesLocation;
        this.teamNames = teamNames;
        this.coaches = coaches;
        this.gameTimes = gameTimes;
        this.matchingAgainstMen = matchingAgainstMen;
        this.matchingAgainstWomen = matchingAgainstWomen;
    }

    /**
     * The entry point of the program.
     * @param args is the command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        List<String> gamesLocation;
        gamesLocation = new ArrayList<>();

        List<String> teamNames;
        teamNames = new ArrayList<>();

        List<String> coaches;
        coaches = new ArrayList<>();

        List<String> gameTimes;
        gameTimes = new ArrayList<>();

        List<Player> matchingAgainstMen;
        matchingAgainstMen = new ArrayList<>();

        List<Player> matchingAgainstWomen;
        matchingAgainstWomen = new ArrayList<>();


        Player anna = new Player("Anna", "Abey", 20,
                                 "women", 11,
                                 "cutter", TOTAL_NUM_GAMES, INITIAL_GAME_NUMBER,
                                 4, "Traffic");


    }


}
