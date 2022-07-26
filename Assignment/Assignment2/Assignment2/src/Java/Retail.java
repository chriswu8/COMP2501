/**
 * The Retail class represents a retail property.
 * @author Chris Wu
 * Version 1.0
 */
public class Retail extends Property
{
    private final int     squareFootage;
    private final boolean customerParking;

    /**
     * The property constructor
     * @param price           is the property's price
     * @param address         is the property's address
     * @param type            is the property's type (ie. residence, commercial, or retail)
     * @param propertyId      is the property's identification string
     * @param squareFootage   is the property's size in square foot
     * @param customerParking is whether the property has customer parking space
     */
    public Retail(final double price,
                  final Address address,
                  final String type,
                  final String propertyId,
                  final int squareFootage,
                  final boolean customerParking)
    {
        super(price, address, type, propertyId);
        this.squareFootage = squareFootage;
        this.customerParking = customerParking;
    }

    /**
     * @return the amount of floor space available in square foot
     */
    public int getSquareFootage()
    {
        return squareFootage;
    }

    /**
     * @return true if customer parking is available, else false
     */
    public boolean hasCustomerParking()
    {
        return customerParking;
    }

    /**
     * @return the state of this retail property
     */
    @Override
    public String toString()
    {
        return "\nRetail [squareFootage=" + squareFootage
                + ", customer parking=" + customerParking
                + ", " + super.toString();
    }
}
