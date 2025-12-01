package ec.edu.espe.clinicmanagementsystem.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */
public class ValidationTest {
    
    private final InputStream originalSystemIn = System.in;

    public ValidationTest() {
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
        System.setIn(originalSystemIn);
    }

    @Test
    public void testReadInt() {
        System.out.println("readInt");
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese un entero: ";
        int expResult = 5;
        
    }

    @Test
    public void testReadDouble() {
        System.out.println("readDouble");
        String input = "10.55\n"; 
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese un decimal: ";
        double expResult = 10.55;
        fail("The test case is a prototype.");
    }

    @Test
    public void testReadPositiveDouble() {
        System.out.println("readPositiveDouble");
        String input = "25.99\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese precio positivo: ";
        double expResult = 25.99;
        
    }

    @Test
    public void testReadString() {
        System.out.println("readString");
        String input = "Hola Mundo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese texto: ";
        String expResult = "Hola Mundo";
        
        fail("The test case is a prototype.");
    }

    @Test
    public void testReadIntRange() {
        System.out.println("readIntRange");
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese valor (1-10): ";
        int min = 1;
        int max = 10;
        int expResult = 5;
        
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testReadDate() {
        System.out.println("readDate");
        String input = "2025\n12\n31\n23\n59\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String title = "Ingrese Fecha de Prueba";
        
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testReadPositiveInt() {
        System.out.println("readPositiveInt");
        String input = "100\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        String prompt = "Ingrese ID positivo: ";
        int expResult = 100;
        
        fail("The test case is a prototype.");
    }
    @Test
    public void testReadStringTrimsSpaces() {
        System.out.println("readString (Trims Spaces)");
        String inputWithSpaces = "  Hola Mundo  \n";
        System.setIn(new java.io.ByteArrayInputStream(inputWithSpaces.getBytes()));
        String result = Validation.readString("Ingrese texto: ");
        assertEquals("Hola Mundo", result);
        fail("The test case is a prototype.");
    }
}