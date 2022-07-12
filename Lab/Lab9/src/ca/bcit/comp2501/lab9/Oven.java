package ca.bcit.comp2501.lab9;

/**
 * The Oven class represents a standard cooking oven.
 * @author Chris Wu
 * @version 1.0
 */
public class Oven extends KitchenTool
{
    private final  boolean hasLightInsideChamber;
    private final  int     minTempInFahrenheit;
    private final  int     maxTempInFahrenheit;
    private static int     LOWEST_OVEN_TEMP  = 200;
    private static int     HIGHEST_OVEN_TEMP = 905;

    /**
     * The Oven constructor.
     * @param color                 is the color of this oven
     * @param yearProduced          is the year when this oven is made
     * @param massInGrams           is the mass of this oven in grams
     * @param isElectricalDevice    is whether this oven runs on electricity
     * @param hasLightInsideChamber is whether this oven has toggleable light within its chamber
     * @param minTempInFahrenheit   is this oven's minimum operating temperature
     * @param maxTempInFahrenheit   is this oven's maximum operating temperature
     */
    public Oven(final String color,
                final int yearProduced,
                final int massInGrams,
                final boolean isElectricalDevice,
                final boolean hasLightInsideChamber,
                final int minTempInFahrenheit,
                final int maxTempInFahrenheit)
    {
        super(color, yearProduced, massInGrams, isElectricalDevice);
        checkTempInFahrenheit(minTempInFahrenheit);
        checkTempInFahrenheit(maxTempInFahrenheit);
        this.hasLightInsideChamber = hasLightInsideChamber;
        this.minTempInFahrenheit = minTempInFahrenheit;
        this.maxTempInFahrenheit = maxTempInFahrenheit;
    }

    /**
     * @param temp is the passed min or max oven temperature
     */
    private void checkTempInFahrenheit(final int temp)
    {
        if(temp < LOWEST_OVEN_TEMP || temp > HIGHEST_OVEN_TEMP)
        {
            throw new IllegalArgumentException("Invalid temperature");
        }
    }

    /**
     * @return true if the over has toggleable light(s) within its chamber
     */
    public boolean getHasLightInsideChamber()
    {
        return hasLightInsideChamber;
    }

    /**
     * @return the minimum operating temperature of this oven in Fahrenheit
     */
    public int getMinTempInFahrenheit()
    {
        return minTempInFahrenheit;
    }

    /**
     * @return the maximum operating temperature of this oven in Fahrenheit
     */
    public int getMaxTempInFahrenheit()
    {
        return maxTempInFahrenheit;
    }

    @Override
    public String toString()
    {
        return "======================\nOven"
                + "\nColor: " + getColor()
                + "\nProduction year: " + getYearProduced()
                + "\nMass (grams): " + getMassInGrams()
                + "\nElectrical device: " + isElectricalDevice()
                + "\nLight in chamber: " + getHasLightInsideChamber()
                + "\nMin temperature: " + getMinTempInFahrenheit()
                + "\nMax temperature: " + getMaxTempInFahrenheit();
    }
}
