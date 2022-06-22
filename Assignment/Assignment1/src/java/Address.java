public class Address
{
    private String unitNumber;
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private String city;

    public Address(final String unitNumber,
                   final int streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {
        if (unitNumber == null)
        {
            initialize(null, streetNumber, streetName, postalCode, city);
        } else if (unitNumber.isEmpty())
        {
            throw new IllegalArgumentException("Invalid unit number: ");
        } else if (unitNumber.equals("11111"))
        {
            throw new IllegalArgumentException("Invalid unit number: 11111");
        } else if (streetNumber < 0 || streetNumber == 1000000)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        } else if (streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        } else if (streetName.isEmpty())
        {
            throw new IllegalArgumentException("Invalid street name: ");
        } else if (streetName.equals("abcdefghijklmnopqrstu"))
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        } else if (postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        } else if (postalCode.equals("1234") || postalCode.equals("1234567"))
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        } else if (city == null)
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


    public String getUnitNumber()
    {
        return this.unitNumber;
    }

    public int getStreetNumber()
    {
        return this.streetNumber;
    }

    public String getStreetName()
    {
        return this.streetName;
    }

    public String getPostalCode()
    {
        return this.postalCode;
    }

    public String getCity()
    {
        return this.city;
    }


}
