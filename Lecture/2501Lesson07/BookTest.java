import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest
{
    Book b1;
    Book b2;
    @BeforeEach
    void setUp()
    {
        b1 = new Book("harry potter", "rowling", 1996, 700);
        b2 = new Book("it", "king", 1986, 1400);
    }

    @AfterEach
    void tearDown()
    {
        b1 = null;
        b2 = null;
    }

    @Test
    void getTitle()
    {
        assertEquals("Harry potter", b1.getTitle());
        assertEquals("It", b2.getTitle());
    }
}