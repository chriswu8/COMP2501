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
    private static final int MIN_HANDLE_LENGTH = 0;

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
        checkHeadShape(headShape);
        checkHandleLengthInCm(handleLengthInCm);
        this.headShape = headShape;
        this.handleLengthInCm = handleLengthInCm;
    }

    /**
     * @param handleLength is the spoon's handle length
     */
    private void checkHandleLengthInCm(final int handleLength)
    {
        if(handleLength < MIN_HANDLE_LENGTH)
        {
            throw new IllegalArgumentException("Invalid handle length");
        }
    }

    /**
     * @param headShape is the spoon's head shape
     */
    private void checkHeadShape(final String headShape)
    {
        if(!headShape.equalsIgnoreCase("circular") &&
               !headShape.equalsIgnoreCase("oval"))
        {
            throw new IllegalArgumentException("Invalid spoon shape");
        }
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
