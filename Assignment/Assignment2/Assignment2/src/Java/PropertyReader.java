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
    private static ArrayList<String> linesInFile;

    /**
     * Reads “property_data.txt” and adds Strings (for each line) to an ArrayList<String> and returns it.
     * @param file is a file containing properties
     * @return the strings of each line in the file
     * @throws FileNotFoundException if file is not found
     */
    public static ArrayList<String> readPropertyData(final File file) throws FileNotFoundException
    {
        Scanner scanner;
        String  line;

        scanner = new Scanner(file);
        linesInFile = new ArrayList<>();

        while(scanner.hasNextLine())
        {
            linesInFile.add(scanner.nextLine());
        }
        scanner.close();

        return linesInFile;
    }
}
