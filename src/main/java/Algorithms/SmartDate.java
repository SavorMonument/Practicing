package Algorithms;

import edu.princeton.cs.algs4.Date;

import java.util.Calendar;

public class SmartDate extends Date {

    private static final int FEBRUARY = 2;

    public SmartDate(int month, int day, int year) {
        super(month, day, year);

        if (!isValidDate(month, day, year))
            throw new IllegalArgumentException("Invalid date");
    }

    public SmartDate(String date) {
        super(date);

        if (!isValidDate(date))
            throw new IllegalArgumentException("Invalid date");
    }

    private boolean isValidDate(String date){

        String[] tokens = date.split(".");

        int month, day, year;

        try{
            month = Integer.parseInt(tokens[0]);
            day = Integer.parseInt(tokens[1]);
            year = Integer.parseInt(tokens[2]);

        } catch (NumberFormatException e){
            return false;
        }

        return isValidDate(month, day, year);
    }

    private boolean isValidDate(int month, int day, int year) {

        if (!isYearValid(year))
            return false;

        if (month == FEBRUARY) {
            if (isLeapYear(year))
                if (day > 29)
                    return false;
            else
                if (day > 28)
                    return false;
        }

        return (year < 2018) && (year > 0) && month > 0 && month < 13 && day > 0;
    }

    private boolean isYearValid(int year) {

        return year > 0 && year <= Calendar.getInstance().get(Calendar.YEAR);
    }

    private boolean isLeapYear(int year){
        assert (year > 0) && (year <= 2018) : "Wrong year format";

        if (year % 4 != 0)
            return false;
        else
            if (year % 100 != 0)
                return true;
        else
            if (year % 400 != 0)
                return false;
        else
            return true;

    }

}
