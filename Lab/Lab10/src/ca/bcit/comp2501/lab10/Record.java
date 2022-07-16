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
    private static final double RPM1               = 33.3;
    private static final double RPM2               = 45.0;
    private static final double RPM3               = 78.0;

    /**
     * The Record constructor
     * @param artist                is the musical artist
     * @param songTitle             is the song title
     * @param numOfSongs            is the number of songs
     * @param totalRuntimeInMinutes is the total runtime of the music media library in minutes
     * @param year                  is the year
     * @param sizeInInches          is the size of the record in inches
     * @param revolutionsPerMinute  is the rpm that the record spins
     */
    public Record(final String artist,
                  final String songTitle,
                  final int numOfSongs,
                  final int totalRuntimeInMinutes,
                  final int year,
                  final int sizeInInches,
                  final double revolutionsPerMinute)
    {
        super(artist, songTitle, numOfSongs, totalRuntimeInMinutes, year);
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
                revolutionsPerMinute != RPM3)
        {
            throw new IllegalArgumentException("Invalid RPM");
        }
    }

    /**
     * @param sizeInInches is the size of the record in inches
     */
    private void checkSizeInInches(final int sizeInInches)
    {
        if(sizeInInches != SEVEN_INCH_RECORD &&
                sizeInInches != TEN_INCH_RECORD &&
                sizeInInches != TWELVE_INCH_RECORD)
        {
            throw new IllegalArgumentException("Invalid record size");
        }
    }

    @Override
    public void playSection()
    {
        System.out.println("Thank you for using our Music Library." + "\nYou selected the record "
                                   + getSongTitle() + " by " + getArtist()
                                   + ". \nThis is a " + sizeInInches + " inch record from "
                                   + getYear() + ", playing at " + revolutionsPerMinute
                                   + " rpm.\n");
    }

    @Override
    public String toString()
    {
        return "Record [size=" + this.sizeInInches + ", rpm=" + this.revolutionsPerMinute
                + ", " + "toString()=" + super.toString() + "]";
    }
}
