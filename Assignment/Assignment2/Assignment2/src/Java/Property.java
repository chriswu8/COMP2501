/**
 * The Property class represents a property.
 * @author Chris Wu
 * Version 1.0
 */
public class Property
{
    private              double  priceUsd;
    private              Address address;
    private              String  type;
    private              String  propertyId;

    private static final int     MIN_ID_LENGTH = 1;
    private static final int     MAX_ID_LENGTH = 6;

    /**
     * The property constructor
     * @param priceUsd   is the property's price in USD
     * @param address    is the property's address
     * @param type       is the property's type (ie. residence, commercial, or retail)
     * @param propertyId is the property's identification string
     */
    public Property(final double priceUsd,
                    final Address address,
                    final String type,
                    final String propertyId)
    {
        checkPriceUsd(priceUsd);
        checkAddress(address);
        checkType(type);
        checkPropertyId(priceUsd, address, type, propertyId);
    }

    /**
     * @param price is the property's price
     */
    private void checkPriceUsd(final double price)
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
     * @param type is the property's type (ie. residence, commercial, or retail)
     */
    private void checkType(final String type)
    {
        if(type == null)
        {
            throw new NullPointerException("Invalid property type: null");
        }
        else if(!type.equalsIgnoreCase("residence") &&
                !type.equalsIgnoreCase("commercial") &&
                !type.equalsIgnoreCase("retail"))
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }
    }

    /**
     * @param priceUsd   is the property's price in USD
     * @param address    is the property's address
     * @param type       is the property's type (ie. residence, commercial, or retail)
     * @param propertyId is the property's identification string
     */
    private void checkPropertyId(final double priceUsd,
                                 final Address address,
                                 final String type,
                                 final String propertyId)
    {
        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: null");
        }
        else if(propertyId.isEmpty())
        {
            throw new IllegalArgumentException("Invalid property id: ");
        }
        else if(propertyId.length() < MIN_ID_LENGTH || propertyId.length() > MAX_ID_LENGTH)
        {
            throw new IllegalArgumentException("Invalid property id: must be 1-6 characters long.");
        }
        else
        {
            this.priceUsd = priceUsd;
            this.address = address;
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

    @Override
    public String toString()
    {
        return "toString()=Property [priceUsd=" + priceUsd + ", " + getAddress() + ", type=" + getType()
                + ", propertyId=" + getPropertyId() +"]]";
    }
}
