package ca.bcit.comp2501.lab8;

import java.util.Scanner;

/**
 * The Student class models a student
 * @author Chris Wu & Shivneil Prakash
 * @version 1.0
 */
public class Student
{
    private final        String  firstName;
    private final        String  lastName;
    private final        String  id;
    private final        int     birthYear;
    private final        double  percentageGrade;
    private final        boolean pass;
    private static final int     PASSING_GRADE                = 60;
    private static final int     EARLIEST_POSSIBLE_BIRTH_YEAR = 1900;
    private static final int CURRENT_YEAR = 2022;

    /**
     * This is the Student constructor
     */
    public Student(final Scanner myScanner)
    {
        final String  firstName;
        final String  lastName;
        final String  id;
        final int     birthYear;
        final double  percentageGrade;
        final boolean pass;

        System.out.println("What is the student's first name? ");
        firstName = checkName(myScanner.next());
        this.firstName = firstName;

        System.out.println("What is the student's last name? ");
        lastName = checkName(myScanner.next());
        this.lastName = lastName;

        System.out.println("What is the student's id number? ");
        id = checkId(myScanner.next());
        this.id = id;

        System.out.println("What is the student's year of birth? ");
        birthYear = checkBirthYear(myScanner.next());
        this.birthYear = birthYear;

        System.out.println("What is the student's grade in percentage? ");
        percentageGrade = checkGrade(myScanner.next());
        this.percentageGrade = percentageGrade;

        pass = determinePass();
        this.pass = pass;
    }

    /**
     * @return true if the percentage grade is greater of  equal to the PASSING_GRADE
     */
    private boolean determinePass()
    {
        return percentageGrade >= PASSING_GRADE;
    }

    /**
     * @param testString is the string that is to be checked for whether it is a double
     * @return the parsed test string as a double
     * @throws IllegalArgumentException is thrown if the test string is not parsable as a double
     */
    private double checkGrade(final String testString) throws IllegalArgumentException
    {
        try
        {
            return Double.parseDouble(testString);
        } catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("invalid percentage grade");
        }
    }

    /**
     * @param testString is the string that is to be checked for whether it consists of a four-digit int
     * @return the parsed test string as a four-digit int
     * @throws IllegalArgumentException is thrown if the test string is not parsable as a four-digit int
     */
    private int checkBirthYear(final String testString)
    {
        final int yearLength = 4;

        if(testString != null)
        {
            if(testString.length() != yearLength)
            {
                throw new IllegalArgumentException("Invalid birth year: must contain four digits.");
            }
            if(Integer.parseInt(testString) < EARLIEST_POSSIBLE_BIRTH_YEAR ||
                    Integer.parseInt(testString) > CURRENT_YEAR)
            {
                throw new IllegalArgumentException("Invalid value: This person is not alive.");
            }
            if(areAllDigits(testString))
            {
                return Integer.parseInt(testString);
            }
        }
        throw new IllegalArgumentException("Invalid value: not all characters are digits.");
    }

    /**
     * @param testString is the test string to be checked for whether it consists of all digits
     * @return true if all characters of the test string are digits, else false
     */
    private boolean areAllDigits(final String testString)
    {
        char[] characters = testString.toCharArray();

        for(char character : characters)
        {
            if(!Character.isDigit(character))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @param testString is the string that is to be checked for whether all of its characters are all digits
     * @return the test string if valid
     */
    private String checkId(final String testString)
    {
        int count = 0;
        final int lettersInId;
        lettersInId = 1;

        char[] characters = testString.toCharArray();

        for(char character : characters)
        {
            if(character == 'A')
            {
                count++;
            }
            if(!Character.isDigit(character) && character != 'A' || count > lettersInId)
            {
                throw new IllegalArgumentException("Invalid id");
            }
        }
        return testString;
    }

    /**
     * @param name is either the first or last name of the student
     * @return the name
     */
    private String checkName(final String name)
    {
        if(name != null)
        {
            if(isLetter(name))
            {
                return name;
            }
        }
        throw new IllegalArgumentException("Invalid name input.");
    }

    /**
     * @param testString is the string that is to be checked for whether its characters
     *                   contain only letters or an apostrophe
     * @return the parsed test string as an int
     */
    private boolean isLetter(final String testString)
    {
        final char[] characters;
        final int    apostropheLimit;

        int count = 0;
        apostropheLimit = 1;

        characters = testString.toCharArray();

        for(char character : characters)
        {
            if(!Character.isLetter(character) && character != '\'')
            {
                return false;
            }
            if(character == '\'')
            {
                count++;
            }
            if(count > apostropheLimit)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the minimum grade required to pass
     */
    public static int getPassingGrade()
    {
        return PASSING_GRADE;
    }

    /**
     * @return the student's id number
     */
    public String getId()
    {
        return id;
    }

    @Override
    /**
     * The toString method returns the information of this student.
     * @return the information of this student.
     */
    public String toString()
    {
        return "Student [firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", idNumber=" + this.id
                + ", ageYears=" + (CURRENT_YEAR - this.birthYear)
                + ", gradePct=" + this.percentageGrade
                + " pass=" + pass + "]";
    }
}
