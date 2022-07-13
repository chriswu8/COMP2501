package ca.bcit.comp2501.lab10;

/**
 * The Record class models a music record
 * @author Chris Wu
 * @version 1.0
 */
public class Record extends MusicMedia
{
    private final        int    sizeInInches;
    private final        double revolutionsPerMinute;
    private static final int    SEVEN_INCH_RECORD  = 7;
    private static final int    TEN_INCH_RECORD    = 10;
    private static final int    TWELVE_INCH_RECORD = 12;
    private static final double MIN_RPM            = 0.0;
    private static final double RPM1               = 33.3;
    private static final double RPM2               = 45.0;
    private static final double RPM3               = 78.0;

    /**
     * The Record constructor
     * @param sizeInInches         is the size of the record in inches
     * @param revolutionsPerMinute is the rpm that the record spins
     */
    public Record(final int sizeInInches,
                  final double revolutionsPerMinute)
    {
        super();
        checkSizeInInches(sizeInInches);
        checkRevolutionsPerMinute(revolutionsPerMinute);

        this.sizeInInches = sizeInInches;
        this.revolutionsPerMinute = revolutionsPerMinute;
    }

    /**
     * @param revolutionsPerMinute is the RPM that the record spins
     */
    private void checkRevolutionsPerMinute(final double revolutionsPerMinute)
    {
        if(revolutionsPerMinute != RPM1 &&
                revolutionsPerMinute != RPM2 &&
                revolutionsPerMinute != RPM3 ||
                revolutionsPerMinute < MIN_RPM)
        {
            throw new IllegalArgumentException("Invalid RPM");
        }
    }

    /**
     * @param sizeInInches is the size of the record in inches
     */
    private void checkSizeInInches(final int sizeInInches)
    {
        if(sizeInInches != SEVEN_INCH_RECORD && sizeInInches != TEN_INCH_RECORD && sizeInInches != TWELVE_INCH_RECORD)
        {
            throw new IllegalArgumentException("Invalid record size");
        }
    }

    @Override
    public String toString()
    {
        return "Record [size=" + 7, rpm=45.0, toString()=Album [Artist=The Beatles, title=Hey Jude, trackCount=1, totalMinutes=7]];
    }
}
