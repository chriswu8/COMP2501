package ca.bcit.comp2501.lab7;

import java.util.List;
import java.util.ArrayList;

/**
 * The Team Class represents an ultimate frisbee team.
 * @author Chris Wu
 * @version 1.0
 */
public class Team
{
    private final        String            teamName;
    private final        List<Player>      roster;
    private final        String            coach;
    private final        int               NUM_OF_GAMES         = 3;
    private final        List<String>      gameLocation;
    private final        ArrayList<String> gameTimes;
    private final        double[]          spiritPoints;
    private final        List<Player>      matchingAgainstMen;
    private final        List<Player>      matchingAgainstWomen;
    private static final double            INITIAL_SPIRIT       = 0.0;
    private static final int               INITIAL_WIN_LOSS_TIE = 0;
    private              double            spirit;
    private              int               wins;
    private              int               losses;
    private              int               ties;

    public Team(
            final String teamName,
            final String coach,
            final int spirit
    )
    {
        this.teamName = teamName;
        this.coach = coach;
        this.spirit = spirit;
        this.wins = INITIAL_WIN_LOSS_TIE;
        this.losses = INITIAL_WIN_LOSS_TIE;
        this.ties = INITIAL_WIN_LOSS_TIE;

        roster = new ArrayList<Player>();
        gameLocation = new ArrayList<>();
        gameTimes = new ArrayList<>();

        spiritPoints = new double[NUM_OF_GAMES];
        matchingAgainstMen = new ArrayList<Player>();
        matchingAgainstWomen = new ArrayList<Player>();
    }


    public void printTeamInfo()
    {

    }

    public void addToRoster(final Player player)
    {

    }

    public void scrimmage()
    {

    }

    public void train()
    {

    }

    public void bond()
    {

    }

    public void playGame(final Team team2)
    {

    }

    public void winGame(final Team team2)
    {

    }

    public void loseGame(final String team2Name)
    {

    }

    public void tieGame(final String team2Name)
    {

    }

    public void checkWinsLossesTies()
    {

    }

    public void calculateSpirit()
    {

    }

    public void assignSpiritPoint()
    {

    }

}
