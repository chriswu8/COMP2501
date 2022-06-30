package ca.bcit.comp2501.wu.haren;


/**
 * The Person models a person
 * @author Chris Wu and Sam Van Haren
 * @version 1.0
 */
public class Person
{
    private       String firstName;
    private       String lastName;
    private final int    birthYear;
    private       String married;
    private       int    weightLbs;
    private       String highestEducationLevel;

    /**
     * The Person constructor
     * @param firstName             is the person's first name
     * @param lastName              is the person's last name
     * @param birthYear             is the person's birth year
     * @param married               is the person's marital status (yes, no, or divorced)
     * @param weightLbs             is the person's weight in pounds
     * @param highestEducationLevel is the person's highest education level (high school / undergraduate / graduate)
     */
    public Person(final String firstName,
            final String lastName,
            final int birthYear,
            final String married,
            final int weightLbs,
            final String highestEducationLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        this.birthYear = birthYear;
        this.married = married;
        this.weightLbs = weightLbs;
        this.highestEducationLevel = highestEducationLevel;
    }

    /**
     * @return the person's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the person's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the person's birth year name
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * @return the person's marital status (yes, no, or divorced)
     */
    public String isMarried()
    {
        return married;
    }

    /**
     * @return the person's weight in pounds
     */
    public int getWeightLbs()
    {
        return weightLbs;
    }

    /**
     * @return the person's highest level of education (high school / undergraduate / graduate)
     */
    public String getHighestEducationLevel()
    {
        return highestEducationLevel;
    }

    /**
     * @param firstName is the person's first name to be set
     */
    public void setFirstName(final String firstName)
    {
        if(firstName != null)
        {
            this.firstName = firstName;
        }
    }

    /**
     * @param lastName is the person's last name to be set
     */
    public void setLastName(final String lastName)
    {
        if(lastName != null)
        {
            this.lastName = lastName;
        }
    }

    /**
     * @param maritalStatus is the person's marital status that is to be set
     */
    public void setMarried(final String maritalStatus)
    {
        if(maritalStatus != null && !maritalStatus.isBlank())
        {
            if(maritalStatus.equalsIgnoreCase("yes")
                    || maritalStatus.equalsIgnoreCase("no")
                    || maritalStatus.equalsIgnoreCase("divorced"))
            {
                this.married = maritalStatus.toLowerCase();
            }
        }
    }

    /**
     * @param weightLbs is the person's weight in pounds that is to be set
     */
    public void setWeightLbs(final int weightLbs)
    {
        if(weightLbs > 0)
        {
           this.weightLbs = weightLbs;
        }
    }

    /**
     * @param level is the person's current highest level of education that is to be set
     */
    public void setHighestEducationLevel(final String level)
    {
        if(level != null && !level.isBlank())
        {
            if(level.equalsIgnoreCase("high school")
                    && level.equalsIgnoreCase("undergraduate")
                    && level.equalsIgnoreCase("graduate"))
            {

                this.highestEducationLevel = level.toLowerCase();
            }
        }
    }


    


}
