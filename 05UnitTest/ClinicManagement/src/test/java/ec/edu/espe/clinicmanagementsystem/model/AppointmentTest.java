package ec.edu.espe.clinicmanagementsystem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Pruebas Unitarias para la clase Appointment.
 *
 * @author Gemini
 */
public class AppointmentTest {

    private Date initialDate;
    private Date newDate;

    @BeforeEach
    public void setUp() {
        initialDate = new Date(10, 11, 2025, 9, 0); 
        newDate = new Date(12, 11, 2025, 14, 30);   
    }

    @Test
    public void testEmptyConstructor() {
        System.out.println("testEmptyConstructor");
        Appointment instance = new Appointment();
        assertEquals(0, instance.getAppointmentId());
        assertNull(instance.getDate());
        assertNull(instance.getStatus());
        fail("The test case is a prototype.");
    }


    @Test
    public void testFullConstructor() {
        System.out.println("testFullConstructor");
        int appId = 5;
        int patId = 10;
        int docId = 1;

        Appointment instance = new Appointment(appId, initialDate, patId, docId);

        assertEquals(appId, instance.getAppointmentId());
        assertEquals(initialDate, instance.getDate());
        assertEquals(patId, instance.getPatientId());
        assertEquals(docId, instance.getDoctorId());
        assertEquals("Agendado", instance.getStatus(), "El estado inicial debe ser 'Agendado'.");
    }

 
    @Test
    public void testSetAndGetAppointmentId() {
        System.out.println("testSetAndGetAppointmentId");
        Appointment instance = new Appointment();
        int expectedId = 100;
        instance.setAppointmentId(expectedId);
        assertEquals(expectedId, instance.getAppointmentId());
    }


    @Test
    public void testSetAndGetDate() {
        System.out.println("testSetAndGetDate");
        Appointment instance = new Appointment();
        instance.setDate(newDate);
        assertEquals(newDate, instance.getDate());
        fail("The test case is a prototype.");
    }


    @Test
    public void testSetAndGetStatus() {
        System.out.println("testSetAndGetStatus");
        Appointment instance = new Appointment();
        String expectedStatus = "Pagada";
        instance.setStatus(expectedStatus);
        assertEquals(expectedStatus, instance.getStatus());
    }


    @Test
    public void testReschedule() {
        System.out.println("testReschedule");
        Appointment instance = new Appointment(1, initialDate, 10, 1);
        
        instance.reschedule(newDate);

        assertEquals(newDate, instance.getDate(), "La fecha debe ser actualizada.");
        assertEquals("Agendada", instance.getStatus(), "El estado debe ser 'Agendada' después de reagendar.");
        fail("The test case is a prototype.");
    }

    @Test
    public void testCancel() {
        System.out.println("testCancel");
        Appointment instance = new Appointment(1, initialDate, 10, 1);
        
        instance.cancel();

        assertEquals("Cancelada", instance.getStatus(), "El estado debe ser 'Cancelada'.");
    }

    @Test
    public void testMarkCompleted() {
        System.out.println("testMarkCompleted");
        Appointment instance = new Appointment(1, initialDate, 10, 1);
        
        instance.markCompleted();

        assertEquals("Completeda", instance.getStatus(), "El estado debe ser 'Completeda'.");
        fail("The test case is a prototype.");
    }


    @Test
    public void testToStringOutput() {
        System.out.println("testToStringOutput");
        Appointment instance = new Appointment(99, initialDate, 20, 2);
        
        String expectedStart = "-------------------------\nCITA(99)\nFecha: " + initialDate.toString();
        
        assertTrue(instance.toString().startsWith(expectedStart), "El formato de toString debe comenzar correctamente.");
        assertTrue(instance.toString().contains("ID del paciente: 20"), "El toString debe contener el ID del paciente.");
    }
}