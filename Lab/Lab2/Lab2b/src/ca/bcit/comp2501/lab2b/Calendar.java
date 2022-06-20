package ca.bcit.comp2501.lab2b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * The Calendar container class
 *
 * @author Chris Wu
 * @version 1.0
 */
public class Calendar
{
    private final ArrayList<Integer> years;
    private final String[] months;
    private final ArrayList<Integer> days;
    private final HashMap<Integer, Date> dates;
    private static final int NUMBER_OF_MONTHS = 12;
    private static final int NUMBER_OF_DAYS = 30;
    private int currentDay;
    private Integer theCurrentDay;
    private Date date;

    /**
     * The constructor
     */
    public Calendar()
    {
        years = new ArrayList<>();
        days = new ArrayList<>();
        months = new String[NUMBER_OF_MONTHS];
        dates = new HashMap<>();
        currentDay = 0;

        populateYears();
        populateMonths();
        populateDays();

        for (Integer year : years)
        {
            if (year != null)
            {
                for (int i = 0; i < NUMBER_OF_MONTHS; i++)
                {
                    if (months[i] != null)
                    {
                        Iterator<Integer> it = days.iterator();
                        while (it.hasNext())
                        {
                            Integer day = it.next();
                            if (day != null)
                            {
                                date = new Date(year.toString(), months[i], day.toString());
                                storeDate(dates, date);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Populates the years ArrayList with years from 1910 to 2025
     */
    public void populateYears()
    {
        for (int year = 1910; year <= 2025; year++)
        {
            Integer theYear = year;
            years.add(theYear);
        }
    }

    /**
     * Populates the months String array with all months of the year
     */
    public void populateMonths()
    {
        for (int month = 0; month < NUMBER_OF_MONTHS; month++)
        {
            switch (month)
            {
                case 0 -> months[month] = "January";
                case 1 -> months[month] = "February";
                case 2 -> months[month] = "March";
                case 3 -> months[month] = "April";
                case 4 -> months[month] = "May";
                case 5 -> months[month] = "June";
                case 6 -> months[month] = "July";
                case 7 -> months[month] = "August";
                case 8 -> months[month] = "September";
                case 9 -> months[month] = "October";
                case 10 -> months[month] = "November";
                case 11 -> months[month] = "December";
                default ->
                {
                }
            }
        }
    }

    /**
     * Populates the days ArrayList from day 0 to day 30
     */
    public void populateDays()
    {
        for (int day = 0; day < NUMBER_OF_DAYS; day++)
        {
            Integer theDay = day + 1;
            days.add(theDay);
        }
    }

    /**
     * @param dates is the collection of dates
     * @param date  is the date to be added to the dates collection
     */
    public void storeDate(final HashMap dates, final Date date)
    {
        currentDay++;
        theCurrentDay = currentDay;
        dates.put(theCurrentDay, date);
    }

    /**
     * Prints each Date in the calendar
     */
    public void printCalendar()
    {
        Set<Integer> keys;
        keys = dates.keySet();

        for (Integer key : keys)
        {
            System.out.println("" + key + ": " + dates.get(key).getDate());
        }
    }
}
