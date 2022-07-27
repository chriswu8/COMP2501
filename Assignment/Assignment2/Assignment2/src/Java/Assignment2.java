import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * The Assignment2 class is the driver class for assignment 2.
 * @author Chris Wu
 * Version 1.0
 */
public class Assignment2
{
    private Residence  aResidence;
    private Retail     aRetail;
    private Commercial aCommercial;
    private String[]   tokens;

    private final Agency    agency;
    private final Address[] allAddresses;

    private static final String DELIMITER                    = "\\|";
    private static final int    ARRAY_SIZE                   = 6;
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
    private static final int    LOADING_DOCK_INDEX           = 4;
    private static final int    HIGHWAY_ACCESS_INDEX         = 3;

    /**
     * The Assignment2 constructor
     */
    public Assignment2()
    {
        agency = new Agency("Agency1");
        tokens = new String[ARRAY_SIZE];
        allAddresses = new Address[ARRAY_SIZE2];
    }

    /**
     * Gets the ArrayList<Address> and ArrayList<String> form AddressReader and PropertyReader,
     * and uses them to create subtype Objects and adds them to the Agency.HashMap<String, Property> properties
     * @throws FileNotFoundException if file not found
     */
    public void init() throws FileNotFoundException
    {
        File               addressData;
        File               propertyData;
        ArrayList<Address> addresses;
        ArrayList<String>  properties;

        addressData = new File("address_data.txt");
        propertyData = new File("property_data.txt");

        addresses = AddressReader.readAddressData(addressData);
        properties = PropertyReader.readPropertyData(propertyData);

        createSubtypes(addresses, properties);
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
            aCommercial = new Commercial(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                         tokens[RETAIL_COMMERCIAL_TYPE_INDEX], tokens[COMMERCIAL_ID_INDEX],
                                         Boolean.parseBoolean(tokens[LOADING_DOCK_INDEX]),
                                         Boolean.parseBoolean(tokens[HIGHWAY_ACCESS_INDEX]));

            agency.addProperty(aCommercial);
        }
    }

    private void dealWithResidence(final int i)
    {
        if(tokens[RESIDENCE_TYPE_INDEX].equalsIgnoreCase("residence"))
        {
            aResidence = new Residence(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                       tokens[RESIDENCE_TYPE_INDEX], tokens[RESIDENCE_ID_INDEX],
                                       Integer.parseInt(tokens[BEDROOM_INDEX]),
                                       Boolean.parseBoolean(tokens[POOL_INDEX]),
                                       Boolean.parseBoolean(tokens[STRATA_INDEX]));

            agency.addProperty(aResidence);
        }
    }

    private void dealWithRetail(final int i)
    {
        if(tokens[RETAIL_COMMERCIAL_TYPE_INDEX].equalsIgnoreCase("retail"))
        {
            aRetail = new Retail(Double.parseDouble(tokens[PRICE_USD_INDEX]), allAddresses[i],
                                 tokens[RETAIL_COMMERCIAL_TYPE_INDEX], tokens[RETAIL_ID_INDEX],
                                 Integer.parseInt(tokens[SQUARE_FOOTAGE_INDEX]),
                                 Boolean.parseBoolean(tokens[CUSTOMER_PARKING_INDEX]));

            agency.addProperty(aRetail);
        }
    }

    /**
     * Provides the primary user interface through command prompts that will allow the user to
     * choose which search operations to perform. Each search will display results to the console.
     */
    public void doSearches() throws FileNotFoundException
    {
        Scanner scanner;
        boolean programRunning;
        String  userInput;

        scanner = new Scanner(System.in);
        programRunning = true;

        while(programRunning)
        {
            System.out.println("""

                               Welcome to our Property search.
                               Choose one of the following options:
                               \t\t1.\tGeneral Queries
                               \t\t2.\tResidence Queries
                               \t\t3.\tCommercial Queries
                               \t\t4.\tRetail Queries
                               \t\t5.\tExit""");

            userInput = scanner.next();

            if(userInput.equalsIgnoreCase("1"))
            {
                generalQueries(scanner);
            }
            if(userInput.equalsIgnoreCase("2"))
            {
                residenceQueries(scanner);
            }
            if(userInput.equalsIgnoreCase("3"))
            {
                commercialQueries(scanner);
            }
            if(userInput.equalsIgnoreCase("4"))
            {
                retailQueries(scanner);
            }
            if(userInput.equalsIgnoreCase("5"))
            {
                System.out.println("Goodbye for now!");
                programRunning = false;
            }
        }
        scanner.close();
    }

    private void retailQueries(final Scanner scanner)
    {
        String userInput;
        System.out.println("""
                           Commercial Queries
                           \t\t1.\tBy Square Footage
                           \t\t2.\tBy Customer Parking
                           \t\t3.\tBack
                           """);

        userInput = scanner.next();
        valid1To3(userInput);

        queryRetail1(scanner, userInput);
        queryRetail2(userInput);
    }

    private void queryRetail2(final String userInput)
    {
        ArrayList<Retail> retailsWithCustomerParking;

        if(userInput.equals("2"))
        {
            retailsWithCustomerParking = agency.getPropertiesWithCustomerParking();

            for(Retail retail : retailsWithCustomerParking)
            {
                System.out.println(retail);
            }
        }
    }

    private void queryRetail1(final Scanner scanner,
                              final String userInput)
    {
        int               minSquareFootage;
        ArrayList<Retail> retailsAboveMinSquareFootage;

        if(userInput.equals("1"))
        {
            System.out.println("Enter the minimum desired square footage: ");
            minSquareFootage = scanner.nextInt();
            retailsAboveMinSquareFootage = agency.getPropertiesSquareFootage(minSquareFootage);

            for(Retail retail : retailsAboveMinSquareFootage)
            {
                System.out.println(retail);
            }
        }
    }

    private void commercialQueries(final Scanner scanner)
    {
        String userInput;
        System.out.println("""
                           Commercial Queries
                           \t\t1.\tBy Loading Dock
                           \t\t2.\tBy Highway Access
                           \t\t3.\tBack
                           """);

        userInput = scanner.next();
        valid1To3(userInput);

        queryCommercial1(userInput);
        queryCommercial2(userInput);
    }

    private void queryCommercial2(final String userInput)
    {
        ArrayList<Commercial> comWithHighwayAccess;

        if(userInput.equals("2"))
        {
            comWithHighwayAccess = agency.getPropertiesWithHighwayAccess();

            for(Commercial commercial : comWithHighwayAccess)
            {
                System.out.println(commercial);
            }
        }
    }

    private void queryCommercial1(final String userInput)
    {
        ArrayList<Commercial> comWIthLoadingDock;

        if(userInput.equals("1"))
        {
            comWIthLoadingDock = agency.getPropertiesWithLoadingDocks();

            for(Commercial commercial : comWIthLoadingDock)
            {
                System.out.println(commercial);
            }
        }
    }

    private void residenceQueries(final Scanner scanner)
    {
        String userInput;

        System.out.println("""
                           General Queries
                           \t\t1.\tBy Bedroom
                           \t\t2.\tBy Pool
                           \t\t3.\tBy Strata
                           \t\t4.\tBack
                           """);

        userInput = scanner.next();
        valid1To4(userInput);

        queryResidence1(scanner, userInput);
        queryResidence2(userInput);
        queryResidence3(userInput);
    }

    private void queryResidence3(final String userInput)
    {
        ArrayList<Residence> resWithStrata;

        if(userInput.equalsIgnoreCase("3"))
        {
            resWithStrata = agency.getPropertiesWithStrata();

            for(Residence res : resWithStrata)
            {
                System.out.println(res);
            }
        }
    }

    private void queryResidence2(final String userInput)
    {
        ArrayList<Residence> resWithPool;

        if(userInput.equalsIgnoreCase("2"))
        {
            resWithPool = agency.getPropertiesWithPools();

            for(Residence res : resWithPool)
            {
                System.out.println(res);
            }
        }
    }

    private void queryResidence1(final Scanner scanner,
                                 final String userInput)
    {
        HashMap<String, Residence> residences;
        int                        minBedroom;
        Set<String>                keys;
        int                        maxBedroom;

        if(userInput.equalsIgnoreCase("1"))
        {
            System.out.println("Enter the minimum number of bedrooms: ");
            minBedroom = scanner.nextInt();

            System.out.println("Enter the maximum number of bedrooms: ");
            maxBedroom = scanner.nextInt();

            residences = agency.getPropertiesWithBedrooms(minBedroom, maxBedroom);

            if(residences != null)
            {
                keys = residences.keySet();
            }
            else
            {
                throw new IllegalArgumentException("Invalid HashMap: null ");
            }

            for(String key : keys)
            {
                if(residences.get(key) != null)
                {
                    System.out.println(residences.get(key));
                }
            }
        }
    }

    private void generalQueries(final Scanner scanner) throws FileNotFoundException
    {
        String userInput;

        System.out.println("""

                           General Queries
                           1.By Property ID
                           2.By Price
                           3.By Street
                           4.By Type
                           5.Back""");

        userInput = scanner.next();

        valid1To5(userInput);

        query1(scanner, userInput);

        query2(scanner, userInput);

        query3(scanner, userInput);

        query4(scanner, userInput);
    }

    private void query4(final Scanner scanner,
                        final String userInput) throws FileNotFoundException
    {
        ArrayList<Property> properties;
        String              propertyType;
        if(userInput.equalsIgnoreCase("4"))
        {
            System.out.println("Enter the property type (residence, commercial, retail): ");

            propertyType = scanner.next();
            properties = agency.getPropertiesOfType(propertyType);

            for(Property property : properties)
            {
                if(property instanceof Residence)
                {
                    aResidence = (Residence) property;
                    System.out.println(aResidence);
                }

                if(property instanceof Retail)
                {
                    aRetail = (Retail) property;
                    System.out.println(aRetail);
                }

                if(property instanceof Commercial)
                {
                    aCommercial = (Commercial) property;
                    System.out.println(aCommercial);
                }
            }
        }
    }

    private void query3(final Scanner scanner,
                        final String userInput)
    {
        String              street;
        ArrayList<Property> listOfMatches;
        ArrayList<Address>  matchingAddress;

        if(userInput.equalsIgnoreCase("3"))
        {
            System.out.println("Enter the street name: ");

            street = getStreetName(scanner);

            matchingAddress = agency.getPropertiesOn(street);

            if(matchingAddress.size() > 0)
            {
                for(Address address : matchingAddress)
                {
                    System.out.println("\n" + address);
                }
            }
            else
            {
                System.out.println("\nNo property is available for the entered street." + "\nPlease ensure correct " +
                                           "spacing and spelling.");
            }
        }
    }

    private String getStreetName(final Scanner scanner)
    {
        final String        street;
        final String[]      words;
        final int           size;
        final StringBuilder builder;

        size = 2;
        words = new String[size];
        builder = new StringBuilder();

        for(int i = 0; i < words.length; i++)
        {
            words[i] = scanner.next();
        }

        for(int i = 0; i < words.length; i++)
        {
            builder.append(words[i]);
            builder.append(" ");
        }

        street = builder.toString().trim();

        return street;
    }

    private void query2(final Scanner scanner,
                        final String userInput)
    {
        int        maxPrice;
        int        minPrice;
        Property[] matchingProperties;
        if(userInput.equalsIgnoreCase("2"))
        {
            System.out.println("Enter the minimum price: ");
            minPrice = scanner.nextInt();

            System.out.println("Enter the maximum price: ");
            maxPrice = scanner.nextInt();

            matchingProperties = agency.getPropertiesBetween(minPrice, maxPrice);

            for(Property matchingProperty : matchingProperties)
            {
                System.out.println(matchingProperty);
            }
        }
    }

    private void query1(final Scanner scanner,
                        final String userInput)
    {
        String propertyId;
        if(userInput.equalsIgnoreCase("1"))
        {
            System.out.println("Enter the Property ID: ");

            propertyId = scanner.next();
            System.out.println(agency.getProperty(propertyId));

        }
    }

    private void valid1To5(final String userInput)
    {
        if(! userInput.equals("1") && ! userInput.equals("2") && ! userInput.equals("3") && ! userInput.equals("4") && ! userInput.equals("5"))
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    private void valid1To4(final String userInput)
    {
        if(! userInput.equals("1") && ! userInput.equals("2") && ! userInput.equals("3") && ! userInput.equals("4"))
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    private void valid1To3(final String userInput)
    {
        if(! userInput.equals("1") && ! userInput.equals("2") && ! userInput.equals("3"))
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    /**
     * The entry point of the program
     * @param args are the command line arguments
     */
    public static void main(final String[] args) throws FileNotFoundException
    {
        Assignment2 assignment2;
        assignment2 = new Assignment2();

        assignment2.init();
        assignment2.doSearches();

    }
}
