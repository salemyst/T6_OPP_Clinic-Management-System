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
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class BillingTest {

 
    private Date testDate;
    private final double DELTA = 0.001; 

    public BillingTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
 
        testDate = new Date(15, 12, 2025, 10, 30);
    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testEmptyConstructor() {
        System.out.println("testEmptyConstructor");
        Billing instance = new Billing();
        assertEquals(0, instance.getBillId());
        assertEquals(0.0, instance.getAmount(), DELTA);
        assertNull(instance.getDate());
        assertNull(instance.getStatus());
        assertEquals(0, instance.getPatientId());
    }

    
    @Test
    public void testFullConstructor() {
        System.out.println("testFullConstructor");
        int expectedBillId = 101;
        double expectedAmount = 75.50;
        String expectedStatus = "Pending";
        int expectedPatientId = 5;

        Billing instance = new Billing(expectedBillId, expectedAmount, testDate, expectedStatus, expectedPatientId);

        assertEquals(expectedBillId, instance.getBillId());
        assertEquals(expectedAmount, instance.getAmount(), DELTA);
        assertEquals(testDate, instance.getDate());
        assertEquals(expectedStatus, instance.getStatus());
        assertEquals(expectedPatientId, instance.getPatientId());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAndGetBillId() {
        System.out.println("setBillId");
        Billing instance = new Billing();
        instance.setBillId(200);
        assertEquals(200, instance.getBillId());
        fail("The test case is a prototype.");
    }
    @Test
    public void testSetStatusNull() {
        System.out.println("setStatusNull (Error Potencial)");
        Billing instance = new Billing(1, 1.0, testDate, "Pending", 1);
        instance.setStatus(null);
        
        assertDoesNotThrow(() -> instance.toString(), 
                           "Falla: toString() debería ser robusto a status=null.");
        
        assertNull(instance.getStatus(), 
                   "Falla: Se permite establecer el status como null.");
    }
    @Test
    public void testSetAmountExtremeLarge() {
        System.out.println("setAmountExtremeLarge (Prueba de Estrés)");
        Billing instance = new Billing();
        double largeAmount = Double.MAX_VALUE / 1000; 
        
        instance.setAmount(largeAmount);
        
        assertEquals(largeAmount, instance.getAmount(), DELTA, 
                     "Falla: El valor doble puede haber perdido precisión con un número grande.");
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSetAndGetAmount() {
        System.out.println("setAmount");
        Billing instance = new Billing();
        instance.setAmount(120.99);
        assertEquals(120.99, instance.getAmount(), DELTA);

    }

    @Test
    public void testSetAndGetDate() {
        System.out.println("setDate");
        Billing instance = new Billing();
        Date newDate = new Date(1, 1, 2026, 1, 1);
        instance.setDate(newDate);
        assertEquals(newDate, instance.getDate());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAndGetStatus() {
        System.out.println("setStatus");
        Billing instance = new Billing();
        instance.setStatus("Paid");
        assertEquals("Paid", instance.getStatus());
    }

    @Test
    public void testSetAndGetPatientId() {
        System.out.println("setPatientId");
        Billing instance = new Billing();
        instance.setPatientId(88);
        assertEquals(88, instance.getPatientId());
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testGenerateBillSetsStatusToPending() {
        System.out.println("generateBill");
        Billing instance = new Billing(1, 50.0, testDate, "Draft", 10);
        
        instance.generateBill();
        
        assertEquals("Pending", instance.getStatus(), 
                     "generateBill debe establecer el estado a 'Pending'.");
    }

    @Test
    public void testUpdatePaymentToPaid() {
        System.out.println("updatePaymentToPaid");
        Billing instance = new Billing(2, 100.0, testDate, "Pending", 10);
        String newStatus = "Paid";
        
        instance.updatePayment(newStatus);
        
        assertEquals(newStatus, instance.getStatus(), 
                     "updatePayment debe actualizar el estado a 'Paid'.");
    }

    @Test
    public void testUpdatePaymentToCancelled() {
        System.out.println("updatePaymentToCancelled");
        Billing instance = new Billing(3, 20.0, testDate, "Pending", 10);
        String newStatus = "Cancelled";
        
        instance.updatePayment(newStatus);
        
        assertEquals(newStatus, instance.getStatus(), 
                     "updatePayment debe permitir cualquier estado válido.");
        fail("The test case is a prototype.");

    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Billing instance = new Billing(4, 33.33, testDate, "Pending", 10);
        String expected = "Billing{billId=4, amount=33.33, date=" + testDate.toString() + ", status=Pending}";
        
        assertEquals(expected, instance.toString(), "El formato de toString no coincide con el esperado.");
    }

    @Test
    public void testViewBillExecution() {
        Billing instance = new Billing(5, 55.0, testDate, "Paid", 10);
        assertDoesNotThrow(() -> instance.viewBill());
                fail("The test case is a prototype.");
    }

}