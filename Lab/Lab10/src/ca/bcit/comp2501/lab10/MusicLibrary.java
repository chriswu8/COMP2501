package ca.bcit.comp2501.lab10;

import java.util.List;
import java.util.ArrayList;

/**
 * The MusicLibrary class models a music media library.
 * @author Chris Wu & Jack Luo
 * @version 1.0
 */
public class MusicLibrary
{
    private final List<MusicMedia> list;

    /**
     * The MusicLibrary constructor
     */
    public MusicLibrary()
    {
        list = new ArrayList<>();
    }

    /**
     * @param media is a music media (Record/AudioFile/CompactDisc) to be added to the list
     */
    public void addMedia(final MusicMedia media)
    {
        if(media == null)
        {
            throw new IllegalArgumentException("Invalid subtype: cannot be null");
        }
        list.add(media);
    }

    /**
     * Iterates over the List, displaying the entire library using toString()
     */
    public void displayLibrary()
    {
        for(MusicMedia m : list)
        {
            if(m != null)
            {
                System.out.println(m);
            }
            else
            {
                throw new IllegalArgumentException("Invalid list item: null");
            }
        }
        System.out.println();
    }

    /**
     * Validates the parameter appropriately, and then search the list for the title.
     * If the title found, the playSelection() method will be called.
     * @param title is the title to be searched for in the list
     */
    public void playTitle(final String title)
    {
        if(title != null && !title.isBlank())
        {
            for(MusicMedia m : list)
            {
                if(title.equals(m.getSongTitle()))
                {
                      m.playSection();
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Invalid list title: null / is blank");
        }
    }
}
