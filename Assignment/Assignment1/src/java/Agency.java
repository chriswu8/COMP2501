/**
 * The Agency class represents an agency.
 * @author Chris Wu
 * Version 1.0
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Agency
{
    private final String agency;
    private final Map<String, Property> agencies;
//    private final Set<String> keys;

    
    public Agency(String agency)
    {
        this.agency = agency;

        agencies = new HashMap<>();

//        keys = agencies.keySet();
    }


    public void addProperty(Property p1)
    {
        agencies.put(p1.getPropertyId(), p1);
    }

    public Property getProperty(String x)
    {
       return agencies.get(x);
    }
}
