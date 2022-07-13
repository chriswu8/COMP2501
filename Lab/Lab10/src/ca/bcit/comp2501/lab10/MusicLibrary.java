package ca.bcit.comp2501.lab10;

import java.util.List;
import java.util.ArrayList;
/**
 * The MusicLibrary class models a music media library.
 * @author Chris Wu
 * @version 1.0
 */
public class MusicLibrary
{
    private List<MusicMedia> list;

    /**
     * The MusicLibrary constructor
     */
    public MusicLibrary()
    {
        list = new ArrayList<>();
    }

    public void addMedia(final MusicMedia media)
    {
        list.add(media);
    }


    public void displayLibrary()
    {
        for(MusicMedia m : list)
        {
            if(m != null)
            {
                System.out.println(m);
            }
        }
    }

    public void playTitle(String title)
    {

    }

}
