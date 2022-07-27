/**
 * The Address class represents an address.
 * @author Chris Wu
 * Version 1.0
 */
public class Address
{
    private int    streetNumber;
    private String unitNumber;
    private String streetName;
    private String postalCode;
    private String city;

    private static final int MAX_STREET_NUM_LENGTH  = 20;
    private static final int MIN_POSTAL_CODE_LENGTH = 5;
    private static final int MAX_POSTAL_CODE_LENGTH = 6;
    private static final int MAX_CITY_LENGTH        = 30;

    /**
     * The constructor
     * @param unitNumber   is the unit number
     * @param streetNumber is the street number
     * @param streetName   is the street name
     * @param postalCode   is the postal code
     * @param city         is the city
     */
    public Address(final String unitNumber,
                   final int streetNumber,
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
     * @param unitNumber   is the unit number
     * @param streetNumber is the street number
     * @param streetName   is the street name
     * @param postalCode   is the postal code
     * @param city         is the city
     */
    public void initialize(final String unitNumber,
                           final int streetNumber,
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
        if(unitNumber == null)
        {
            initialize(null, streetNumber, streetName, postalCode, city);
        }

        if(unitNumber != null && unitNumber.equals(" "))
        {
            initialize("", streetNumber, streetName, postalCode, city);
        }
    }

    /**
     * @param streetNumber is the street number
     */
    private void getExpectedExceptionsStreetNumber(final int streetNumber)
    {
        final int minStreetNum;
        final int maxStreetNum;
        minStreetNum = 0;
        maxStreetNum = 999999;

        if(streetNumber < minStreetNum || streetNumber > maxStreetNum)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }
    }

    /**
     * @param streetName is the street name
     */
    private void getExpectedExceptionsStreetName(final String streetName)
    {
        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        }
        else if(streetName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid street name: ");
        }
        else if(streetName.length() > MAX_STREET_NUM_LENGTH)
        {
            throw new IllegalArgumentException("Invalid street name length: must be between 1-20 characters");
        }
    }

    /**
     * @param postalCode is the postal code
     */
    private void getExpectedExceptionsPostalCode(final String postalCode)
    {
        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        }
        else if(postalCode.length() != MIN_POSTAL_CODE_LENGTH && postalCode.length() != MAX_POSTAL_CODE_LENGTH)
        {
            throw new IllegalArgumentException("Invalid postal code length: must be of length 5 or 6");
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
                                           final int streetNumber,
                                           final String streetName,
                                           final String postalCode,
                                           final String city)
    {
        if(city == null)
        {
            throw new NullPointerException("Invalid city: null");
        }
        else if(city.isEmpty())
        {
            throw new IllegalArgumentException("Invalid city: ");
        }
        else if(city.length() > MAX_CITY_LENGTH)
        {
            throw new IllegalArgumentException("Invalid city length: must be between 1-30 characters ");
        }
        else
        {
            initialize(unitNumber, streetNumber, streetName, postalCode, city);
        }
    }

    @Override
    public String toString()
    {
        if(unitNumber == null || unitNumber.isBlank())
        {
            return "address=Address [unitNumber= " + ", streetNumber=" + streetNumber + ", streetName="
                    + streetName + ", postalCode=" + postalCode + ", city=" + city + "]";
        }
        else
        {
            return "address=Address [unitNumber=" + getUnitNumber() + ", streetNumber=" + getStreetNumber()
                    + ", streetName=" + getStreetName() + ", postalCode=" + getPostalCode()
                    + ", city=" + getCity() + "]";
        }
    }
}
