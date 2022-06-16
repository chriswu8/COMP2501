package ca.bcit.comp2501.lab2;

/**
 * @author Chris Wu and Mika Campbell Nishimura
 * @version 1.0
 */

public class Main {

    /**
     *
     * @param name is the name of the student name
     * @param date is the student's date of birth
     * @param student is the Student of interest
     */
    public static void printStudentInfo(Name name, Date date, Student student) {
        if (student.isGraduated()) {
            System.out.println(name.getFullName() + " (" + name.getInitials() + ") " + "(" + "st # " + student.getStudentNumber()
                    + ") was born on " + date.getYyMmDd() + ". The student has graduated.");
        } else {
            System.out.println(name.getFullName()  + " (" + name.getInitials() + ") " + "(" + "st # " + student.getStudentNumber()
                    + ") was born on " + date.getYyMmDd() + ". The student has not graduated.");
        }
    }

    /**
     *
     * This is the entry point of the program.
     */
    public static void main(String[] args) {
        Name name1 = new Name("Tiger", "Woods");
        Date date1 = new Date("1975", "12", "30");
        Student student1 = new Student(name1, "A00123456", date1, true);

        Name name2 = new Name("Bill", "Gates");
        Date date2 = new Date("1955", "10", "28");
        Student student2 = new Student(name1, "A00987654", date1, false);

        printStudentInfo(name1, date1, student1);
        printStudentInfo(name2, date2, student2);
    }
}
