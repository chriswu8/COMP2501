package ca.bcit.comp2501.lab2b;

/**
 * The Date container class
 * @author Chris Wu
 * @version 2.0
 */
public class Date {
    String year;
    String month;
    String day;

    /**
     * the constructor: code that is called automatically each time a Date object is made
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public Date(final String year, final String month, final String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return a concatenated String of year, month, and day
     */
    public String getYyMmDd() {
        return year + "-" + month + "-" + day;
    }

    /**
     * @return the year as a String
     */
    public String getYear() {
        return year;
    }

    /**
     * @return the month as a String
     */
    public String getMonth() {
        return month;
    }

    /**
     * @return the day as a String
     */
    public String getDay() {
        return day;
    }

    /**
     * @return the String version of the date
     */
    public String getDate() {
        return "" + month + " " + day + ", " + year;
    }

    /**
     * @param year: the year (as a String) that is to be set
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * @param month: the month (as a String) that is to be set
     */
    public void setMonth(final String month) {
        this.month = month;
    }

    /**
     * @param day: the day (as a String) that is to be set
     */
    public void setDay(final String day) {
        this.day = day;
    }

}
