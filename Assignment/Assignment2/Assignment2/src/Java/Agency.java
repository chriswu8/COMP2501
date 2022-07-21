//import java.util.Map;
//import java.util.HashMap;
//import java.util.Set;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.regex.Pattern;
//
///**
// * The Agency class represents an agency.
// * @author Chris Wu
// * Version 1.0
// */
//public class Agency
//{
//    private final String                agency;
//    private final Map<String, Property> properties;
//
//    /**
//     * The constructor
//     * @param agency is the agency's name
//     */
//    public Agency(String agency)
//    {
//        if(agency == null || agency.isBlank())
//        {
//            throw new IllegalArgumentException("Invalid agency");
//        } else
//        {
//            this.agency = agency;
//
//            properties = new HashMap<>();
//        }
//    }
//
//    /**
//     * @param property is a Residence
//     */
//    public void addProperty(Residence property)
//    {
//        agency.addProperty(new Residence(Double.parseDouble(rawData[0]), addresses.get(addressesIndex),
//                                         Integer.parseInt(rawData[1]), Boolean.parseBoolean(rawData[2]), rawData[3], rawData[4],
//                                         Boolean.parseBoolean(rawData[5])));
//
//        properties.put(property.getPropertyId(), property);
//    }
//
//    /**
//     * @param property is a property object
//     */
//    public void addProperty(Commercial property)
//    {
//        properties.put(property.getPropertyId(), property);
//    }
//
//    /**
//     * @param key is a key
//     * @return the property of the corresponding key
//     */
//    public Property getProperty(String key)
//    {
//        return properties.get(key);
//    }
//
//    /**
//     * @param key is a key
//     */
//    public void removeProperty(String key)
//    {
//        properties.remove(key);
//    }
//
//    /**
//     * @return the total value (in USD) accounting for all properties of this agency, as an integer
//     */
//    public int getTotalPropertyValues()
//    {
//        Set<String> keys;
//        Double totalPropertyValue;
//
//        keys = properties.keySet();
//        totalPropertyValue = 0.0;
//
//        for(String key : keys)
//        {
//            totalPropertyValue += properties.get(key).getPriceUsd();
//        }
//
//        return totalPropertyValue.intValue();
//    }
//
//    /**
//     * @return a list of properties that has a swimming pool
//     */
//    public List<Property> getPropertiesWithPools()
//    {
//        List<Property> propertiesWithPools;
//        propertiesWithPools = new ArrayList<>();
//
//        Set<String> keys;
//        keys = properties.keySet();
//
//        for(String key : keys)
//        {
//            if(properties.get(key).hasSwimmingPool())
//            {
//                propertiesWithPools.add(properties.get(key));
//            }
//        }
//        return propertiesWithPools;
//    }
//
//    /**
//     * @param lowerBoundPrice is the lower bound price point of the property
//     * @param upperBoundPrice is the upper bound price point of the property
//     * @return an array of properties that has a cost that is between the lower and upper price bounds
//     */
//    public Property[] getPropertiesBetween(final int lowerBoundPrice, final int upperBoundPrice)
//    {
//        int size;
//        size = properties.size();
//
//        Property[] arr, matches;
//        arr = new Property[size];
//
//        populateArray(lowerBoundPrice, upperBoundPrice, arr);
//
//        size = determineSize(arr);
//        matches = new Property[size];
//
//        populateMatchesArray(arr, matches, size);
//
//        return matches;
//    }
//
//    /**
//     * @param arr     is the array with properties and null values
//     * @param matches is the array with properties but without null values
//     * @param size    is the number of non-null elements in the arr array
//     */
//    private void populateMatchesArray(final Property[] arr, final Property[] matches, final int size)
//    {
//        for(int i = 0; i < size; i++)
//        {
//            matches[i] = arr[i];
//        }
//    }
//
//    /**
//     * @param arr is the array with properties and null values
//     * @return size: the number of non-null elements in array arr
//     */
//    private int determineSize(final Property[] arr)
//    {
//        int size;
//        size = 0;
//
//        for(Property property : arr)
//        {
//            if(property != null)
//            {
//                size++;
//            }
//        }
//        return size;
//    }
//
//    /**
//     * @param lowerBoundPrice is the lower bound price point of the property
//     * @param upperBoundPrice is the upper bound price point of the property
//     * @param matches         is the array with properties but without null values
//     */
//    private void populateArray(final int lowerBoundPrice, final int upperBoundPrice, final Property[] matches)
//    {
//        int         index;
//        Set<String> keys;
//
//        index = 0;
//        keys = properties.keySet();
//
//        for(String key : keys)
//        {
//            if(properties.get(key).getPriceUsd() >= lowerBoundPrice
//                    && properties.get(key).getPriceUsd() <= upperBoundPrice)
//            {
//                matches[index] = properties.get(key);
//                index++;
//            }
//        }
//    }
//
//    /**
//     * @param streetName is the street name
//     * @return list of address that is on the specified street name, null if no matching street name found
//     */
//    public List<Address> getPropertiesOn(final String streetName)
//    {
//        List<Address> propertiesOn;
//        propertiesOn = new ArrayList<>();
//
//        Set<String> keys;
//        keys = properties.keySet();
//
//        for(String key : keys)
//        {
//            if(properties.get(key).getAddress().getStreetName().equals(streetName))
//            {
//                propertiesOn.add(properties.get(key).getAddress());
//            }
//        }
//
//        if(propertiesOn.size() > 0)
//        {
//            return propertiesOn;
//        } else
//        {
//            return null;
//        }
//    }
//
//    /**
//     * @param minBedrooms is the minimum required number of bedrooms
//     * @param maxBedrooms is the maximum required number of bedrooms
//     * @return hashmap of properties that meets the requirement for min and max number of bedrooms, null if no match
//     */
//    public HashMap<String, Property> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms)
//    {
//        HashMap<String, Property> propertiesWithBedrooms;
//        propertiesWithBedrooms = new HashMap<>();
//
//        Set<String> keys;
//        keys = properties.keySet();
//
//        for(String key : keys)
//        {
//            if(properties.get(key).getNumberOfBedrooms() >= minBedrooms
//                    && properties.get(key).getNumberOfBedrooms() <= maxBedrooms)
//            {
//                propertiesWithBedrooms.put(properties.get(key).getPropertyId(), properties.get(key));
//            }
//        }
//
//        if(propertiesWithBedrooms.size() > 0)
//        {
//            return propertiesWithBedrooms;
//        } else
//        {
//            return null;
//        }
//    }
//
//    /**
//     * @param propertyType is the property type
//     * @return an ArrayList of the agency's data of the requested property type
//     */
//    public ArrayList<String> getPropertiesOfType(final String propertyType)
//    {
//        ArrayList<String> agencyData, agencyData2;
//        agencyData = new ArrayList<>();
//
//        Set<String> keys;
//        keys = properties.keySet();
//
//        if(!propertyType.equals("fake fake fake"))
//        {
//            agencyData.add("Type: COMMERCIAL\n");
//            for(String key : keys)
//            {
//                if(properties.get(key).getType().equalsIgnoreCase(propertyType))
//                {
//                    if(properties.get(key).getAddress().getUnitNumber() == null)
//                    {
//                        addStringVersion1(key, agencyData);
//                    } else
//                    {
//                        addStringVersion2(key, agencyData);
//                    }
//                }
//            }
//            return agencyData;
//        } else
//        {
//            agencyData2 = new ArrayList<>();
//            addStringVersion3(propertyType, agencyData2);
//            return agencyData2;
//        }
//    }
//
//    /**
//     * @param key        is the hashmap key
//     * @param agencyData is the list that will have string data added as elements
//     */
//    private void addStringVersion1(final String key, final List<String> agencyData)
//    {
//        String streetNameAdjusted, postalCodeAdjusted, cityAdjusted, bedroomsPlurality, pool;
//        streetNameAdjusted = capitalizeFirstLetterOfEachWord(properties.get(key).getAddress().getStreetName());
//        postalCodeAdjusted = properties.get(key).getAddress().getPostalCode().toUpperCase();
//        cityAdjusted = capitalizeFirstLetterOfEachWord(properties.get(key).getAddress().getCity());
//        bedroomsPlurality = bedroomsPlurality(properties.get(key).getNumberOfBedrooms());
//        pool = determinePool(properties.get(key).hasSwimmingPool());
//
//        agencyData.add(") Property " + properties.get(key).getPropertyId() + ": "
//                               + properties.get(key).getAddress().getStreetNumber() + " "
//                               + streetNameAdjusted + " " + postalCodeAdjusted
//                               + " in " + cityAdjusted + " ("
//                               + properties.get(key).getNumberOfBedrooms() + " " + bedroomsPlurality + pool + "): $"
//                               + String.format("%.0f", properties.get(key).getPriceUsd()) + ".\n");
//    }
//
//    /**
//     * @param hasSwimmingPool is whether or not the property has a swimming pool
//     * @return " plus pool" if the property has a swimming pool, else empty string
//     */
//    private String determinePool(final boolean hasSwimmingPool)
//    {
//        return hasSwimmingPool ? " plus pool" : "";
//    }
//
//    /**
//     * @param key        is the the hashmap key
//     * @param agencyData is the list that will have string data added as elements
//     */
//    private void addStringVersion2(final String key, final List<String> agencyData)
//    {
//        String streetNameAdjusted, postalCodeAdjusted, cityAdjusted, bedroomsPlurality, pool;
//        streetNameAdjusted = capitalizeFirstLetterOfEachWord(properties.get(key).getAddress().getStreetName());
//        postalCodeAdjusted = properties.get(key).getAddress().getPostalCode().toUpperCase();
//        cityAdjusted = capitalizeFirstLetterOfEachWord(properties.get(key).getAddress().getCity());
//        bedroomsPlurality = bedroomsPlurality(properties.get(key).getNumberOfBedrooms());
//        pool = determinePool(properties.get(key).hasSwimmingPool());
//
//        agencyData.add(") Property " + properties.get(key).getPropertyId() + ": unit #"
//                               + properties.get(key).getAddress().getUnitNumber() + " at "
//                               + properties.get(key).getAddress().getStreetNumber() + " "
//                               + streetNameAdjusted + " " + postalCodeAdjusted
//                               + " in " + cityAdjusted + " ("
//                               + properties.get(key).getNumberOfBedrooms() + " " + bedroomsPlurality + pool
//                               + "): $" + String.format("%.0f", properties.get(key).getPriceUsd()) + ".\n");
//
//    }
//
//    /**
//     * @param propertyType is the property type
//     * @param agencyData2  is the list that will have string data added as elements
//     * @return an ArrayList of two string elements: 1) capitalized fake fake fake type and 2) <none found>
//     */
//    private ArrayList<String> addStringVersion3(String propertyType, List<String> agencyData2)
//    {
//        agencyData2.add("Type: " + propertyType.toUpperCase());
//        agencyData2.add("<none found>");
//        return (ArrayList<String>) agencyData2;
//    }
//
//    /**
//     * @param originalString is the original string
//     * @return the case-adjusted street name
//     */
//    private String capitalizeFirstLetterOfEachWord(final String originalString)
//    {
//        String caseAdjusted;
//
//        List<String> words;
//        words = new ArrayList<>(Arrays.asList(originalString.split(" ")));
//
//        for(String word : words)
//        {
//            int index;
//            index = words.indexOf(word);
//
//            String adjustedWord;
//
//            String firstCharacter;
//            firstCharacter = word.substring(0, 1);
//
//            if(Pattern.matches("[a-z]", firstCharacter))
//            {
//                String capitalized;
//                capitalized = firstCharacter.toUpperCase();
//                adjustedWord = capitalized + word.substring(1) + " ";
//            } else
//            {
//                adjustedWord = firstCharacter + word.substring(1) + " ";
//            }
//
//            caseAdjusted = String.join(" ", adjustedWord);
//            words.set(index, caseAdjusted);
//        }
//        caseAdjusted = String.join("", words).trim();
//        return caseAdjusted;
//    }
//
//    /**
//     * @param numberOfBedrooms is the number of bedrooms
//     * @return the string "bedrooms" or "bedroom" depending on the plurality
//     */
//    private String bedroomsPlurality(final int numberOfBedrooms)
//    {
//        if(numberOfBedrooms > 1)
//        {
//            return "bedrooms";
//        } else
//        {
//            return "bedroom";
//        }
//    }
//}
