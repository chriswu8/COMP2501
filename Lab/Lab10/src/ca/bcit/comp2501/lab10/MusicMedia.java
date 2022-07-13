package ca.bcit.comp2501.lab10;

/**
 * The MusicMedia class models a music media.
 * @author Chris Wu
 * @version 1.0
 */
public class MusicMedia
{
    private              int    numOfSongs;
    private              int    totalRuntime;
    private final        String artist;
    private final        String songTitle;
    private final        int    year;
    private static final int    FIRST_GREGORIAN_YEAR = 1582;
    private static final int    CURRENT_YEAR         = 2022;
    private static final int    INITIAL_RUNTIME      = 0;
    private static final int    INITIAL_NUM_SONG     = 0;


    /**
     * The MusicMedia constructor
     * @param artist       is the musical artist
     * @param songTitle    is the song title
     * @param numOfSongs   is the number of songs
     * @param totalRuntime is the total runtime of the music media library
     * @param year         is the year
     */
    public MusicMedia(final String artist,
                      final String songTitle,
                      final int numOfSongs,
                      final int totalRuntime,
                      final int year)
    {
        checkParameters(artist, songTitle, numOfSongs, totalRuntime, year);
        this.artist = artist;
        this.songTitle = songTitle;
        this.numOfSongs = numOfSongs;
        this.totalRuntime = totalRuntime;
        this.year = year;
    }

    /**
     * @param artist       is the musical artist
     * @param songTitle    is the song title
     * @param numOfSongs   is the number of songs
     * @param totalRuntime is the total runtime of the music media library
     * @param year         is the year
     */
    private void checkParameters(final String artist,
                                 final String songTitle,
                                 final int numOfSongs,
                                 final int totalRuntime,
                                 final int year)
    {
        checkArtist(artist);
        checksSongTitle(songTitle);
        checkNumOfSongs(numOfSongs);
        checkTotalRuntime(totalRuntime);
        checkYear(year);
    }

    /**
     * @param year is the year
     */
    private void checkYear(final int year)
    {
        if(year < FIRST_GREGORIAN_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    /**
     * @param totalRuntime is the total runtime
     */
    private void checkTotalRuntime(final int totalRuntime)
    {
        if(totalRuntime < INITIAL_RUNTIME)
        {
            throw new IllegalArgumentException("Invalid total runtime");
        }
    }

    /**
     * @param numOfSongs is the number of songs
     */
    private void checkNumOfSongs(final int numOfSongs)
    {
        if(numOfSongs < INITIAL_NUM_SONG)
        {
            throw new IllegalArgumentException("Invalid number of songs");
        }
    }

    /**
     * @param songTitle is the song title
     */
    private void checksSongTitle(final String songTitle)
    {
        if(songTitle == null || songTitle.isBlank())
        {
            throw new IllegalArgumentException("Invalid song title");
        }
    }

    /**
     * @param artist is the musical artist
     */
    private void checkArtist(final String artist)
    {
        if(artist == null || artist.isBlank())
        {
            throw new IllegalArgumentException("Invalid artist");
        }
    }

    /**
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * @return the song title
     */
    public String getSongTitle()
    {
        return songTitle;
    }

    /**
     * @return the number of songs
     */
    public int getNumOfSongs()
    {
        return numOfSongs;
    }

    /**
     * @return the total runtime
     */
    public int getTotalRuntime()
    {
        return totalRuntime;
    }

    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Displays a thank-you message
     */
    public void playSection()
    {
        System.out.println("Thank you for using our Music Library.");
    }

    @Override
    public String toString()
    {
        return "Artist: " + getArtist()
                + "Song title: " + getSongTitle()
                + "Number of Songs: " + getNumOfSongs()
                + "Total runtime: " + getTotalRuntime()
                + "Year: " + getYear();
    }
}
