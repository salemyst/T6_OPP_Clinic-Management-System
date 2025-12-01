
package ec.edu.espe.clinicmanagementsystem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class DateTest {

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testEmptyConstructor() {
        System.out.println("testEmptyConstructor");
        Date instance = new Date();
        assertEquals(0, instance.getDay());
        assertEquals(0, instance.getMonth());
        assertEquals(0, instance.getYear());
        assertEquals(0, instance.getHour());
        assertEquals(0, instance.getMinute());
        fail("The test case is a prototype.");
    }


    @Test
    public void testFullConstructor() {
        System.out.println("testFullConstructor");
        int day = 31;
        int month = 12;
        int year = 2024;
        int hour = 23;
        int minute = 59;

        Date instance = new Date(day, month, year, hour, minute);

        assertEquals(day, instance.getDay());
        assertEquals(month, instance.getMonth());
        assertEquals(year, instance.getYear());
        assertEquals(hour, instance.getHour());
        assertEquals(minute, instance.getMinute());
    }


    @Test
    public void testSetAndGetDateComponents() {
        System.out.println("testSetAndGetDateComponents");
        Date instance = new Date();
        instance.setDay(1);
        instance.setMonth(1);
        instance.setYear(2000);

        assertEquals(1, instance.getDay());
        assertEquals(1, instance.getMonth());
        assertEquals(2000, instance.getYear());
    }


    @Test
    public void testSetAndGetTimeComponents() {
        System.out.println("testSetAndGetTimeComponents");
        Date instance = new Date();
        instance.setHour(13);
        instance.setMinute(45);

        assertEquals(13, instance.getHour());
        assertEquals(45, instance.getMinute());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDate() {
        System.out.println("testSetDate");
        Date instance = new Date();
        instance.setDate(15, 6, 2026);

        assertEquals(15, instance.getDay());
        assertEquals(6, instance.getMonth());
        assertEquals(2026, instance.getYear());
    }

    /**
     * 6. Prueba del método setTime().
     */
    @Test
    public void testSetTime() {
        System.out.println("testSetTime");
        Date instance = new Date();
        instance.setTime(8, 5);

        assertEquals(8, instance.getHour());
        assertEquals(5, instance.getMinute());
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDateFormatting() {
        System.out.println("testGetDateFormatting");
        Date instance = new Date(7, 5, 2023, 0, 0); 
        String expectedDate = "2023-05-07"; 
        
        assertEquals(expectedDate, instance.getDate(), 
                     "getDate() debe formatear a YYYY-MM-DD con padding.");
        fail("The test case is a prototype.");
    }


    @Test
    public void testGetTimeFormatting() {
        System.out.println("testGetTimeFormatting");
        Date instance = new Date(1, 1, 2020, 3, 8); 
        Object expectedTime = null;
        assertEquals(expectedTime, instance.getTime(), 
                     "getTime() debe formatear a HH:MM con padding.");
        fail("The test case is a prototype.");
    }


    @Test
    public void testToStringFormatting() {
        System.out.println("testToStringFormatting");
        Date instance = new Date(9, 10, 2024, 15, 2);
        String expectedString = "2024-10-09 @ 15:02"; // Formato YYYY-MM-DD @ HH:MM
        
        assertEquals(expectedString, instance.toString(), 
                     "toString() debe usar el formato combinado con padding.");
    }
    
    @Test
    public void testToStringExtremeLowValues() {
        System.out.println("testToStringExtremeLowValues");
        Date instance = new Date(1, 1, 2025, 0, 0);
        String expectedString = "2025-01-01 @ 00:00"; 
        
        assertEquals(expectedString, instance.toString(), 
                     "El formato debe manejar el padding de ceros correctamente.");
        fail("The test case is a prototype.");
    }
}