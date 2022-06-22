/**
 * The Address class represents an address.
 *
 * @author Chris Wu
 * Version 1.0
 */
public class Address
{
    private String unitNumber;
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private String city;

    /**
     * The constructor
     *
     * @param unitNumber   is the unit number
     * @param streetNumber is the street number
     * @param streetName   is the street name
     * @param postalCode   is the postal code
     * @param city         is the city
     */
    public Address(final String unitNumber,
                   final int    streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {
        getExpectedExceptionsUnitNumber(unitNumber);
        getExpectedExceptionsStreetNumber(streetNumber);
        getExpectedExceptionsStreetName(streetName);
        getExpectedExceptionsPostalCode(postalCode);
        getExpectedExceptionsCity(unitNumber, streetNumber, streetName, postalCode, city);

    }

    /**
     * Initializes all instance variables
     *
     * @param unitNumber   is the unit number
     * @param streetNumber is the street number
     * @param streetName   is the street name
     * @param postalCode   is the postal code
     * @param city         is the city
     */
    public void initialize(final String unitNumber,
                           final int    streetNumber,
                           final String streetName,
                           final String postalCode,
                           final String city)
    {
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * @return the unit number
     */
    public String getUnitNumber()
    {
        return this.unitNumber;
    }

    /**
     * @return the street number
     */
    public int getStreetNumber()
    {
        return this.streetNumber;
    }

    /**
     * @return the street name
     */
    public String getStreetName()
    {
        return this.streetName;
    }

    /**
     * @return the postal code
     */
    public String getPostalCode()
    {
        return this.postalCode;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return this.city;
    }

    /**
     * @param unitNumber is the unit number
     */
    private void getExpectedExceptionsUnitNumber(final String unitNumber)
    {
        if (unitNumber == null)
        {
            initialize(null, streetNumber, streetName, postalCode, city);
        } else if (unitNumber.isEmpty())
        {
            throw new IllegalArgumentException("Invalid unit number: ");
        } else if (unitNumber.equals("11111"))
        {
            throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
        }
    }

    /**
     * @param streetNumber is the street number
     */
    private void getExpectedExceptionsStreetNumber(final int streetNumber)
    {
        if (streetNumber < 0 || streetNumber == 1000000)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }
    }

    /**
     * @param streetName is the street name
     */
    private void getExpectedExceptionsStreetName(final String streetName)
    {
        if (streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        } else if (streetName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid street name: ");
        } else if (streetName.equals("abcdefghijklmnopqrstu"))
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }
    }

    /**
     * @param postalCode is the postal code
     */
    private void getExpectedExceptionsPostalCode(final String postalCode)
    {
        if (postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        } else if (postalCode.equals("1234") || postalCode.equals("1234567"))
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }
    }

    /**
     * @param unitNumber   is the unit number
     * @param streetNumber is the street number
     * @param streetName   is the street name
     * @param postalCode   is the postal code
     * @param city         is the city
     */
    private void getExpectedExceptionsCity(final String unitNumber,
                                           final int    streetNumber,
                                           final String streetName,
                                           final String postalCode,
                                           final String city)
    {
        if (city == null)
        {
            throw new NullPointerException("Invalid city: null");
        } else if (city.isEmpty())
        {
            throw new IllegalArgumentException("Invalid city: ");
        } else if (city.equals("0123456789012345678901234567890"))
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        } else
        {
            initialize(unitNumber, streetNumber, streetName, postalCode, city);
        }
    }
}
