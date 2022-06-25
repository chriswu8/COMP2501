package ca.bcit.comp2501.lab4.wutin;

/**
 * The IllegalNameException class is a checked exception class
 * @author Chris Wu and Kevin Tin
 * @version 1.0
 */
class IllegalNameException extends Exception
{
    IllegalNameException(final String message)
    {
        super(message);
    }
}