import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 2.0
 */
public class Agency
{
    private final String                name;
    private final Map<String, Property> properties;

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 30;

    /**
     * The constructor
     * @param agency is the agency's name
     */
    public Agency(final String agency)
    {
        name = checkName(agency);
        properties = new HashMap<>();
    }

    private String checkName(final String agency)
    {
        if(agency == null || agency.isBlank())
        {
            throw new IllegalArgumentException("Invalid agency: cannot be null or blank.");
        }
        else if(agency.length() < MIN_NAME_LENGTH || agency.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Agency name must be between 1-30 characters long.");
        }
        else
        {
            return agency;
        }
    }

    /**
     * @param property is a property (commercial, residence, or retail)
     */
    public void addProperty(final Property property)
    {
        if(property != null)
        {
            properties.put(property.getPropertyId(), property);
        }
        else
        {
            throw new IllegalArgumentException("Invalid Property: cannot be null");
        }
    }

    /**
     * @param key is a key
     * @return the property of the corresponding key
     */
    public Property getProperty(final String key)
    {
        return properties.get(key);
    }

    /**
     * @param key is a key (property ID)
     */
    public void removeProperty(final String key)
    {
        properties.remove(key);
    }

    /**
     * @return the total value (in USD) accounting for all properties of this agency, as an int
     */
    public int getTotalPropertyValues()
    {
        Set<String> keys;
        Double      totalPropertyValue;

        keys = properties.keySet();
        totalPropertyValue = 0.0;

        for(String key : keys)
        {
            totalPropertyValue += properties.get(key).getPriceUsd();
        }

        return totalPropertyValue.intValue();
    }

    /**
     * @return an ArrayList<Residence> where all the residences have pools
     */
    public ArrayList<Residence> getPropertiesWithPools()
    {
        ArrayList<Residence> residencesWithPools;
        residencesWithPools = new ArrayList<>();

        Set<String> keys;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key) instanceof Residence)
            {
                Residence aResidence;
                aResidence = (Residence) properties.get(key);

                if(aResidence.getSwimmingPool())
                {
                    residencesWithPools.add(aResidence);
                }
            }
        }
        return residencesWithPools;
    }

    /**
     * @param minUsd is the lower bound price point of the property
     * @param maxUsd is the upper bound price point of the property
     * @return an array of properties whose price falls in the range specified by the parameter, or null if none
     */
    public Property[] getPropertiesBetween(final int minUsd,
                                           final int maxUsd)
    {
        int size;
        size = properties.size();

        Property[] arr, matches;
        arr = new Property[size];

        populateArray(minUsd, maxUsd, arr);

        size = determineSize(arr);
        matches = new Property[size];

        populateMatchesArray(arr, matches, size);

        return matches;
    }

    /**
     * @param arr     is the array with properties and null values
     * @param matches is the array with properties but without null values
     * @param size    is the number of non-null elements in the arr array
     */
    private void populateMatchesArray(final Property[] arr,
                                      final Property[] matches,
                                      final int size)
    {
        for(int i = 0; i < size; i++)
        {
            matches[i] = arr[i];
        }
    }

    /**
     * @param arr is the array with properties and null values
     * @return size: the number of non-null elements in array arr
     */
    private int determineSize(final Property[] arr)
    {
        int size;
        size = 0;

        for(Property property : arr)
        {
            if(property != null)
            {
                size++;
            }
        }
        return size;
    }

    /**
     * @param lowerBoundPrice is the lower bound price point of the property
     * @param upperBoundPrice is the upper bound price point of the property
     * @param matches         is the array with properties but without null values
     */
    private void populateArray(final int lowerBoundPrice,
                               final int upperBoundPrice,
                               final Property[] matches)
    {
        int         index;
        Set<String> keys;

        index = 0;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key).getPriceUsd() >= lowerBoundPrice && properties.get(key).getPriceUsd() <= upperBoundPrice)
            {
                matches[index] = properties.get(key);
                index++;
            }
        }
    }

    /**
     * @param streetName is the street name
     * @return an ArrayList<Address> that are on the specified street name, null if no matching street name found
     */
    public ArrayList<Address> getPropertiesOn(final String streetName)
    {
        ArrayList<Address> propertiesOn;
        propertiesOn = new ArrayList<>();

        Set<String> keys;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key).getAddress().getStreetName().equals(streetName))
            {
                propertiesOn.add(properties.get(key).getAddress());
            }
        }

        if(propertiesOn.size() > 0)
        {
            return propertiesOn;
        }
        else
        {
            return null;
        }
    }

    /**
     * @param minBedrooms is the minimum required number of bedrooms
     * @param maxBedrooms is the maximum required number of bedrooms
     * @return hashmap of residences that meets the requirement for min and max number of bedrooms, null if no match
     */
    public HashMap<String, Residence> getPropertiesWithBedrooms(final int minBedrooms,
                                                                final int maxBedrooms)
    {
        HashMap<String, Residence> propertiesWithBedrooms;
        Residence                  aResidence;
        Set<String>                keys;

        propertiesWithBedrooms = new HashMap<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key) instanceof Residence)
            {
                aResidence = (Residence) properties.get(key);

                if(aResidence.getNumberOfBedrooms() >= minBedrooms && aResidence.getNumberOfBedrooms() <= maxBedrooms)
                {
                    propertiesWithBedrooms.put(aResidence.getPropertyId(), aResidence);
                }
            }
        }

        if(propertiesWithBedrooms.size() > 0)
        {
            return propertiesWithBedrooms;
        }
        else
        {
            return null;
        }
    }

    /**
     * @param propertyType is a subtype of property (commercial, residence, or retail)
     * @return an ArrayList<Property> that holds the subtype specified in the parameter
     */
    public ArrayList<Property> getPropertiesOfType(final String propertyType)
    {
        ArrayList<Property> propertyList;

        propertyList = new ArrayList<>();

        if(propertyType.equalsIgnoreCase("Residence") || propertyType.equalsIgnoreCase("Retail") || propertyType.equalsIgnoreCase("Commercial"))
        {
            return propertyList;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Property");
        }
    }

    /**
     * @return an ArrayList<Commercial> that holds only Commercial properties that have a loading dock available
     */
    public ArrayList<Commercial> getPropertiesWithLoadingDock()
    {
        ArrayList<Commercial> commercialWithLoadingDock;
        Set<String>           keys;

        commercialWithLoadingDock = new ArrayList<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(key != null)
            {
                addToArrayListIfItHasLoadingDock(commercialWithLoadingDock, key);
            }
        }
        return commercialWithLoadingDock;
    }

    private void addToArrayListIfItHasLoadingDock(final ArrayList<Commercial> commercialWithLoadingDock,
                                                  final String key)
    {
        Commercial aCommercial;

        if(properties.get(key) instanceof Commercial)
        {
            aCommercial = (Commercial) properties.get(key);

            if(aCommercial.hasLoadingDock())
            {
                commercialWithLoadingDock.add(aCommercial);
            }
        }
    }

    /**
     * @return an ArrayList<Commercial> > that holds only Commercial properties that have highway access
     */
    public ArrayList<Commercial> getPropertiesWithHighwayAccess()
    {
        ArrayList<Commercial> commercialWithHighwayAccess;
        Set<String>           keys;

        commercialWithHighwayAccess = new ArrayList<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(key != null)
            {
                addToArrayListIfItHasHighwayAccess(commercialWithHighwayAccess, key);
            }
        }
        return commercialWithHighwayAccess;
    }

    private void addToArrayListIfItHasHighwayAccess(final ArrayList<Commercial> commercialWithHighwayAccess,
                                                    final String key)
    {
        Commercial aCommercial;

        if(properties.get(key) instanceof Commercial)
        {
            aCommercial = (Commercial) properties.get(key);

            if(aCommercial.hasHighwayAccess())
            {
                commercialWithHighwayAccess.add(aCommercial);
            }
        }
    }

    /**
     * @return an ArrayList<Retail> that holds properties where square footage is at least the parameter value.
     */
    public ArrayList<Retail> getPropertiesWithSquareFootage(final int squareFootage)
    {
        ArrayList<Retail> retailWithRequiredSquareFootage;
        Set<String>       keys;

        retailWithRequiredSquareFootage = new ArrayList<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(key != null)
            {
                addToArrayListIfItMeetsRequiredSquareFootage(retailWithRequiredSquareFootage, key, squareFootage);
            }
        }
        return retailWithRequiredSquareFootage;
    }

    private void addToArrayListIfItMeetsRequiredSquareFootage(ArrayList<Retail> retailWithRequiredSquareFootage,
                                                              final String key,
                                                              final int squareFootage)
    {
        Retail aRetail;

        if(properties.get(key) instanceof Retail)
        {
            aRetail = (Retail) properties.get(key);

            if(aRetail.getSquareFootage() > squareFootage)
            {
                retailWithRequiredSquareFootage.add(aRetail);
            }
        }
    }

    /**
     * @return an ArrayList<Retail> that holds properties where customer parking is available.
     */
    public ArrayList<Retail> getPropertiesWithCustomerParking()
    {
        ArrayList<Retail> retailWithCustomerParking;
        Set<String>       keys;

        retailWithCustomerParking = new ArrayList<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(key != null)
            {
                addToArrayListIfItHasCustomerParking(retailWithCustomerParking, key);
            }
        } return retailWithCustomerParking;
    }

    private void addToArrayListIfItHasCustomerParking(ArrayList<Retail> retailWithCustomerParking,
                                                      final String key)
    {
        Retail aRetail;

        if(properties.get(key) instanceof Retail)
        {
            aRetail = (Retail) properties.get(key);

            if(aRetail.hasCustomerParking())
            {
                retailWithCustomerParking.add(aRetail);
            }
        }
    }

    /**
     * @return an ArrayList<Residence> that hold only the Residences that are in a strata.
     */
    public ArrayList<Residence> getPropertiesWithStrata()
    {
        ArrayList<Residence> residencesInStrata;
        Set<String>          keys;

        residencesInStrata = new ArrayList<>();
        keys = properties.keySet();

        for(String key : keys)
        {
            if(key != null)
            {
                addToArrayListIfInStrata(residencesInStrata, key);
            }
        } return residencesInStrata;
    }

    private void addToArrayListIfInStrata(ArrayList<Residence> residencesInStrata,
                                          final String key)
    {
        Residence aResidence;

        if(properties.get(key) instanceof Residence)
        {
            aResidence = (Residence) properties.get(key);

            if(aResidence.getStrata())
            {
                residencesInStrata.add(aResidence);
            }
        }
    }
}
