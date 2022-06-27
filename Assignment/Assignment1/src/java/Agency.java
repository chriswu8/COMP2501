/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 1.0
 */

import java.util.*;

public class Agency
{
    private final String                agency;
    private final Map<String, Property> properties;


    public Agency(String agency)
    {
        this.agency = agency;

        properties = new HashMap<>();

    }


    public void addProperty(Property p1)
    {
        properties.put(p1.getPropertyId(), p1);
    }

    public Property getProperty(String x)
    {
        return properties.get(x);
    }

    public void removeProperty(String x)
    {
        properties.remove(x);
    }


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

    private Property[] populateMatchesArray(final Property[] arr, final Property[] matches, final int size)
    {
        for(int i = 0; i < size; i++)
        {
            matches[i] = arr[i];
        }

        return matches;
    }

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


//    public Collection<Object> getPropertiesOn(String elm_street)
//    {
//        return ;
//    }
}
