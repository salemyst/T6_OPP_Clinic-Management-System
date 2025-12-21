
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
public class ReceptionistTest {
    
    public ReceptionistTest() {
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
     * Test of getReceptionistId method, of class Receptionist.
     */
    
    @Test
    public void testGetReceptionistId() {
        System.out.println("getReceptionistId");
        Receptionist instance = new Receptionist();
        int expResult = 1;
        int result = instance.getReceptionistId();
        assertEquals(expResult, result);
        fail();
    }


    @Test
    public void testSetReceptionistId() {
        System.out.println("setReceptionistId");
        int receptionistId = 0;
        Receptionist instance = new Receptionist();
        instance.setReceptionistId(receptionistId);

        fail();
    }


    @Test
    public void testGetName() {
        System.out.println("getName");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);

        fail();
    }


    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Receptionist instance = new Receptionist();
        instance.setName(name);

    }


    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);

    }


    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Receptionist instance = new Receptionist();
        instance.setPhone(phone);

    }


    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }


    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Receptionist instance = new Receptionist();
        instance.setEmail(email);
    }


    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);

    }

   
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Receptionist instance = new Receptionist();
        instance.setUsername(username);

    }

 
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);

    }

 
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Receptionist instance = new Receptionist();
        instance.setPassword(password);

    }

    /**
     * Test of createAppointment method, of class Receptionist.
     */
    @Test
    public void testCreateAppointment() {
        System.out.println("createAppointment");
        Clinic clinic = null;
        int appId = 0;
        Date appDate = null;
        int patId = 0;
        int docId = 0;
        Receptionist instance = new Receptionist();
        Appointment expResult = null;
        Appointment result = instance.createAppointment(clinic, appId, appDate, patId, docId);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerPatient method, of class Receptionist.
     */
    @Test
    public void testRegisterPatient() {
        System.out.println("registerPatient");
        Clinic clinic = null;
        int patientId = 0;
        String fullName = "";
        String gender = "";
        String phone = "";
        String address = "";
        Receptionist instance = new Receptionist();
        Patient expResult = null;
        Patient result = instance.registerPatient(clinic, patientId, fullName, gender, phone, address);
        assertEquals(expResult, result);

    }

    /**
     * Test of updatePatientInfo method, of class Receptionist.
     */
    @Test
    public void testUpdatePatientInfo() {
        System.out.println("updatePatientInfo");
        Clinic clinic = null;
        Patient patient = null;
        String newPhone = "";
        String newAddress = "";
        Receptionist instance = new Receptionist();
        instance.updatePatientInfo(clinic, patient, newPhone, newAddress);
    }

    /**
     * Test of toString method, of class Receptionist.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Receptionist instance = new Receptionist();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
