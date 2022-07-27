import java.io.File;
import java.io.FileNotFoundException;
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
    private String[] tokens;

    private final String                name;
    private final Address[]             allAddresses;
    private final Map<String, Property> properties;

    private static final int    MIN_NAME_LENGTH              = 1;
    private static final int    MAX_NAME_LENGTH              = 30;
    private static final int    ARRAY_SIZE                   = 12;
    private static final String DELIMITER                    = "\\|";
    private static final int    ARRAY_SIZE2                  = 12;
    private static final int    PRICE_USD_INDEX              = 0;
    private static final int    BEDROOM_INDEX                = 1;
    private static final int    POOL_INDEX                   = 2;
    private static final int    RESIDENCE_TYPE_INDEX         = 3;
    private static final int    RESIDENCE_ID_INDEX           = 4;
    private static final int    STRATA_INDEX                 = 5;
    private static final int    RETAIL_COMMERCIAL_TYPE_INDEX = 1;
    private static final int    RETAIL_ID_INDEX              = 2;
    private static final int    SQUARE_FOOTAGE_INDEX         = 3;
    private static final int    CUSTOMER_PARKING_INDEX       = 4;
    private static final int    COMMERCIAL_ID_INDEX          = 2;
    private static final int    LOADING_DOCK_INDEX           = 3;
    private static final int    HIGHWAY_ACCESS_INDEX         = 4;


    /**
     * The constructor
     * @param agency is the agency's name
     */
    public Agency(final String agency)
    {
        name = checkName(agency);
        properties = new HashMap<>();
        tokens = new String[ARRAY_SIZE];
        allAddresses = new Address[ARRAY_SIZE2];
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
     * @param propertyId is a key to the property HashMap
     */
    public void removeProperty(final String propertyId)
    {
        properties.remove(propertyId);
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
    public Property[] getPropertiesBetween(final double minUsd,
                                           final double maxUsd)
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
        if(size >= 0)
        {
            System.arraycopy(arr, 0, matches, 0, size);
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
    private void populateArray(final double lowerBoundPrice,
                               final double upperBoundPrice,
                               final Property[] matches)
    {
        int         index;
        Set<String> keys;

        index = 0;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key).getPriceUsd() >= lowerBoundPrice &&
                    properties.get(key).getPriceUsd() <= upperBoundPrice)
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
            if(properties.get(key).getAddress().getStreetName().equalsIgnoreCase(streetName))
            {
                propertiesOn.add(properties.get(key).getAddress());
            }
        }
        return propertiesOn;
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
     * @throws FileNotFoundException if file is not found
     */
    public ArrayList<Property> getPropertiesOfType(final String propertyType) throws FileNotFoundException
    {
        File                addressData;
        File                propertyData;
        ArrayList<Address>  addresses;
        ArrayList<String>   properties;
        ArrayList<Property> returnList;
        Set<String>         keys;

        addressData = new File("address_data.txt");
        propertyData = new File("property_data.txt");

        returnList = new ArrayList<>();
        keys = this.properties.keySet();

        addresses = AddressReader.readAddressData(addressData);
        properties = PropertyReader.readPropertyData(propertyData);

        createSubtypes(addresses, properties);

        addAllResidences(propertyType, returnList, keys);

        addAllRetails(propertyType, returnList, keys);

        addAllCommercials(propertyType, returnList, keys);

        return returnList;
    }

    private void addAllCommercials(final String propertyType,
                                   final ArrayList<Property> returnList,
                                   final Set<String> keys)
    {
        if(propertyType.equalsIgnoreCase("commercial"))
        {
            for(String key : keys)
            {
                if(key != null && this.properties.get(key) instanceof Commercial)
                {
                    returnList.add(this.properties.get(key));
                }
            }
        }
    }

    private void addAllRetails(final String propertyType,
                               final ArrayList<Property> returnList,
                               final Set<String> keys)
    {
        if(propertyType.equalsIgnoreCase("retail"))
        {
            for(String key : keys)
            {
                if(key != null && this.properties.get(key) instanceof Retail)
                {
                    returnList.add(this.properties.get(key));
                }
            }
        }
    }

    private void addAllResidences(final String propertyType,
                                  final ArrayList<Property> returnList,
                                  final Set<String> keys)
    {
        if(propertyType.equalsIgnoreCase("residence"))
        {
            for(String key : keys)
            {
                if(key != null && this.properties.get(key) instanceof Residence)
                {
                    returnList.add(this.properties.get(key));
                }
            }
        }
    }

    private void createSubtypes(final ArrayList<Address> addresses,
                                final ArrayList<String> properties)
    {
        for(int i = 0; i < addresses.size(); i++)
        {
            allAddresses[i] = addresses.get(i);
        }

        for(int i = 0; i < properties.size(); i++)
        {
            if(properties.get(i) != null)
            {
                tokens = properties.get(i).split(DELIMITER);

                dealWithRetail(i);

                dealWithResidence(i);

                dealWithCommercial(i);
            }
        }
    }

    private void dealWithCommercial(final int i)
    {
        if(tokens[RETAIL_COMMERCIAL_TYPE_INDEX].equalsIgnoreCase("commercial"))
        {
            Commercial aCommercial;

            aCommercial = new Commercial(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                         tokens[RETAIL_COMMERCIAL_TYPE_INDEX], tokens[COMMERCIAL_ID_INDEX],
                                         Boolean.parseBoolean(tokens[LOADING_DOCK_INDEX]),
                                         Boolean.parseBoolean(tokens[HIGHWAY_ACCESS_INDEX]));

            this.addProperty(aCommercial);
        }
    }

    private void dealWithResidence(final int i)
    {
        if(tokens[RESIDENCE_TYPE_INDEX].equalsIgnoreCase("residence"))
        {
            Residence aResidence;

            aResidence = new Residence(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                       tokens[RESIDENCE_TYPE_INDEX], tokens[RESIDENCE_ID_INDEX],
                                       Integer.parseInt(tokens[BEDROOM_INDEX]),
                                       Boolean.parseBoolean(tokens[POOL_INDEX]),
                                       Boolean.parseBoolean(tokens[STRATA_INDEX]));

            this.addProperty(aResidence);
        }
    }

    private void dealWithRetail(final int i)
    {
        if(tokens[RETAIL_COMMERCIAL_TYPE_INDEX].equalsIgnoreCase("retail"))
        {
            Retail aRetail;

            aRetail = new Retail(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                 tokens[RETAIL_COMMERCIAL_TYPE_INDEX], tokens[RETAIL_ID_INDEX],
                                 Integer.parseInt(tokens[SQUARE_FOOTAGE_INDEX]),
                                 Boolean.parseBoolean(tokens[CUSTOMER_PARKING_INDEX]));

            this.addProperty(aRetail);
        }
    }

    /**
     * @return an ArrayList<Commercial> that holds only Commercial properties that have a loading dock available
     */
    public ArrayList<Commercial> getPropertiesWithLoadingDocks()
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
    public ArrayList<Retail> getPropertiesSquareFootage(final int squareFootage)
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

    private void addToArrayListIfItMeetsRequiredSquareFootage(final ArrayList<Retail> retailWithRequiredSquareFootage,
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
        }
        return retailWithCustomerParking;
    }

    private void addToArrayListIfItHasCustomerParking(final ArrayList<Retail> retailWithCustomerParking,
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
        }
        return residencesInStrata;
    }

    private void addToArrayListIfInStrata(final ArrayList<Residence> residencesInStrata,
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
