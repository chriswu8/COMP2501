package ca.bcit.bookstore;

/**
 * @author jason wilder
 * @version 1.0
 */
class Book
{
    private final String  title;
    private final int     numberOfPages;
    private final boolean fiction;
    private final double  weightKg;

    Book(final String  title,
         final int     howManyPages,
         final boolean fiction,
         final double  kilograms)
    {
        this.title         = title;
        this.numberOfPages = howManyPages;
        this.fiction       = fiction;
        this.weightKg      = kilograms;

        // this.title = "hi";
    }

    public static void main(final String[] args)
    {
        Book b1 = new Book("harry potter", 700, true, 1.1);
        Book b2 = new Book("it", 1100, true, 2.23);
    }
}
