/**
 * The Property class represents a property.
 *
 * @author Chris Wu
 * Version 1.0
 */
public class Property
{
    private double  price;
    private Address address;
    private int     numberOfBedrooms;
    private boolean hasSwimmingPool;
    private String  residence;
    private String  type;

    public Property(
            final double price,
            final Address address,
            final int numberOfBedrooms,
            final boolean hasSwimmingPool,
            final String residence,
            final String type)
    {
        this.price = price;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.residence = residence;
        this.type = type;
    }

    public double getPriceUsd()
    {
        return this.price;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public int getNumberOfBedrooms()
    {
        return this.numberOfBedrooms;
    }

    public boolean hasSwimmingPool()
    {
        return this.hasSwimmingPool;
    }

    public String getType()
    {
        return this.residence;
    }

    public String getPropertyId()
    {
        return this.type;
    }

    public void setPriceUsd(int value)
    {
        this.price = value;
    }
}
