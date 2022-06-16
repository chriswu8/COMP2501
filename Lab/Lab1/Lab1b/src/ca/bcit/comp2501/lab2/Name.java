package ca.bcit.comp2501.lab2;

/**
 * @author Chris Wu and Mika Campbell Nishimura
 * @version 1.0
 */

public class Name {
    private String first;
    private String last;


    // the constructor
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /**
     *
     * @return the concatenated String of first and last (name)
     */
    public String getFullName() {
        return first + " " + last;
    }

    /**
     *
     * @return the capitalized first letters of first and last (name)
     */
    public String getInitials() {
        return first.toUpperCase().charAt(0) + "." + last.toUpperCase().charAt(0) + ".";
    }

    /**
     *
     * @return the first (name)
     */
    public String getFirst() {
        return first;
    }

    /**
     *
     * @return the last (name)
     */
    public String getLast() {
        return last;
    }

    /**
     *
     * @param first: the first (name) that is to be set
     */
    public void setFirst(final String first) {
        this.first = first;
    }

    /**
     *
     * @param last: the last (name) that is to be set
     */
    public void setLast(final String last) {
        this.last = last;
    }
}
