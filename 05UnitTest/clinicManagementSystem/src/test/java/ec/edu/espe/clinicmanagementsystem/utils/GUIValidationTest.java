package ec.edu.espe.clinicmanagementsystem.utils;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class GUIValidationTest {

    private JTextField textField;
    private JDateChooser dateChooser;

    @BeforeEach
    void setUp() {
        textField = new JTextField();
        dateChooser = new JDateChooser();
        
    }


    @Test
    void testValidateNotEmpty_EmptyString_ReturnsFalse() {
        textField.setText("");
        assertFalse(GUIValidation.validateNotEmpty(textField, "Nombre"));
         fail();
    }

    @Test
    void testValidateNotEmpty_WithText_ReturnsTrue() {
        textField.setText("Contenido");
        assertTrue(GUIValidation.validateNotEmpty(textField, "Nombre"));
    }


    @Test
    void testValidateOnlyLetters_WithNumbers_ReturnsFalse() {
        textField.setText("Juan123");
        assertFalse(GUIValidation.validateOnlyLetters(textField, "Nombre"));
    }

    @Test
    void testValidateOnlyNumbers_WithLetters_ReturnsFalse() {
        textField.setText("123abc");
        assertFalse(GUIValidation.validateOnlyNumbers(textField, "Edad"));
         fail();
    }


    @Test
    void testValidateNumericLength_IncorrectLength_ReturnsFalse() {
        textField.setText("12345");
        assertFalse(GUIValidation.validateNumericLength(textField, "Cédula", 10));
    }

    @Test
    void testValidatePositiveInt_NegativeValue_ReturnsFalse() {
        textField.setText("-5");
        assertFalse(GUIValidation.validatePositiveInt(textField, "Stock"));
    }

    @Test
    void testValidatePositiveInt_ValidValue_ReturnsTrue() {
        textField.setText("10");
        assertTrue(GUIValidation.validatePositiveInt(textField, "Stock"));
         fail();
    }

    @Test
    void testValidateEmail_InvalidFormat_ReturnsFalse() {
        textField.setText("usuario@dominio"); 
        assertFalse(GUIValidation.validateEmail(textField, "Correo"));
    }

    @Test
    void testValidateEmail_ValidFormat_ReturnsTrue() {
        textField.setText("test@google.com");
        assertTrue(GUIValidation.validateEmail(textField, "Correo"));
        
    }



    @Test
    void testValidateFutureDate_WithActualFutureDate_ReturnsFalse() {

        Calendar cal = Calendar.getInstance();
        cal.set(2030, Calendar.JANUARY, 1);
        dateChooser.setDate(cal.getTime());
        assertFalse(GUIValidation.validateFutureDate(dateChooser));
    }

    @Test
    void testValidateDateRange_DateTooFarInFuture_ReturnsFalse() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 5); 
        dateChooser.setDate(cal.getTime());  
        assertFalse(GUIValidation.validateDateRange(dateChooser, "Cita Médica"));
         fail();
    }
}