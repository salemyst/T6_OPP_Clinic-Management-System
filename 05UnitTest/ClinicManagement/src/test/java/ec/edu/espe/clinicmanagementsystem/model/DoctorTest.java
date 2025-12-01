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
public class DoctorTest {

    public DoctorTest() {
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
    public void testSetDoctorId() {
        System.out.println("setDoctorId");
        Doctor instance = new Doctor();
        instance.setDoctorId(5);
        assertEquals(5, instance.getDoctorId());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFullName() {
        System.out.println("setFullName");
        Doctor instance = new Doctor();
        instance.setFullName("Dr. House");
        assertEquals("Dr. House", instance.getFullName());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSpecialty() {
        System.out.println("setSpecialty");
        Doctor instance = new Doctor();
        instance.setSpecialty("Diagnostico");
        assertEquals("Diagnostico", instance.getSpecialty());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        Doctor instance = new Doctor();
        instance.setPhone("099999");
        assertEquals("099999", instance.getPhone());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        Doctor instance = new Doctor();
        instance.setEmail("house@hospital.com");
        assertEquals("house@hospital.com", instance.getEmail());
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        Doctor instance = new Doctor();
        instance.setUsername("admin");
        assertEquals("admin", instance.getUsername());
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        Doctor instance = new Doctor();
        instance.setPassword("1234");
        assertEquals("1234", instance.getPassword());
    }

    @Test
    public void testViewAppointments() {
        System.out.println("viewAppointments");
        Doctor instance = new Doctor();
        try { instance.viewAppointments(null); 
        } 
        catch(Exception e){
        }
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateMedicalHistory() {
        System.out.println("updateMedicalHistory");
        Doctor instance = new Doctor();
        try { instance.updateMedicalHistory(null, new Patient(), new MedicalHistory()); 
        } 
        catch(Exception e){
        }
        fail("The test case is a prototype.");
    }
    

    @Test
    public void testCreatePrescription() {
        System.out.println("createPrescription");
        Doctor instance = new Doctor();
        Patient p = new Patient();
        p.setPatientId(1);
        Prescription res = instance.createPrescription(p, 1, "Med", "Dose", new Date());
        assertNotNull(res);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDiagnose() {
        System.out.println("diagnose");
        Doctor instance = new Doctor();
        instance.diagnose(new Patient(), "Sano");
        fail("The test case is a prototype.");
    }
    @Test
    public void testCreatePrescriptionCheckDefaultInstructions() {
        System.out.println("createPrescription (Check Default Instructions)");
        Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setFullName("Paciente Test");
        Doctor instance = new Doctor();
        instance.setFullName("Dr. Test");
        Prescription result = instance.createPrescription(patient, 100, "Paracetamol", "500mg", new Date());
        assertEquals("Tomar cada 8 horas", result.getInstructions());
        
        fail("The test case is a prototype.");
    }
}