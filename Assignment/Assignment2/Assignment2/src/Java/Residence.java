/**
 * The Residence class represents a residential property.
 * @author Chris Wu
 * Version 1.0
 */
public class Residence extends Property
{
    private final        int     numberOfBedrooms;
    private final        boolean swimmingPool;
    private final        boolean strata;
    private static final int     MIN_NUM_BEDROOM = 1;

    /**
     * The Residence constructor
     * @param priceUsd         is the residence's price in USD
     * @param address          is the residence's address
     * @param type             is the residence's type (ie. residence, commercial, or retail)
     * @param propertyId       is the residence's identification string
     * @param numberOfBedrooms is the residence's number of bedrooms
     * @param swimmingPool     is whether the residence has a pool
     * @param strata           is whether the residence is a strata property
     */
    public Residence(final double priceUsd,
                     final Address address,
                     final String type,
                     final String propertyId,
                     final int numberOfBedrooms,
                     final boolean swimmingPool,
                     final boolean strata)
    {
        super(priceUsd, address, type, propertyId);
        checkNumberOfBedrooms(numberOfBedrooms);
        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool;
        this.strata = strata;
    }

    /**
     * The second Residence constructor
     * @param price            is the residence's price
     * @param address          is the residence's address
     * @param numberOfBedrooms is the residence's number of bedrooms
     * @param swimmingPool     is whether the residence has a pool
     * @param type             is the residence's type (ie. residence, commercial, or retail)
     * @param propertyId       is the residence's identification string
     * @param strata           is whether the residence is a strata property
     */
    public Residence(final double price,
                     final Address address,
                     final int numberOfBedrooms,
                     final boolean swimmingPool,
                     final String type,
                     final String propertyId,
                     final boolean strata)
    {
        super(price, address, type, propertyId);
        checkNumberOfBedrooms(numberOfBedrooms);
        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool;
        this.strata = strata;
    }


    /**
     * @param numberOfBedrooms is the number of bedrooms
     */
    public void checkNumberOfBedrooms(final int numberOfBedrooms)
    {
        if(numberOfBedrooms < MIN_NUM_BEDROOM)
        {
            throw new IllegalArgumentException("Invalid number of bedroom: must be greater or equal to 1.");
        }
    }

    /**
     * @return the number of bedrooms
     */
    public int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    /**
     * @return true if there is the presence of a pool, else false
     */
    public boolean getSwimmingPool()
    {
        return swimmingPool;
    }

    /**
     * @return true if the property is a strata property, else false
     */
    public boolean getStrata()
    {
        return strata;
    }

    /**
     * @return the state of this residential property
     */
    @Override
    public String toString()
    {
        return "\nResidence [numberOfBedrooms=" + numberOfBedrooms
                + ", swimmingPool=" + swimmingPool
                + ", strata=" + strata
                + ", " + super.toString();
    }
}
