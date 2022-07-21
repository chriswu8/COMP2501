package ca.bcit.comp2501.lab9;

/**
 * The Chopstick class represents a pair of chopsticks.
 * @author Chris Wu & Ee Von Ng
 * @version 1.0
 */
public class Chopstick extends KitchenTool
{
    private final        int    lengthInCm;
    private final        String style;
    private static final int    MIN_LENGTH = 0;


    /**
     * The Chopstick constructor
     * @param color              is the color of the chopstick
     * @param yearProduced       is the year when this chopstick is made
     * @param massInGrams        is the mass of the chopstick in grams
     * @param isElectricalDevice is whether the chopstick runs on electricity
     * @param lengthInCm         is the length of the chopstick in centimeters
     * @param style              is the style of chopstick
     */
    public Chopstick(final String color,
                     final int yearProduced,
                     final int massInGrams,
                     final boolean isElectricalDevice,
                     final int lengthInCm, final String style)
    {
        super(color, yearProduced, massInGrams, isElectricalDevice);
        checkLength(lengthInCm);
        checkStyle(style);
        this.lengthInCm = lengthInCm;
        this.style = style;
    }

    /**
     * @param style is the passed chopstick style
     */
    private void checkStyle(final String style)
    {
        if(!style.equalsIgnoreCase("Chinese") &&
                !style.equalsIgnoreCase("Korean") &&
                !style.equalsIgnoreCase("Japanese"))
        {
            throw new IllegalArgumentException("Invalid style");
        }
    }

    /**
     * @param lengthInCm is the passed length of the chopstick
     */
    private void checkLength(final int lengthInCm)
    {
        if(lengthInCm < MIN_LENGTH)
        {
            throw new IllegalArgumentException("Invalid length");
        }
    }

    /**
     * @return the length of this chopstick
     */
    public int getLength()
    {
        return lengthInCm;
    }

    /**
     * @return the style of this chopstick (ie. Chinese, Japanese, Korean)
     */
    public String getStyle()
    {
        return style;
    }

    @Override
    public String toString()
    {
        return "======================\nChopstick"
                + "\nColor: " + getColor()
                + "\nProduction year: " + getYearProduced()
                + "\nMass (grams): " + getMassInGrams()
                + "\nElectrical device: " + isElectricalDevice()
                + "\nLength: " + getLength()
                + "\nStyle: " + getStyle();
    }
}
