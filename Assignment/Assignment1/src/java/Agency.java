/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 1.0
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

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

    public Property[] getPropertiesBetween(int lowerBoundPrice, int upperBoundPrice)
    {
        int twelve, index;
        twelve = 12;
        index = 0;

        Property[] matches;
        matches = new Property[twelve];

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
        return matches;
    }
}
