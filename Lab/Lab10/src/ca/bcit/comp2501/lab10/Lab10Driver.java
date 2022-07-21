package ca.bcit.comp2501.lab10;

/**
 * The Lab10Driver class is the driver class for lab 10.
 * @author Chris Wu & Jack Luo
 * @version 1.0
 */
public class Lab10Driver
{
    /**
     * The entry point of the program
     * @param args are the command line arguments (unused)
     */
    public static void main(final String[] args)
    {
        MusicMedia record;
        MusicMedia audioFile;
        MusicMedia cd;
        MusicLibrary library;

        record = new Record("The Beatles", "Hey Jude", 1, 7, 1968, 7, 45.0);

        cd = new CompactDisc("Neil Young & Crazy Horse", "Everybody Knows This Is Nowhere", 4, 40, 1969, false, false);

        audioFile = new AudioFile("Donnie Iris and the Cruisers", "Ah Leah!", 1, 4, 1980, "wav");


        library = new MusicLibrary();

        library.addMedia(record);
        library.addMedia(cd);
        library.addMedia(audioFile);

        library.displayLibrary();

        library.playTitle("Hey Jude");
        library.playTitle("Everybody Knows This Is Nowhere");
        library.playTitle("Ah Leah!");
    }
}
