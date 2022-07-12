package ca.bcit.comp2501.lab9;

/**
 * The KitchenTools class represents kitchen tools.
 * @author Chris Wu
 * @version 1.0
 */
public class KitchenTool
{
    protected final      String  color;
    protected final      int     yearProduced;
    protected final      int     massInGrams;
    protected final      boolean isElectricalDevice;
    private static final int     FIRST_GREGORIAN_YEAR = 1582;
    private static final int     CURRENT_YEAR         = 2022;
    private static final int     MIN_MASS             = 0;


    /**
     * The KitchenTools constructor
     * @param color is the kitchen tool's color
     * @param yearProduced is the kitchen tool's production year
     * @param massInGrams is the kitchen tool's mas sin grams
     * @param isElectricalDevice is whether the kitchen tool runs of electricity
     */
    public KitchenTool(final String color,
                       final int yearProduced,
                       final int massInGrams,
                       final boolean isElectricalDevice)
    {
        checkParameters(color, yearProduced, massInGrams);
        this.color = color;
        this.yearProduced = yearProduced;
        this.massInGrams = massInGrams;
        this.isElectricalDevice = isElectricalDevice;
    }

    private void checkParameters(final String color,
                                 final int yearProduced,
                                 final int massInGrams)
    {
        checkColor(color);
        checkYear(yearProduced);
        checkMass(massInGrams);
    }

    /**
     * @param massInGrams is the passed kitchen tool's mass in grams
     */
    private void checkMass(final int massInGrams)
    {
        if(massInGrams < MIN_MASS)
        {
            throw new IllegalArgumentException("Invalid mass");
        }
    }

    /**
     * @param yearProduced is the passed kitchen tool's production year
     */
    private void checkYear(final int yearProduced)
    {
        if(yearProduced < FIRST_GREGORIAN_YEAR || yearProduced > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid production year");
        }
    }

    /**
     * @param color is the passed kitchen tool's color
     */
    private void checkColor(final String color)
    {
        if(!color.equalsIgnoreCase("white") &&
                !color.equalsIgnoreCase("silver") &&
                !color.equalsIgnoreCase("red") &&
                !color.equalsIgnoreCase("orange") &&
                !color.equalsIgnoreCase("yellow") &&
                !color.equalsIgnoreCase("green") &&
                !color.equalsIgnoreCase("blue") &&
                !color.equalsIgnoreCase("purple") &&
                !color.equalsIgnoreCase("brown") &&
                !color.equalsIgnoreCase("black") &&
                !color.equalsIgnoreCase("cyan") &&
                !color.equalsIgnoreCase("magenta") &&
                !color.equalsIgnoreCase("grey") &&
                !color.equalsIgnoreCase("gray") &&
                !color.equalsIgnoreCase("pink") &&
                !color.equalsIgnoreCase("maroon") &&
                !color.equalsIgnoreCase("beige") &&
                !color.equalsIgnoreCase("tan") &&
                !color.equalsIgnoreCase("peach") &&
                !color.equalsIgnoreCase("lime") &&
                !color.equalsIgnoreCase("olive") &&
                !color.equalsIgnoreCase("turquoise") &&
                !color.equalsIgnoreCase("teal") &&
                !color.equalsIgnoreCase("indigo") &&
                !color.equalsIgnoreCase("violet"))
        {
            throw new IllegalArgumentException("Invalid color");
        }
    }

    /**
     * @return the color of this kitchen tool
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @return the material type of this kitchen tool
     */
    public int getYearProduced()
    {
        return yearProduced;
    }

    /**
     * @return the mass of this kitchen tool in grams
     */
    public int getMassInGrams()
    {
        return massInGrams;
    }

    /**
     * @return true is this kitchen tool runs on electricity, else false
     */
    public boolean isElectricalDevice()
    {
        return isElectricalDevice;
    }
}
