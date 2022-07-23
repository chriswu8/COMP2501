public class Car extends Vehicle
{
    private final boolean manualTransmission;

    Car(final double weightKg,
        final int modelYear,
        final boolean manualTransmission)
    {
        super(weightKg, modelYear);
        this.manualTransmission = manualTransmission;

        System.out.println("i was made in year " + this.getYearMade());
    }
}
