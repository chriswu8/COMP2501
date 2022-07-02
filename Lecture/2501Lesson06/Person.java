public class Person
{
    private String firstName;
    private String middleName;
    private String lastName;

    private static boolean airBreather = true;
    private static boolean warmBlooded = true;

    public static final int MAX_HEIGHT_IN = 107;
    private int heightIn;

    private boolean dead;
    private static boolean extinct;

    public static int population;

    private final int yearBorn;

    Person(final String firstName, final String middleName, final String lastName, final int yearborn)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.yearBorn = yearborn;
    }

    public String getFullName()
    {
        String fullName;
        fullName = firstName + " " + middleName + " " + lastName;
        return fullName;
    }

    String getFirstName()
    {
        return firstName;
    }

    String getMiddleName()
    {
        return middleName;
    }

    String getLastName()
    {
        return lastName;
    }
}
