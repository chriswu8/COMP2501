package ca.bcit.comp2501.lab10;

/**
 * The Lab10Driver class is the driver class for lab 10.
 * @author Chris Wu
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

        record = new Record("The Beatles", "Hey Jude", 1, 7, 1968, 7, 45.0);

        audioFile = new AudioFile("Donnie Iris and the Cruisers", "Ah Leah!", 1, 4, 1980, "wav");

        cd = new CompactDisc("Neil Young & Crazy Horse", "Everybody Knows This Is Nowhere", 4, 40
                , 1969, false, false);


        System.out.println(record);
        System.out.println(cd);
        System.out.println(audioFile + "\n");
        record.playSection();
        cd.playSection();
        audioFile.playSection();
    }
}
