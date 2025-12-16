
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Date;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class DateController {

    public void setDate(Date date, int day, int month, int year) {
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
    }


    public void setTime(Date date, int hour, int minute) {
        date.setHour(hour);
        date.setMinute(minute);
    }


     
    public String getDatePart(Date date) {
        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonth(), date.getDay());
    }


    public String getTimePart(Date date) {
        return String.format("%02d:%02d", date.getHour(), date.getMinute());
    }


    public boolean isBefore(Date date1, Date date2) {
        if (date1.getYear() != date2.getYear()) return date1.getYear() < date2.getYear();
        if (date1.getMonth() != date2.getMonth()) return date1.getMonth() < date2.getMonth();
        if (date1.getDay() != date2.getDay()) return date1.getDay() < date2.getDay();
        if (date1.getHour() != date2.getHour()) return date1.getHour() < date2.getHour();
        return date1.getMinute() < date2.getMinute();
    }
}
