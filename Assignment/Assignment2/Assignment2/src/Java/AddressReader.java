import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AddressReader class reads and stores addresses.
 * @author Chris Wu
 * @version 1.0
 */
public class AddressReader
{
    private static final long   EMPTY     = 0;
    private static final String DELIMITER = "\\|";


    /**
     * Reads “address_data.txt” and adds Address objects to an ArrayList<Address> and returns it.
     * @param file is a file containing addresses
     * @return the ArrayList<Address> that contains addresses read from “address_data.txt”
     * @throws FileNotFoundException if file is not found
     */
    public static ArrayList<Address> readAddressData(final File file) throws FileNotFoundException
    {
        ArrayList<Address> addresses;
        Scanner            scanner;

        final int unitNumberIndex;
        final int streetNumberIndex;
        final int streetNameIndex;
        final int postalCodeIndex;
        final int cityIndex;

        scanner = new Scanner(file);
        addresses = new ArrayList<>();

        unitNumberIndex = 0;
        streetNumberIndex = 1;
        streetNameIndex = 2;
        postalCodeIndex = 3;
        cityIndex = 4;

        if(file.length() == EMPTY)
        {
            System.err.println("File empty");
        }
        else
        {
            addAllAddresses(addresses, scanner, unitNumberIndex,
                            streetNumberIndex, streetNameIndex,
                            postalCodeIndex, cityIndex);
        }
        scanner.close();
        return addresses;
    }

    private static void addAllAddresses(final ArrayList<Address> addresses,
                                        final Scanner scanner,
                                        final int unitNumberIndex,
                                        final int streetNumberIndex,
                                        final int streetNameIndex,
                                        final int postalCodeIndex,
                                        final int cityIndex)
    {
        Address  address;
        String[] arr;

        while(scanner.hasNextLine())
        {
            arr = scanner.nextLine().split(DELIMITER);

            address = new Address(arr[unitNumberIndex], Integer.parseInt(arr[streetNumberIndex]),
                                  arr[streetNameIndex], arr[postalCodeIndex], arr[cityIndex]);

            addresses.add(address);
        }
    }
}
