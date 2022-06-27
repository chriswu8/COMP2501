/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 1.0
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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

        return (int)totalPropertyValue;
    }
}
