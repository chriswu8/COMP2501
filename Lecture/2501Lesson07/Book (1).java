public class Book
{
    private String title;

    public Book(String title, final String authorLastName, final int yearPublished, final int numPages)
    {
        title = title;
    }

    String getTitle()
    {
        return title.toUpperCase().charAt(0) + title.substring(1).toLowerCase();
    }

    public static void main(final String[] args)
    {
        Book b1 = new Book("it", "king", 1986, 1400);
        System.out.println(b1.getTitle());
    }
}
