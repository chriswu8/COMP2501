package ca.bcit.comp2501.lab2;

/**
 * @author Chris Wu and Mika Campbell Nishimura
 * @version 1.0
 */

public class Student {
    private Name name;

    private String studentNumber;

    private Date dateOfBirth;

    private boolean graduated;


    // the constructor
    public Student(Name name,
                   String studentNumber,
                   Date dateOfBirth,
                   boolean graduated) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
    }

    /**
     *
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     *
     * @return the studentNumber
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     *
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @return the boolean value stored in graduated
     */
    public boolean isGraduated() {
        return graduated;
    }

    /**
     *
     * @param name: the name that is to be set
     */
    public void setName(final Name name) {
        this.name = name;
    }

    /**
     *
     * @param studentNumber: the studentNumber that is to be set
     */
    public void setStudentNumber(final String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     *
     * @param dateOfBirth: the dateOfBirth that is to be set
     */
    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @param graduated: the graduated that is to be set
     */
    public void setGraduated(final boolean graduated) {
        this.graduated = graduated;
    }
}
