package ca.bcit.comp2501.lab8;

import java.util.Scanner;

/**
 * The Student class models a student
 * @author Chris Wu
 * @version 1.0
 */
public class Student
{
    private final String  firstName;
    private final String  lastName;
    private final int     id;
    private final int     birthYear;
    private final double  percentageGrade;
    private final boolean pass;

    private static final int PASSING_GRADE = 60;

    /**
     * This is the Student constructor
     */
    public Student()
    {
        Scanner myScanner;
        myScanner = new Scanner(System.in);

        System.out.println("What is the student's first name? ");
        this.firstName = myScanner.next();

        System.out.println("What is the student's last name? ");
        this.lastName = myScanner.next();

        System.out.println("What is the student's id? ");
        this.id = myScanner.nextInt();

        System.out.println("What is the student's last year of birth? ");
        this.birthYear = myScanner.nextInt();

        System.out.println("What is the student's grade in percentage? ");
        this.percentageGrade = myScanner.nextDouble();

        if(percentageGrade >= PASSING_GRADE)
        {
            this.pass = true;
        }
        else
        {
            this.pass = false;
        }

        myScanner.close();
    }


}
