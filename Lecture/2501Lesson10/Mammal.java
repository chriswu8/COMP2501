public class Mammal
{
    private int yearBorn;
    public static final int CURRENT_YEAR = 2022;

    public Mammal(final int yearBorn)
    {
        this.yearBorn = yearBorn;
    }

    public Mammal()
    {
        this.yearBorn = CURRENT_YEAR;
    }

    public void move()
    {
        System.out.println("moving");
    }

    public void speak()
    {
        System.out.println("speaking");
    }
}
