package ca.bcit.comp2501.lab4.wutin;

/**
 * The Novel class models a novel
 * @author Chris Wu and Kevin Tin
 * @version 2.0
 */
public class Novel
{
    private final String title;
    private final String author;
    private final String yearPublished;

    /**
     * The constructor
     *
     * @param title         is the title of the novel
     * @param author        is the author of the novel
     * @param yearPublished is the publication year of the novel
     */
    public Novel(
            final String title,
            final String author,
            final String yearPublished)
    {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /**
     * @return the title of the book
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @return the author of the book
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @return the publication year of the book
     */
    public String getYearPublished()
    {
        return yearPublished;
    }

}
