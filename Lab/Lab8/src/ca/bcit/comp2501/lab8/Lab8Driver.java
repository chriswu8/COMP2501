package ca.bcit.comp2501.lab8;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The Lab8Driver class is the driver class
 * @author Chris Wu
 * @version 1.0
 */
public class Lab8Driver
{
    private final        HashMap<String, Student> students;
    private static final String                   DELIMITER     = "\\|";
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX  = 1;
    private static final int STUDENT_ID_INDEX = 2;
    private static final int AGE_INDEX        = 3;
    private static final int GRADE_INDEX      = 4;

    public Lab8Driver()
    {
        students = new HashMap<>();
    }

    public void readFromPrompt(final Scanner scanner)
    {
        Student student;
        boolean proceed;
        String  choice;

        proceed = true;

        do
        {
            System.out.println("Do you wish to create a Student? (y/n): ");
            choice = scanner.next().toLowerCase();

            if(choice.equals("y"))
            {
                student = new Student(scanner);

                students.put(String.valueOf(student.getId()), student);
            }
            else
            {
                proceed = false;
                System.out.println("Data entry finished!");
            }
        } while(proceed);
    }

    public void readFromFile(final Scanner fileScanner)
    {
        String line;
        String formattedOutput;

        while(fileScanner.hasNextLine())
        {
            line = fileScanner.nextLine();
            formattedOutput = formatOutput(line);
            System.out.println(formattedOutput);
        }

    }

    private String formatOutput(final String line)
    {
        String[] strArray;

        String formattedString;

        strArray = line.split(DELIMITER);
        formattedString = "Student [firstName=" + strArray[FIRST_NAME_INDEX]
                + ", lastName=" + strArray[LAST_NAME_INDEX]
                + ", idNumber=" + strArray[STUDENT_ID_INDEX]
                + ", ageYears=" + strArray[AGE_INDEX]
                + ", gradePct=" + strArray[GRADE_INDEX]
                + ", pass=" + (Double.valueOf(strArray[GRADE_INDEX]) >= Student.getPassingGrade()) + "]";

        return formattedString;
    }

    /**
     * This is the entry point of the program.
     * @param args are the command line arguments (unused)
     */
    public static void main(final String[] args) throws FileNotFoundException
    {
        Scanner    scanner, fileScanner;
        File       file;
        Lab8Driver driverObj;

        scanner = new Scanner(System.in);
        driverObj = new Lab8Driver();

//        driverObj.readFromPrompt(scanner);

        scanner.close();

        // ==========================================

        file = new File("student_data.txt");
        fileScanner = new Scanner(file);

        driverObj.readFromFile(fileScanner);

        fileScanner.close();
    }
}