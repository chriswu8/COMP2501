package ca.bcit.comp2501.lab10;

/**
 * The AudioFile class models an audio file
 * @author Chris Wu
 * @version 1.0
 */
public class AudioFile extends MusicMedia
{
    private final String fileType;

    /**
     * The AudioFile constructor
     * @param artist                is the musical artist
     * @param songTitle             is the song title
     * @param numOfSongs            is the number of songs
     * @param totalRuntimeInMinutes is the total runtime of the music media library in minutes
     * @param year                  is the year
     * @param fileType              is the file type
     */
    public AudioFile(final String artist,
                     final String songTitle,
                     final int numOfSongs,
                     final int totalRuntimeInMinutes,
                     final int year,
                     final String fileType)
    {
        super(artist, songTitle, numOfSongs, totalRuntimeInMinutes, year);
        this.fileType = fileType;
    }

    @Override
    public void playSection()
    {
        System.out.println("\nThank you for using our Music Library." + "\nYou selected the Audio " +
                                   "File " + getSongTitle() + " by " + getArtist() + ".\nThis is " +
                                   "in " + fileType + " format, from the year " + getYear());
    }

    @Override
    public String toString()
    {
        return "AudioFile [fileType=" + fileType + ", toString()=" + super.toString() + "]";
    }
}
