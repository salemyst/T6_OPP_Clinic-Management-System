
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
public class PrescriptionTest {
    
    public PrescriptionTest() {
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
     * Test of getPrescriptionId method, of class Prescription.
     */
    @Test
    public void testGetPrescriptionId() {
        System.out.println("getPrescriptionId");
        Prescription instance = new Prescription();
        int expResult = 0;
        int result = instance.getPrescriptionId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrescriptionId method, of class Prescription.
     */
    @Test
    public void testSetPrescriptionId() {
        System.out.println("setPrescriptionId");
        int prescriptionId = 0;
        Prescription instance = new Prescription();
        instance.setPrescriptionId(prescriptionId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientId method, of class Prescription.
     */
    @Test
    public void testGetPatientId() {
        System.out.println("getPatientId");
        Prescription instance = new Prescription();
        int expResult = 0;
        int result = instance.getPatientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatientId method, of class Prescription.
     */
    @Test
    public void testSetPatientId() {
        System.out.println("setPatientId");
        int patientId = 0;
        Prescription instance = new Prescription();
        instance.setPatientId(patientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedication method, of class Prescription.
     */
    @Test
    public void testGetMedication() {
        System.out.println("getMedication");
        Prescription instance = new Prescription();
        String expResult = "";
        String result = instance.getMedication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedication method, of class Prescription.
     */
    @Test
    public void testSetMedication() {
        System.out.println("setMedication");
        String medication = "";
        Prescription instance = new Prescription();
        instance.setMedication(medication);

    }

    /**
     * Test of getDosage method, of class Prescription.
     */
    @Test
    public void testGetDosage() {
        System.out.println("getDosage");
        Prescription instance = new Prescription();
        String expResult = "";
        String result = instance.getDosage();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDosage method, of class Prescription.
     */
    @Test
    public void testSetDosage() {
        System.out.println("setDosage");
        String dosage = "";
        Prescription instance = new Prescription();
        instance.setDosage(dosage);

    }

    /**
     * Test of getInstructions method, of class Prescription.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");
        Prescription instance = new Prescription();
        String expResult = "";
        String result = instance.getInstructions();
        assertEquals(expResult, result);
;
    }

    /**
     * Test of setInstructions method, of class Prescription.
     */
    @Test
    public void testSetInstructions() {
        System.out.println("setInstructions");
        String instructions = "";
        Prescription instance = new Prescription();
        instance.setInstructions(instructions);

    }

    /**
     * Test of getDate method, of class Prescription.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Prescription instance = new Prescription();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDate method, of class Prescription.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Prescription instance = new Prescription();
        instance.setDate(date);

    }

    /**
     * Test of toString method, of class Prescription.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Prescription instance = new Prescription();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of printPrescription method, of class Prescription.
     */
    @Test
    public void testPrintPrescription() {
        System.out.println("printPrescription");
        Prescription instance = new Prescription();
        instance.printPrescription();

    }
    
}
