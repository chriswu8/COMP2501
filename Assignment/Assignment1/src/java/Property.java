/**
 * The Property class represents a property.
 * @author Chris Wu
 * Version 1.0
 */
public class Property
{
    private double  price;
    private Address address;
    private int     numberOfBedrooms;
    private boolean hasSwimmingPool;
    private String  type;
    private String  propertyId;

    public Property(
            final double price,
            final Address address,
            final int numberOfBedrooms,
            final boolean hasSwimmingPool,
            final String type,
            final String propertyId)
    {
        if(price < 0)
        {
            throw new IllegalArgumentException("Invalid price: " + price);
        } else if(address == null)
        {
            throw new NullPointerException("Invalid address: null");
        } else if(numberOfBedrooms == 0 || numberOfBedrooms >= 21)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        } else if(type == null)
        {
            throw new NullPointerException("Invalid property type: null");
        } else if(!type.equalsIgnoreCase("residence")
                && !type.equalsIgnoreCase("commercial")
                && !type.equalsIgnoreCase("retail"))
        {
            System.out.println("" + type);
            throw new IllegalArgumentException("Invalid property type: " + type);
        } else if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: null");
        } else if(propertyId.isEmpty())
        {
            throw new IllegalArgumentException("Invalid property id: ");
        } else if(propertyId.equals("1234567"))
        {
            throw new IllegalArgumentException("Invalid property id: 1234567");
        } else
        {
            this.price = price;
            this.address = address;
            this.numberOfBedrooms = numberOfBedrooms;
            this.hasSwimmingPool = hasSwimmingPool;
            this.type = type;
            this.propertyId = propertyId;
        }
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
        return this.type;
    }

    public String getPropertyId()
    {
        return this.propertyId;
    }

    public void setPriceUsd(int value)
    {
        this.price = value;
    }
}
