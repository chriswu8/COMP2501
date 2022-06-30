package ca.bcit.comp2501.wu.haren;


/**
 * The Person models a person
 * @author Chris Wu and Sam Van Haren
 * @version 1.0
 */
public class Person
{
    private             String firstName;
    private             String lastName;
    private final       int    birthYear;
    private             String married;
    private             int    weightLbs;
    private             String highestEducationLevel;
    public static final int    CURRENT_YEAR = 2022;

    /**
     * The first Person constructor
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

        if(isValidMarriageStatus(married))
        {
            this.married = married.toLowerCase();
        } else
        {
            throw new IllegalArgumentException("invalid marital status");
        }

        this.weightLbs = weightLbs;

        if(isValidEducationLevel(highestEducationLevel))
        {
            this.highestEducationLevel = highestEducationLevel.toLowerCase();
        } else
        {
            throw new IllegalArgumentException("invalid highest education level");
        }

    }

    /**
     * The second Person constructor
     * @param firstName             is the person's first name
     * @param lastName              is the person's last name
     * @param married               is the person's marital status (yes, no, or divorced)
     * @param weightLbs             is the person's weight in pounds
     * @param highestEducationLevel is the person's highest education level (high school / undergraduate / graduate)
     */
    public Person(final String firstName,
            final String lastName,
            final String married,
            final int weightLbs,
            final String highestEducationLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;

        if(isValidMarriageStatus(married))
        {
            this.married = married.toLowerCase();
        } else
        {
            throw new IllegalArgumentException("invalid marital status");
        }

        this.weightLbs = weightLbs;

        if(isValidEducationLevel(highestEducationLevel))
        {
            this.highestEducationLevel = highestEducationLevel.toLowerCase();
        } else
        {
            throw new IllegalArgumentException("invalid highest education level");
        }
    }

    /**
     * The third Person constructor
     * @param firstName is the person's first name
     * @param lastName  is the person's last name
     * @param weightLbs is the person's weight in pounds
     */
    public Person(final String firstName,
            final String lastName,
            final int weightLbs)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        this.married = "no";
        this.weightLbs = weightLbs;
        this.highestEducationLevel = "high school";
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

    /**
     * @param educationLevelToVerify is the string to be verified
     * @return true if the highest education level is only one of the three specified (case-insensitive), else false
     */
    private boolean isValidEducationLevel(final String educationLevelToVerify)
    {
        if(educationLevelToVerify.equalsIgnoreCase("high school")
                && educationLevelToVerify.equalsIgnoreCase("undergraduate")
                && educationLevelToVerify.equalsIgnoreCase("graduate"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * @param status is the marital status
     * @return true if the marital status is only one of the three specified (case-insensitive), else false
     */
    private boolean isValidMarriageStatus(final String status)
    {
        if(status.equalsIgnoreCase("yes")
                && status.equalsIgnoreCase("no")
                && status.equalsIgnoreCase("divorced"))
        {
            return true;
        } else
        {
            return false;
        }
    }


}
