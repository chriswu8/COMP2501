//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
public class Main
{
    public static void main(String[] args) //throws FileNotFoundException
    {
        Address address = new Address("20", 7420, "Moffatt Rd", "V6Y1X8", "Richmond");

        Property property = new Property(999999.99, address, "commercial", "abc123");

        System.out.println(property);

    }
//        ArrayList<String> propertyData;
//        File              file;
//        Scanner myScanner;
//
//        propertyData = new ArrayList<>();
//
//        file = new File("property_data.txt");
//
//        myScanner = new Scanner(file);
//
//        while(myScanner.hasNextLine())
//        {
//            propertyData.add(myScanner.nextLine());
//        }
//
//        for(String str : propertyData)
//        {
//            System.out.println(str);
//        }
//    }
}
