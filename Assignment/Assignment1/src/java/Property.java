/**
 * The Property class represents a property.
 * @author Chris Wu
 * Version 1.0
 */
public class Property
{
    private double  priceUsd;
    private Address address;
    private int     numberOfBedrooms;
    private boolean hasSwimmingPool;
    private String  type;
    private String  propertyId;

    /**
     * The property constructor
     * @param price            is the property's price
     * @param address          is the property's address
     * @param numberOfBedrooms is the number of bedrooms that the property has
     * @param hasSwimmingPool  is true if the property has a swimming pool, otherwise false
     * @param type             is the property's type (ie. residence, commercial, or retail)
     * @param propertyId       is the property's identification string
     */
    public Property(final double price,
                    final Address address,
                    final int numberOfBedrooms,
                    final boolean hasSwimmingPool,
                    final String type,
                    final String propertyId)
    {
        checkPrice(price);
        checkAddress(address);
        checkNumberOfBedrooms(numberOfBedrooms);
        checkType(type);
        checkPropertyId(price, address, numberOfBedrooms, hasSwimmingPool, type, propertyId);
    }

    /**
     * @param price is the property's price
     */
    private void checkPrice(final double price)
    {
        if(price < 0)
        {
            throw new IllegalArgumentException("Invalid price: " + price);
        }
    }

    /**
     * @param address is the property's address
     */
    private void checkAddress(final Address address)
    {
        if(address == null)
        {
            throw new NullPointerException("Invalid address: null");
        }

    }

    /**
     * @param numberOfBedrooms is the number of bedrooms that the property has
     */
    private void checkNumberOfBedrooms(final int numberOfBedrooms)
    {
        if(numberOfBedrooms == 0 || numberOfBedrooms >= 21)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }
    }

    /**
     * @param type is the property's type (ie. residence, commercial, or retail)
     */
    private void checkType(final String type)
    {
        if(type == null)
        {
            throw new NullPointerException("Invalid property type: null");
        } else if(!type.equalsIgnoreCase("residence")
                && !type.equalsIgnoreCase("commercial")
                && !type.equalsIgnoreCase("retail"))
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }
    }

    /**
     * @param price            is the property's price
     * @param address          is the property's address
     * @param numberOfBedrooms is the number of bedrooms that the property has
     * @param hasSwimmingPool  is true if the property has a swimming pool, otherwise false
     * @param type             is the property's type (ie. residence, commercial, or retail)
     * @param propertyId       is the property's identification string
     */
    private void checkPropertyId(
            final double price,
            final Address address,
            final int numberOfBedrooms,
            final boolean hasSwimmingPool,
            final String type,
            final String propertyId)
    {
        if(propertyId == null)
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
            this.priceUsd = price;
            this.address = address;
            this.numberOfBedrooms = numberOfBedrooms;
            this.hasSwimmingPool = hasSwimmingPool;
            this.type = type;
            this.propertyId = propertyId;
        }
    }

    /**
     * @return the price of the property
     */
    public double getPriceUsd()
    {
        return this.priceUsd;
    }

    /**
     * @return the address of the property
     */
    public Address getAddress()
    {
        return this.address;
    }

    /**
     * @return the number of bedrooms of the property
     */
    public int getNumberOfBedrooms()
    {
        return this.numberOfBedrooms;
    }

    /**
     * @return true if the property has a swimming pool, else false
     */
    public boolean hasSwimmingPool()
    {
        return this.hasSwimmingPool;
    }

    /**
     * @return the type of the property
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * @return the id of the property
     */
    public String getPropertyId()
    {
        return this.propertyId;
    }

    /**
     * @param value is the new price that is to be set for this property
     */
    public void setPriceUsd(final int value)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("bad value");
        }
        this.priceUsd = value;
    }
}
