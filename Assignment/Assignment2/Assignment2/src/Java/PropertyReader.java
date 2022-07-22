import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The PropertyReader class reads from the property_data.txt file and adds Strings to an ArrayList<String>
 * @author Chris Wu
 * @version 1.0
 */
public class PropertyReader
{
    private static       ArrayList<String> properties;
    private static final long              EMPTY     = 0;
    private static final String            DELIMITER = "\\|";

    /**
     * The PropertyReader constructor.
     */
    public PropertyReader()
    {
        properties = new ArrayList<>();
    }

    /**
     * Reads “property_data.txt” and adds Strings (for each line) to an ArrayList<String> and returns it.
     * @param file is a file containing properties
     * @return the properties arraylist
     * @throws FileNotFoundException if file is not found
     */
    public static ArrayList<String> readPropertyData(final File file) throws FileNotFoundException
    {
        Scanner   scanner;
        String[]  arr;
        String    formattedString;
        final int priceIndex                = 0;
        final int numberOfBedroomsIndex     = 1;
        final int swimmingPoolIndex         = 2;
        final int residenceTypeIndex        = 3;
        final int residencePropertyIdIndex  = 4;
        final int strataIndex               = 5;
        final int retailTypeIndex           = 1;
        final int retailPropertyIdIndex     = 2;
        final int squareFootageIndex        = 3;
        final int customerParkingIndex      = 4;
        final int commercialTypeIndex       = 1;
        final int commercialPropertyIdIndex = 2;
        final int loadingDockIndex          = 3;
        final int highwayAccessIndex        = 4;

        scanner = new Scanner(file);

        if(file.length() == EMPTY)
        {
            System.out.println("File empty");
        }
        else
        {
            while(scanner.hasNextLine())
            {
                arr = scanner.nextLine().split(DELIMITER);

                createString(arr, priceIndex, numberOfBedroomsIndex, swimmingPoolIndex, residenceTypeIndex,
                          residencePropertyIdIndex, strataIndex, retailTypeIndex, retailPropertyIdIndex,
                          squareFootageIndex, customerParkingIndex, commercialTypeIndex, commercialPropertyIdIndex,
                          loadingDockIndex, highwayAccessIndex);
            }
        }
        scanner.close();
        return properties;
    }

    private static void createString(final String[] arr,
                                     final int priceIndex,
                                     final int numberOfBedroomsIndex,
                                     final int swimmingPoolIndex,
                                     final int residenceTypeIndex,
                                     final int residencePropertyIdIndex,
                                     final int strataIndex,
                                     final int retailTypeIndex,
                                     final int retailPropertyIdIndex,
                                     final int squareFootageIndex,
                                     final int customerParkingIndex,
                                     final int commercialTypeIndex,
                                     final int commercialPropertyIdIndex,
                                     final  int loadingDockIndex,
                                     final  int highwayAccessIndex)
    {
        String formattedString;
        if(arr[residenceTypeIndex].equals("residence"))
        {
            formattedString = getFormattedString(arr, priceIndex, numberOfBedroomsIndex, swimmingPoolIndex,
                                                 residenceTypeIndex, residencePropertyIdIndex, strataIndex);
            properties.add(formattedString);
        }

        if(arr[retailTypeIndex].equals("retail"))
        {
            formattedString = getFormattedString(arr, priceIndex, retailTypeIndex, retailPropertyIdIndex, squareFootageIndex, customerParkingIndex);
            properties.add(formattedString);
        }

        if(arr[commercialTypeIndex].equals("commercial"))
        {
            formattedString = getString(arr, priceIndex, commercialTypeIndex, commercialPropertyIdIndex, loadingDockIndex, highwayAccessIndex);
            properties.add(formattedString);
        }
    }

    private static String getFormattedString(final String[] arr,
                                             final int priceIndex,
                                             final int numberOfBedroomsIndex,
                                             final int swimmingPoolIndex,
                                             final int residenceTypeIndex,
                                             final int residencePropertyIdIndex,
                                             final int strataIndex)
    {
        String formattedString;
        formattedString = "Price: " + arr[priceIndex]
                        + "Number of bedrooms: " + arr[numberOfBedroomsIndex]
                        + "Has swimming pool: " + arr[swimmingPoolIndex]
                        + "Property type: " + arr[residenceTypeIndex]
                        + "Property Id: " + arr[residencePropertyIdIndex]
                        + "Part of strata: " + arr[strataIndex];
        return formattedString;
    }

    private static String getFormattedString(final String[] arr,
                                             final int priceIndex,
                                             final int retailTypeIndex,
                                             final int retailPropertyIdIndex,
                                             final int squareFootageIndex,
                                             final int customerParkingIndex)
    {
        String formattedString;
        formattedString = "Price: " + arr[priceIndex]
                + "Property type: " + arr[retailTypeIndex]
                + "Property Id: " + arr[retailPropertyIdIndex]
                + "Square footage: " + arr[squareFootageIndex]
                + "Has customer parking: " + arr[customerParkingIndex];
        return formattedString;
    }

    private static String getString(final String[] arr,
                                             final int priceIndex,
                                             final int commercialTypeIndex,
                                             final int commercialPropertyIdIndex,
                                             final int loadingDockIndex,
                                             final int highwayAccessIndex)
    {
        String formattedString;
        formattedString = "Price: " + arr[priceIndex]
                + "Property type: " + arr[commercialTypeIndex]
                + "Property Id: " + arr[commercialPropertyIdIndex]
                + "Has loading dock: " + arr[loadingDockIndex]
                + "Has highway access: " + arr[highwayAccessIndex];
        return formattedString;
    }
}
