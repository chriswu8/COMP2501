package ca.bcit.comp2501.lab7;

import java.util.Map;
import java.util.HashMap;

/**
 * The Player Class represents an ultimate frisbee player.
 * @author Chris Wu
 * @version 1.0
 */
public class Player
{
    private final String firstName;
    private final String lastName;
    private final int    age;
    private       String gameMatchingGender;
    private final int    jerseyNumber;

    private final String role;

    private static       int                   gamesPerSeason           = 0;
    private static       int                   currentGameNumber;
    private static final int                   INITIAL_SCORE_AND_ASSIST = 0;
    private final        Map<Integer, Integer> goalsScoredEachGame;
    private final        Map<Integer, Integer> goalsAssistedEachGame;
    private              int                   goalsScoredThisSeason;
    private              int                   goalsAssistedThisSeason;
    private              int                   yearsOfExperience;
    private final        String                teamName;


    public Player(
            final String firstName,
            final String lastName,
            final int age,
            final String gameMatchingGender,
            final int jerseyNumber,
            final String role,
            final int gamesPerSeason,
            final int currentGameNumber,
            final int yearsOfExperience,
            final String teamName
    )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gameMatchingGender = gameMatchingGender;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.gamesPerSeason = gamesPerSeason;
        this.currentGameNumber = currentGameNumber;
        this.yearsOfExperience = yearsOfExperience;
        this.teamName = teamName;

        goalsScoredEachGame = new HashMap<>();
        goalsAssistedEachGame = new HashMap<>();
    }


    public void printPlayerInfo()
    {

    }

    public void cheerForTeammates()
    {
    }

    public void callFoul(final Player firstName, final Player lastName)
    {
    }

    public void callTravel(final Player firstName, final Player lastName
    )
    {

    }

    public void contestCall(final Player firstName, final Player lastName)
    {
    }

    public void huck(final Player firstName, final Player lastName)
    {
    }

    public void cut()
    {
    }

    public void handlerCut()
    {
    }

    public void getsOpenForPass()
    {

    }

    public void strikeDeep()
    {

    }

    public void callInjurySubstitute()
    {

    }

    public void forehandThrow(final Player firstName, final Player lastName)
    {

    }

    public void backhandThrow(final Player firstName, final Player lastName)
    {

    }

    public void scores(final Player catcherFirstName, final Player catcherLastName)
    {

    }

    public void setGameMatchingGender(final String genderMatch)
    {

    }

    public void setCurrentGameNumber(final int gameNumber)
    {

    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public int getJerseyNumber()
    {
        return jerseyNumber;
    }


}
