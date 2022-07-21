import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AddressReader class reads an address.
 * @author Chris Wu
 * @version 1.0
 */
public class AddressReader
{
    private static       ArrayList<Address> addresses;
    private static final long               EMPTY = 0;

    /**
     * The AddressReader constructor.
     */
    public AddressReader()
    {
        addresses = new ArrayList<>();
    }

    /**
     * Reads “address_data.txt” and adds Address objects to an ArrayList<Address> and returns it.
     * @param file is a file containing addresses
     * @return the ArrayList<Address> that contains addresses read from “address_data.txt”
     * @throws FileNotFoundException if file is not found
     */
    public static ArrayList<Address> readAddressData(final File file) throws FileNotFoundException
    {
        Scanner scanner;
        Address address;

        scanner = new Scanner(file);

        if(file.length() == EMPTY)
        {
            System.out.println("File empty");
        }
        else
        {
            while(scanner.hasNextLine())
            {

                //address = new Address();
            }
        }
        return addresses;
    }
}