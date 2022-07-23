public class Sailboat extends Vehicle{
    private final int numberOfSails;
    public Sailboat(final double kg,
                    final int yearMade,
                    final int numberOfSails){
        super(kg, yearMade);
        this.numberOfSails = numberOfSails;
    }

    @Override
    public String toString()
    {
        return super.toString() + " and i am a Sailboat{" +
                "numberOfSails=" + numberOfSails +
                '}';
    }
}
