
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Date {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public Date() {
    }

    public Date(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        // Formato: YYYY-MM-DD @ HH:MM
        return String.format("%04d-%02d-%02d @ %02d:%02d", year, month, day, hour, minute);
    }
}