/**
 * The Commercial class represents a commercial property.
 * @author Chris Wu
 * Version 1.0
 */
public class Commercial extends Property
{
    private final boolean loadingDock;
    private final boolean highwayAccess;

    /**
     * The Commercial constructor
     * @param price         is the commercial property's price
     * @param address       is the commercial property's address
     * @param type          is the commercial property's type (ie. residence, commercial, or retail)
     * @param propertyId    is the commercial property's identification string
     * @param loadingDock   is whether the commercial property's has a loading dock
     * @param highwayAccess is whether the commercial property's has highway access
     */
    public Commercial(final double price,
                      final Address address,
                      final String type,
                      final String propertyId,
                      final boolean loadingDock,
                      final boolean highwayAccess)
    {
        super(price, address, type, propertyId);
        this.loadingDock = loadingDock;
        this.highwayAccess = highwayAccess;
    }

    /**
     * @return true if the commercial property has a loading dock, else false
     */
    public boolean hasLoadingDock()
    {
        return loadingDock;
    }

    /**
     * @return true if the commercial property has highway access, else false
     */
    public boolean hasHighwayAccess()
    {
        return loadingDock;
    }

    /**
     * @return the state of this commercial property
     */
    @Override
    public String toString()
    {
        return "\nCommercial [loadingDock=" + hasLoadingDock()
                + ", highwayAccess=" + hasHighwayAccess()
                + ", " + super.toString();
    }
}
