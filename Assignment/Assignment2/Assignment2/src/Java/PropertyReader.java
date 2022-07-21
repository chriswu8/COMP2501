import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The PropertyReader class reads a property.
 * @author Chris Wu
 * @version 1.0
 */
public class PropertyReader
{
    private static ArrayList<String> properties;

    /**
     * The PropertyReader constructor.
     */
    public PropertyReader()
    {
        properties = new ArrayList<>();
    }

    /**
     * @param file is a file containing properties
     * @return the properties arraylist
     * @throws FileNotFoundException if file is not found
     */
    public static ArrayList<String> readPropertyData(final File file) throws FileNotFoundException
    {
        Scanner propertyScanner;
        propertyScanner = new Scanner(file);

        while(propertyScanner.hasNextLine())
        {
            properties.add(propertyScanner.nextLine());
        }

        return properties;
    }
}
