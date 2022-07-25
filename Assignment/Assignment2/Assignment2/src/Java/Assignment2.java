import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

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

    private final Agency    agency;
    private       String[]  tokens;
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
    private static final int    LOADING_DOCK_INDEX           = 3;
    private static final int    HIGHWAY_ACCESS_INDEX         = 4;

    /**
     * The Assignment2 constructor
     */
    public Assignment2()
    {
        agency = new Agency("Rumpelstiltskin");
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
        AddressReader      addressReader;
        PropertyReader     propertyReader;
        ArrayList<Address> addresses;
        ArrayList<String>  properties;

        addressData = new File("address_data.txt");
        propertyData = new File("property_data.txt");
        addressReader = new AddressReader();
        propertyReader = new PropertyReader();

        addresses = addressReader.readAddressData(addressData); // arraylist of address

        properties = propertyReader.readPropertyData(propertyData);

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
        if(tokens[COMMERCIAL_ID_INDEX].equalsIgnoreCase("commercial"))
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
        if(tokens[RESIDENCE_ID_INDEX].equalsIgnoreCase("residence"))
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
        if(tokens[RETAIL_ID_INDEX].equalsIgnoreCase("retail"))
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
    public void doSearches()
    {
        Scanner scanner;
        Boolean programRunning;
        String  userInput;

        scanner = new Scanner(System.in);
        programRunning = true;

        System.out.println("Welcome to our Property search.\n" + "Choose one of the following options\n:" + "\t\t1" + ".\tGeneral Queries\n" + "\t\t2.\tResidence Queries\n" + "\t\t3.\tCommercial " + "Queries\n" + "\t\t4.\tRetail Queries\n" + "\t\t5.\tExit");
        userInput = scanner.next();

        while(programRunning)
        {
            if(userInput.equalsIgnoreCase("1"))
            {
                generalQueries();
            }
            if(userInput.equalsIgnoreCase("2"))
            {
                residenceQueries();
            }
            if(userInput.equalsIgnoreCase("3"))
            {
                commercialQueries();
            }
            if(userInput.equalsIgnoreCase("4"))
            {
                retailQueries();
            }
            if(userInput.equalsIgnoreCase("5"))
            {
                System.out.println("Goodbye for now!");
            }
        }
    }

    private void retailQueries()
    {

    }

    private void commercialQueries()
    {

    }

    private void residenceQueries()
    {
        Scanner scanner;
        String  userInput;

        scanner = new Scanner(System.in);

        System.out.println("General Queries\n1.By Pool\n" + "2.By Bedroom\n" + "3.By Strata\n" + "4.Back\n");

        userInput = scanner.next();

        if(userInput.equalsIgnoreCase("1"))
        {
            generalQueries();
        }
        if(userInput.equalsIgnoreCase("2"))
        {
            residenceQueries();
        }
        if(userInput.equalsIgnoreCase("3"))
        {
            commercialQueries();
        }
        if(userInput.equalsIgnoreCase("4"))
        {
            retailQueries();
        }

    }

    private void generalQueries()
    {
        Property[] matchingProperties;
        Scanner scanner;
        String  userInput;
        String  propertyId;
        String  street;
        int  minPrice;
        int  maxPrice;

        scanner = new Scanner(System.in);

        System.out.println("General Queries\n1.By Property ID\n" +
                                   "2.By Price\n" +
                                   "3.By Street\n" +
                                   "4.By Type\n" +
                                   "5.Back");

        userInput = scanner.next();

        if(userInput.equalsIgnoreCase("1"))
        {
            System.out.println("Enter the Property ID: ");

            propertyId = scanner.nextLine();
            System.out.println(agency.getProperty(propertyId));

        }

        if(userInput.equalsIgnoreCase("2"))
        {
            System.out.println("Enter the minimum price: ");
            minPrice = scanner.nextInt();

            System.out.println("Enter the maximum price: ");
            maxPrice = scanner.nextInt();

            matchingProperties = agency.getPropertiesBetween(minPrice, maxPrice);

            for(int i = 0; i < matchingProperties.length; i++)
            {
                System.out.println(matchingProperties[i]);
            }
        }

        if(userInput.equalsIgnoreCase("3"))
        {
            System.out.println("Enter the street name: ");
            street = scanner.nextLine();


        }

        if(userInput.equalsIgnoreCase("4"))
        {
            retailQueries();
        }

        if(userInput.equalsIgnoreCase("5"))
        {
            retailQueries();
        }
    }

    /**
     * The entry point of the program
     * @param args are the command line arguments
     */
    public static void main(final String[] args) throws FileNotFoundException
    {
        Assignment2 obj;

        obj = new Assignment2();

        obj.init();
    }
}
