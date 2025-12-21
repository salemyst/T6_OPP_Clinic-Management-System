package ec.edu.espe.clinicmanagementsystem.view;

/**
 *
 * @author Cesar Vargas, Paradigm, @ESPE
 */

import static com.mongodb.assertions.Assertions.assertNotNull;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import static junit.framework.Assert.assertEquals;

public class FrmAddNewMedicalRecordTest {
@Test
    public void testInstanceNotNull() {
        FrmAddNewMedicalRecord frm = new FrmAddNewMedicalRecord();
        assertNotNull(frm);
    }

    @Test
    public void testDateParsingYear() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testDateParsingMonth() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testDateParsingDay() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testEmptyFieldsClearsPatientId() throws Exception {
        FrmAddNewMedicalRecord frm = new FrmAddNewMedicalRecord();
        Field field = FrmAddNewMedicalRecord.class.getDeclaredField("txtPatientId");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("999");
        
        Method method = FrmAddNewMedicalRecord.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);
        
        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearsObservations() throws Exception {
        FrmAddNewMedicalRecord frm = new FrmAddNewMedicalRecord();
        Field field = FrmAddNewMedicalRecord.class.getDeclaredField("txaObservations");
        field.setAccessible(true);
        ((JTextArea) field.get(frm)).setText("Obs");
        
        Method method = FrmAddNewMedicalRecord.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);
        
        assertEquals("", ((JTextArea) field.get(frm)).getText());
    }

    @Test
    public void testMedicalHistoryFieldExists() throws NoSuchFieldException {
        Field field = FrmAddNewMedicalRecord.class.getDeclaredField("medicalHistory");
        assertNotNull(field);
    }

    @Test
    public void testDateFieldExists() throws NoSuchFieldException {
        Field field = FrmAddNewMedicalRecord.class.getDeclaredField("date");
        assertNotNull(field);
    }    
}
