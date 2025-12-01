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
 * @author César Vargas, Paradigm, @ESPE
 */
public class PatientTest {

    public PatientTest() {
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

    @Test
    public void testSetPatientId() {
        System.out.println("setPatientId");
        int patientId = 10;
        Patient instance = new Patient();
        instance.setPatientId(patientId);
        assertEquals(patientId, instance.getPatientId());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFullNameValid() {
        System.out.println("setFullName Valid");
        String fullName = "Juan Perez";
        Patient instance = new Patient();
        instance.setFullName(fullName);
        assertEquals(fullName, instance.getFullName());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFullNameInvalid() {
        System.out.println("setFullName Invalid (Contains Numbers)");
        String fullName = "Juan123";
        Patient instance = new Patient();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setFullName(fullName);
        });
    }

    @Test
    public void testSetGenderValid() {
        System.out.println("setGender Valid");
        String gender = "Masculino";
        Patient instance = new Patient();
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSetGenderInvalid() {
        System.out.println("setGender Invalid (Special Characters)");
        String gender = "M@sculino";
        Patient instance = new Patient();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setGender(gender);
        });
    }

    @Test
    public void testSetPhoneValid() {
        System.out.println("setPhone Valid");
        String phone = "0991234567";
        Patient instance = new Patient();
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPhoneInvalidLength() {
        System.out.println("setPhone Invalid (Length)");
        String phone = "099"; 
        Patient instance = new Patient();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setPhone(phone);
        });
    }

    @Test
    public void testSetAddressValid() {
        System.out.println("setAddress Valid");
        String address = "Av. Amazonas 123";
        Patient instance = new Patient();
        instance.setAddress(address);
        assertEquals(address, instance.getAddress());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAddressInvalid() {
        System.out.println("setAddress Invalid (Empty)");
        String address = ""; 
        Patient instance = new Patient();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setAddress(address);
        });
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMedicalHistory() {
        System.out.println("setMedicalHistory");
        List<MedicalHistory> medicalHistory = new ArrayList<>();
        Patient instance = new Patient();
        instance.setMedicalHistory(medicalHistory);
        assertEquals(medicalHistory, instance.getMedicalHistory());
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddMedicalRecord() {
        System.out.println("addMedicalRecord");
        MedicalHistory record = new MedicalHistory();
        Patient instance = new Patient();
        instance.addMedicalRecord(record);
        assertFalse(instance.getMedicalHistory().isEmpty());
        fail("The test case is a prototype.");
    }

    @Test
    public void testRequestAppointment() {
        System.out.println("requestAppointment");
        Patient instance = new Patient();
        instance.setFullName("Test User"); // Setup necesario para evitar NPE en el print
        instance.requestAppointment();
        fail("The test case is a prototype.");
    }

    @Test
    public void testViewMedicalHistory() {
        System.out.println("viewMedicalHistory");
        Patient instance = new Patient();
        instance.setFullName("Test User");
        instance.viewMedicalHistory();
        fail("The test case is a prototype.");
    }

    @Test
    public void testPayBill() {
        System.out.println("payBill");
        Billing bill = new Billing();
        bill.setBillId(1);
        bill.setStatus("Pending");
        
        Patient instance = new Patient();
        instance.setFullName("Test User");
        
        instance.payBill(bill);
        
        assertEquals("Pagado", bill.getStatus());
        fail("The test case is a prototype.");
    }
}