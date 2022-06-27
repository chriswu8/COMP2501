import java.sql.Array;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 1.0
 */
public class Agency
{
    private final String                agency;
    private final Map<String, Property> properties;

    /**
     * The constructor
     * @param agency is the angency's name
     */
    public Agency(String agency)
    {
        this.agency = agency;

        properties = new HashMap<>();

    }

    /**
     * @param property is a property object
     */
    public void addProperty(Property property)
    {
        properties.put(property.getPropertyId(), property);
    }

    /**
     * @param key is a key
     * @return the property of the corresponding key
     */
    public Property getProperty(String key)
    {
        return properties.get(key);
    }

    /**
     * @param key is a key
     */
    public void removeProperty(String key)
    {
        properties.remove(key);
    }

    /**
     * @return the total value (in USD) accounting for all properties of this agency, as an integer
     */
    public int getTotalPropertyValues()
    {
        Set<String> keys;
        keys = properties.keySet();

        double totalPropertyValue;
        totalPropertyValue = 0;

        for(String key : keys)
        {
            totalPropertyValue += properties.get(key).getPriceUsd();
        }

        return (int) totalPropertyValue;
    }

    /**
     * @return a list of properties that has a swimming pool
     */
    public List<Property> getPropertiesWithPools()
    {
        List<Property> propertiesWithPools;
        propertiesWithPools = new ArrayList<>();

        Set<String> keys;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key).hasSwimmingPool())
            {
                propertiesWithPools.add(properties.get(key));
            }
        }
        return propertiesWithPools;
    }

    /**
     * @param lowerBoundPrice is the lower bound price point of the property
     * @param upperBoundPrice is the upper bound price point of the property
     * @return an array of properties that has a cost that is between the lower and upper price bounds
     */
    public Property[] getPropertiesBetween(final int lowerBoundPrice, final int upperBoundPrice)
    {
        int size;
        size = properties.size();

        Property[] arr, matches;
        arr = new Property[size];

        populateArray(lowerBoundPrice, upperBoundPrice, arr);

        size = determineSize(arr);
        matches = new Property[size];

        populateMatchesArray(arr, matches, size);

        return matches;
    }

    /**
     * @param arr     is the array with properties and null values
     * @param matches is the array with properties but without null values
     * @param size    is the number of non-null elements in the arr array
     * @return the matches array containing all of arr array's properties but without null values
     */
    private Property[] populateMatchesArray(final Property[] arr, final Property[] matches, final int size)
    {
        for(int i = 0; i < size; i++)
        {
            matches[i] = arr[i];
        }

        return matches;
    }

    /**
     * @param arr is the array with properties and null values
     * @return size: the number of non-null elements in array arr
     */
    private int determineSize(final Property[] arr)
    {
        int size;
        size = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != null)
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
    private void populateArray(final int lowerBoundPrice, final int upperBoundPrice, final Property[] matches)
    {
        int         index = 0;
        Set<String> keys;
        keys = properties.keySet();

        for(String key : keys)
        {
            if(properties.get(key).getPriceUsd() >= lowerBoundPrice
                    && properties.get(key).getPriceUsd() <= upperBoundPrice)
            {
                matches[index] = properties.get(key);
                index++;
            }
        }
    }

    public List<Address> getPropertiesOn(final String streetName)
    {
        List<Address> propertiesOn;
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
        } else
        {
            return null;
        }
    }
}
