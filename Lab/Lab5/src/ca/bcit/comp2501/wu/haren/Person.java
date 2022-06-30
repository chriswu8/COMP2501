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
    private             double weightLbs;
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
            final double weightLbs,
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
            final double weightLbs,
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
            final double weightLbs)
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
    public double getWeightLbs()
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
                    || level.equalsIgnoreCase("undergraduate")
                    || level.equalsIgnoreCase("graduate"))
            {
                this.highestEducationLevel = level.toLowerCase();
            }
        } else {
            throw new IllegalArgumentException("invalid level");
        }
    }

    /**
     * @param educationLevelToVerify is the string to be verified
     * @return true if the highest education level is only one of the three specified (case-insensitive), else false
     */
    private boolean isValidEducationLevel(final String educationLevelToVerify)
    {
        return educationLevelToVerify.equalsIgnoreCase("high school")
                || educationLevelToVerify.equalsIgnoreCase("undergraduate")
                || educationLevelToVerify.equalsIgnoreCase("graduate");
    }

    /**
     * @param status is the marital status
     * @return true if the marital status is only one of the three specified (case-insensitive), else false
     */
    private boolean isValidMarriageStatus(final String status)
    {
        return status.equalsIgnoreCase("yes")
                || status.equalsIgnoreCase("no")
                || status.equalsIgnoreCase("divorced");
    }

    /**
     * prints the details of this person.
     */
    public void printDetails()
    {
        String article, maritalStatus, degreeOrDiploma;
        article = article(getHighestEducationLevel());
        maritalStatus = maritalStatus(isMarried());
        degreeOrDiploma = degreeOrDiploma(getHighestEducationLevel());

        System.out.printf("%s %s (%s) was born in %d, weighs %.1f pounds, and has %s %s %s!\n",
                          getFirstName(), getLastName(), maritalStatus, getBirthYear(), getWeightLbs(),
                          article, getHighestEducationLevel(), degreeOrDiploma);
    }

    /**
     * @param highestEducationLevel is this person's highest level of education
     * @return "diploma" if this person's highest level of education is high school, else "degree"
     */
    private String degreeOrDiploma(final String highestEducationLevel)
    {
        if(highestEducationLevel.equalsIgnoreCase("high school"))
        {
            return "diploma";
        } else
        {
            return "degree";
        }
    }

    /**
     * prints the details of this person
     * @param kilograms is true if we want to print this person's weight in kilograms, false if in pounds
     */
    public void printDetails(final boolean kilograms)
    {
        String article, maritalStatus, degreeOrDiploma;
        article = article(getHighestEducationLevel());
        maritalStatus = maritalStatus(isMarried());
        degreeOrDiploma = degreeOrDiploma(getHighestEducationLevel());

        String formattedWeightKg;
        formattedWeightKg = String.format("%.1f", (getWeightLbs() * 0.45359237));

        if(kilograms)
        {
            System.out.printf("%s %s (%s) was born in %d, weighs %s kilograms, and has %s %s %s!\n",
                              getFirstName(), getLastName(), maritalStatus, getBirthYear(),
                              formattedWeightKg, article, getHighestEducationLevel(), degreeOrDiploma);
        } else
        {
            printDetails();
        }

    }

    /**
     * prints the details of this person
     * @param kilograms is true if we want to print this person's weight in kilograms, false if in pounds
     * @param uppercase is true if we want to print this person's full name all in uppercase,
     *                  and false if all in lowercase
     */
    public void printDetails(final boolean kilograms, final boolean uppercase)
    {
        String article, maritalStatus, degreeOrDiploma;
        article = article(getHighestEducationLevel());
        maritalStatus = maritalStatus(isMarried());
        degreeOrDiploma = degreeOrDiploma(getHighestEducationLevel());

        String formattedWeightKg, upperCaseName, lowerCaseName;
        formattedWeightKg = String.format("%.1f", (getWeightLbs() * 0.45359237));
        upperCaseName = getFirstName().toUpperCase() + " " + getLastName().toUpperCase();
        lowerCaseName = getFirstName().toLowerCase() + " " + getLastName().toLowerCase();
        if(kilograms)
        {
            if(uppercase)
            {
                System.out.printf("%s (%s) was born in %d, weighs %s kilograms, and has %s %s %s!\n",
                                  upperCaseName, maritalStatus, getBirthYear(),
                                  formattedWeightKg, article, getHighestEducationLevel(), degreeOrDiploma);
            } else
            {
                System.out.printf("%s (%s) was born in %d, weighs %s kilograms, and has %s %s %s!\n",
                                  lowerCaseName, maritalStatus, getBirthYear(),
                                  formattedWeightKg, article, getHighestEducationLevel(), degreeOrDiploma);
            }

        } else
        {
            if(uppercase)
            {
                System.out.printf("%s (%s) was born in %d, weighs %.1f pounds, and has %s %s %s!\n",
                                  upperCaseName, maritalStatus, getBirthYear(),
                                  getWeightLbs(), article, getHighestEducationLevel(), degreeOrDiploma);
            } else
            {
                System.out.printf("%s (%s) was born in %d, weighs %.1f pounds, and has %s %s %s!\n",
                                  lowerCaseName, maritalStatus, getBirthYear(),
                                  getWeightLbs(), article, getHighestEducationLevel(), degreeOrDiploma);
            }
        }
    }

    /**
     * @param proceedingWord is the string that determines the return article
     * @return "a" when the passed string is "high school" or "graduate", else "an"
     */
    private String article(final String proceedingWord)
    {
        if(proceedingWord.equalsIgnoreCase("high school")
                || proceedingWord.equalsIgnoreCase("graduate"))
        {
            return "a";
        } else
        {
            return "an";
        }
    }

    /**
     * @param married is "yes", "no" or "divorced"
     * @return "married" if the passed parameter is "yes"
     *         "single" if the passed parameter is "no"
     *         "divorced" if the passed parameter is "divorced"
     */
    private String maritalStatus(final String married)
    {
        if(married.equalsIgnoreCase("yes"))
        {
            return "married";
        } else if(married.equalsIgnoreCase("no"))
        {
            return "single";
        } else
        {
            return "divorced";
        }
    }

    /**
     * the entry point of the program
     * @param args is the command line arguments (unused)
     */
    public static void main(String[] args)
    {
        Person p1;
        Person p2;
        Person p3;

        p1 = new Person("Tiger", "Woods", 1975, "divorced", 200, "undergraduate");
        p1.printDetails();
        p1.printDetails(true);
        p1.printDetails(true, true);
        p1.printDetails(true, false);
        p1.printDetails(false, true);
        p1.printDetails(false, false);

        p2 = new Person("Jason", "Wilder", 2000, "no", 180, "graduate");
        p2.printDetails();
        p2.printDetails(true);
        p2.printDetails(true, true);
        p2.printDetails(true, false);
        p2.printDetails(false, true);
        p2.printDetails(false, false);

        p3 = new Person("Santa", "Claus", 1000, "yes", 280, "high school");
        p3.printDetails();
        p3.printDetails(true);
        p3.printDetails(true, true);
        p3.printDetails(true, false);
        p3.printDetails(false, true);
        p3.printDetails(false, false);
    }
}
