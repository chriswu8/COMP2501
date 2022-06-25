package ca.bcit.comp2501.lab4.wutin;

/**
 * The IllegalNovelPropertyException class is an unchecked exception class
 * @author Chris Wu and Kevin Tin
 * @version 1.0
 */
public class IllegalNovelPropertyException extends RuntimeException
{
    IllegalNovelPropertyException(final String message)
    {
        super(message);
    }
}
