package ca.bcit.comp2501.lab2b;

/**
 * @author Chris Wu
 * @version 1.0
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
    public Date(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return a concatenated String of year, month, and day
     */
    public String getYyMmDd() {
        return "" + year + "-" + month + "-" + day;
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
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @param month: the month (as a String) that is to be set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @param day: the day (as a String) that is to be set
     */
    public void setDay(String day) {
        this.day = day;
    }

    // the entry point of the program
    public static void main(String[] args) {}

}
