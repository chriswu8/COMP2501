package ca.bcit.comp2501.lab8;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * The Lab8Driver class is the driver class
 * @author Chris Wu
 * @version 1.0
 */
public class Lab8Driver
{
    private final HashMap<String, Student> students;

    public Lab8Driver()
    {
        students = new HashMap<>();
        Set<String> keys;
        keys = students.keySet();
    }

    public void readFromPrompt(Scanner scanner)
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

    /**
     * This is the entry point of the program.
     * @param args are the command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        Scanner    scanner;
        Lab8Driver driverObj;

        scanner = new Scanner(System.in);
        driverObj = new Lab8Driver();

        driverObj.readFromPrompt(scanner);

        scanner.close();
    }
}
