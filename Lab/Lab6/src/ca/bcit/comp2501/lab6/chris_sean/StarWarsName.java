package ca.bcit.comp2501.lab6.chris_sean;

/**
 * The StarWarsName class represents Star Wars names
 * @author Chris Wu and Sean Sampson
 * @version 1.0
 */
public class StarWarsName
{
    private final        StringBuilder builder;
    private static final int           INDEX_ZERO                        = 0;
    private static final int           INDEX_ONE                         = 1;
    private static final int           INDEX_TWO                         = 2;
    private static final int           INDEX_THREE                       = 3;
    private static final int           REQUIRED_NUMBER_OF_STRINGS_IN_ARR = 4;


    /**
     * The constructor
     * @param arr is the array of strings from the command line argument that were separated via pipes (|)
     *            (eg. if the command line argument is "Brady|Mills|Shepherd|Chilliwack"
     *            arr would be ["Brady", "Mills", "Shepherd", "Chilliwack"])
     */
    public StarWarsName(final String[] arr)
    {
        checkStrings(arr);
        builder = new StringBuilder();
        System.out.format("Your Star Wars name is: %s", generateString(arr));
    }

    /**
     * @param arr is the array of strings from the command line argument that were separated via pipes (|)
     */
    private void checkStrings(final String[] arr)
    {
        if(arr.length != REQUIRED_NUMBER_OF_STRINGS_IN_ARR)
        {
            System.err.println("ERROR: incorrect number of words provided.");
            System.exit(0);
        }

        if(arr[INDEX_ZERO].length() < INDEX_THREE ||
                arr[INDEX_ONE].length() < INDEX_TWO ||
                arr[INDEX_TWO].length() < INDEX_TWO ||
                arr[INDEX_THREE].length() < INDEX_THREE)
        {
            System.err.println("ERROR: insufficient number of letters in one or more words to generate a Star Wars " +
                                       "name.");
        }
    }

    /**
     * @param arr is the array of strings from the command line argument that were separated via pipes (|)
     * @return starWarsName is the generated Star Wars name
     */
    private String generateString(final String[] arr)
    {
        final String starWarsName;

        for(String string : arr)
        {
            if(string.equals(arr[INDEX_ZERO]))
            {
                builder.append(string.substring(INDEX_ZERO, INDEX_ONE).toUpperCase());
                builder.append(string.substring(INDEX_ONE, INDEX_THREE).toLowerCase());
            }
            else if(string.equals(arr[INDEX_ONE]))
            {
                builder.append(string.substring(INDEX_ZERO, INDEX_TWO).toLowerCase() + " ");
            }
            else if(string.equals(arr[INDEX_TWO]))
            {
                builder.append(string.substring(INDEX_ZERO, INDEX_ONE).toUpperCase());
                builder.append(string.substring(INDEX_ONE, INDEX_TWO).toLowerCase());
            }
            else
            {
                builder.append(string.substring(INDEX_ZERO, INDEX_THREE).toLowerCase());
            }
        }

        starWarsName = builder.toString();
        return starWarsName;
    }

    /**
     * This is the entry point of the program.
     * @param args is the command line argument containing one's
     *             first name, last name, mother's maiden name, and city of birth
     *             separated via pipes (|)
     */
    public static void main(final String[] args)
    {
        if(args.length == StarWarsName.INDEX_ZERO)
        {
            throw new IllegalArgumentException("missing data input");
        }
        else
        {
            final String[]     arr;
            final StarWarsName name;

            arr = args[StarWarsName.INDEX_ZERO].split("\\|");

            name = new StarWarsName(arr);
        }
    }
}
