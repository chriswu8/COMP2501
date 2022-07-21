package ca.bcit.comp2501.lab10;

/**
 * The CompactDisc class models a CD
 * @author Chris Wu & Jack Luo
 * @version 1.0
 */
public class CompactDisc extends MusicMedia
{
    private final boolean bonusTracks;
    private final boolean digipak;

    /**
     * The CompactDisc constructor
     * @param artist                is the musical artist
     * @param songTitle             is the song title
     * @param numOfSongs            is the number of songs
     * @param totalRuntimeInMinutes is the total runtime of the music media library in minutes
     * @param year                  is the year
     * @param bonusTracks           is whether this CD has bonus tracks
     * @param digipak               is whether this CD comes with a digipak
     */
    public CompactDisc(final String artist,
                       final String songTitle,
                       final int numOfSongs,
                       final int totalRuntimeInMinutes,
                       final int year,
                       final boolean bonusTracks,
                       final boolean digipak)
    {
        super(artist, songTitle, numOfSongs, totalRuntimeInMinutes, year);
        this.bonusTracks = bonusTracks;
        this.digipak = digipak;
    }

    @Override
    public void playSection()
    {
        System.out.println("Thank you for using our Music Library." + "\nYou selected the CD "
                                   + getSongTitle() + " by " + getArtist() + ". \nThis is " +
                                   "a Compact Disc from the year " + getYear());
    }

    @Override
    public String toString()
    {
        return "CompactDisc [bonusTracks=" + bonusTracks
                + ", digipak=" + digipak
                + ", toString()=" + super.toString() + "]";
    }
}
