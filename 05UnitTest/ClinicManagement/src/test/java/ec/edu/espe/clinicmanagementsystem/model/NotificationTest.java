
package ec.edu.espe.clinicmanagementsystem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Windows
 */
public class NotificationTest {
    
    public NotificationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMessage method, of class Notification.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Notification instance = new Notification();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMessage method, of class Notification.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Notification instance = new Notification();
        instance.setMessage(message);

    }

    /**
     * Test of getDate method, of class Notification.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Notification instance = new Notification();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Notification.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Notification instance = new Notification();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class Notification.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        Notification instance = new Notification();
        instance.send();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Notification.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Notification instance = new Notification();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
