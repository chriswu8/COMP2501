public class Vehicle
{
    private final double weightKg;
    private final int yearMade;

    Vehicle(final double weightKg, final int yearMade)
    {
        this.weightKg = weightKg;
        this.yearMade = yearMade;
    }

    public double getWeightKg()
    {
        return weightKg;
    }

    public int getYearMade()
    {
        return yearMade;
    }

    @Override
    public String toString()
    {
        return "I am a Vehicle{" +
                "weightKg=" + weightKg +
                ", yearMade=" + yearMade +
                '}';
    }
}
