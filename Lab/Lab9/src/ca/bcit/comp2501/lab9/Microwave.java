package ca.bcit.comp2501.lab9;

/**
 * The Microwave class represents a microwave.
 * @author Chris Wu & Jack Luo
 * @version 1.0
 */
public class Microwave extends KitchenTool
{

    private final String typeOfTimeSetter;
    private final boolean makeSoundAfterHeating;

    /**
     * The Microwave constructor.
     * @param color is the color of this microwave
     * @param yearProduced is the year when this microwave is made
     * @param massInGrams is the mass of this microwave in grams
     * @param isElectricalDevice is whether this microwave runs on electricity
     * @param typeOfTimeSetter is the type of time setter that this microwave has
     * @param makeSoundAfterHeating is whether this microwave sounds after heating
     */
    public Microwave(final String color,
                     final int yearProduced,
                     final int massInGrams,
                     final boolean isElectricalDevice,
                     final String typeOfTimeSetter,
                     final boolean makeSoundAfterHeating)
    {
        super(color, yearProduced, massInGrams, isElectricalDevice);
        checkTypeOfTimeSetter(typeOfTimeSetter);
        this.typeOfTimeSetter = typeOfTimeSetter;
        this.makeSoundAfterHeating = makeSoundAfterHeating;
    }

    /**
     * @param typeOfTimeSetter is the passed type of time setter
     */
    private void checkTypeOfTimeSetter(final String typeOfTimeSetter)
    {
        if(!typeOfTimeSetter.equalsIgnoreCase("knob") &&
                !typeOfTimeSetter.equalsIgnoreCase("button") &&
                !typeOfTimeSetter.equalsIgnoreCase("buttons"))
        {
            throw new IllegalArgumentException("invalid type of time setter");
        }
    }

    /**
     * @return the type of time setter (knob / buttons)
     */
    public String getTypeOfTimeSetter()
    {
        return typeOfTimeSetter;
    }

    /**
     * @return true if this microwave makes beeping sounds after heating
     */
    public boolean getMakeSoundAfterHeating()
    {
        return makeSoundAfterHeating;
    }

    @Override
    public String toString()
    {
        return "======================\nMicrowave"
                + "\nColor: " + getColor()
                + "\nProduction year: " + getYearProduced()
                + "\nMass (grams): " + getMassInGrams()
                + "\nElectrical device: " + isElectricalDevice()
                + "\nType of time setter: " + getTypeOfTimeSetter()
                + "\nSounds after heating: " + getMakeSoundAfterHeating();
    }
}
