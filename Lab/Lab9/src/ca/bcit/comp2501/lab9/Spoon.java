package ca.bcit.comp2501.lab9;

/**
 * The Spoon class represents a spoon.
 * @author Chris Wu
 * @version 1.0
 */
public class Spoon extends KitchenTool
{
    private final String headShape;
    private final int    handleLengthInCm;

    /**
     * The Spoon constructor.
     * @param color              is the color of the spoon
     * @param yearProduced       is the year when this spoon is made
     * @param massInGrams        is the mass of the spoon in grams
     * @param isElectricalDevice is whether the spoon runs on electricity
     * @param headShape          is spoon's head shape
     * @param handleLengthInCm   is the length of the spoon's handle
     */
    public Spoon(final String color,
                 final int yearProduced,
                 final int massInGrams,
                 final boolean isElectricalDevice,
                 final String headShape,
                 final int handleLengthInCm)
    {
        super(color, yearProduced, massInGrams, isElectricalDevice);
        this.headShape = headShape;
        this.handleLengthInCm = handleLengthInCm;
    }

    /**
     * @return the head shape of this spoon
     */
    public String getHeadShape()
    {
        return headShape;
    }

    /**
     * @return the handle length of this spoon in centimeters
     */
    public int getHandleLengthInCm()
    {
        return handleLengthInCm;
    }

    @Override
    public String toString()
    {
        return "======================\nSpoon"
                + "\nColor: " + getColor()
                + "\nProduction year: " + getYearProduced()
                + "\nMass (grams): " + getMassInGrams()
                + "\nElectrical device: " + isElectricalDevice()
                + "\nHead shape: " + getHeadShape()
                + "\nHandle length (cm): " + getHandleLengthInCm();
    }
}
