import java.io.IOException;

class Student
{
    private String  lastName;
    private String  studentNumber;
    private int     yearBorn;
    private double  tuitionDueCad;
    private boolean graduated;

    Student(final String lastName, final String studentNumber, final int yearBorn, final double tuitionDueCad,
            final boolean graduated)
    {
        if(lastName == null || lastName.isBlank())
        {
            throw new IllegalArgumentException("bad last name");
        }

        if(studentNumber == null || studentNumber.length() != 9)
        {
            throw new IllegalArgumentException("bad student number: " + studentNumber);
        }

        if(yearBorn < 1900 ||  yearBorn > 2022)
        {
            throw new IllegalArgumentException("bad year of birth: " + yearBorn);
        }

        if(tuitionDueCad < 0.0)
        {
            throw new IllegalArgumentException("invalid amount of tuition owing: (CAD)$" + tuitionDueCad);
        }

        this.lastName      = lastName;
        this.studentNumber = studentNumber;
        this.yearBorn      = yearBorn;
        this.tuitionDueCad = tuitionDueCad;
        this.graduated     = graduated;
    }

    void setTuitionDueCad(final double tuitionDueCad)
    {
        if(tuitionDueCad < 0.0)
        {
            throw new IllegalArgumentException("invalid amount of tuition owing: (CAD)$" + tuitionDueCad);
        }

        this.tuitionDueCad = tuitionDueCad;
    }

    void setGraduated(final boolean graduated)
    {
        this.graduated = graduated;
    }
}
