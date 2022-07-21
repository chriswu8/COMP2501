package ca.bcit.comp2501.lab9;

/**
 * The Mixer class represents a hand-held electrical mixer.
 * @author Chris Wu & Ee Von Ng
 * @version 1.0
 */
public class Mixer extends KitchenTool
{
    private final        int numOfSpeedModes;
    private final        int powerInWatts;
    private static final int MIN_NUM_MODE = 0;
    private static final int MIN_WATT     = 0;

    /**
     * The Mixer constructor
     * @param color              is the color of this mixer
     * @param yearProduced       is the outer material of this mixer is made
     * @param massInGrams        is the mass of this mixer in grams
     * @param isElectricalDevice is whether this mixer runs on electricity
     * @param numOfSpeedModes    is number of speed modes that this mixer has
     * @param powerInWatts       the amount of power that this mixer generates
     */
    public Mixer(final String color,
                 final int yearProduced,
                 final int massInGrams,
                 final boolean isElectricalDevice,
                 final int numOfSpeedModes,
                 final int powerInWatts)
    {
        super(color, yearProduced, massInGrams, isElectricalDevice);
        checkNumOfSpeedModes(numOfSpeedModes);
        checkPowerInWatts(powerInWatts);
        this.numOfSpeedModes = numOfSpeedModes;
        this.powerInWatts = powerInWatts;
    }

    /**
     * @param powerInWatts is the passed power in watts
     */
    private void checkPowerInWatts(final int powerInWatts)
    {
        if(powerInWatts < MIN_WATT)
        {
            throw new IllegalArgumentException("Invalid power in watts");
        }
    }

    /**
     * @param numOfSpeedModes is the passed number of speed modes
     */
    private void checkNumOfSpeedModes(final int numOfSpeedModes)
    {
        if(numOfSpeedModes < MIN_NUM_MODE)
        {
            throw new IllegalArgumentException("Invalid number of speed modes");
        }
    }

    /**
     * @return the number of speed modes of this mixer
     */
    public int getNumOfSpeedModes()
    {
        return numOfSpeedModes;
    }

    /**
     * @return the amount of power that this mixer generates in watts
     */
    public int getPowerInWatts()
    {
        return powerInWatts;
    }

    @Override
    public String toString()
    {
        return "======================\nMixer"
                + "\nColor: " + getColor()
                + "\nProduction year: " + getYearProduced()
                + "\nMass (grams): " + getMassInGrams()
                + "\nElectrical device: " + isElectricalDevice()
                + "\nNumber of speed modes: " + getNumOfSpeedModes()
                + "\nPower (watts): " + getPowerInWatts();
    }
}
