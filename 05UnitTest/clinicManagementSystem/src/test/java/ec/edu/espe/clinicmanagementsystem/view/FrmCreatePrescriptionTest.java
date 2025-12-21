package ec.edu.espe.clinicmanagementsystem.view;

/**
 *
 * @author Cesar Vargas, Paradigm, @ESPE
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class FrmCreatePrescriptionTest {

    @Test
    public void testInstanceNotNull() {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        assertNotNull(frm);
    }

    @Test
    public void testTxtIdExists() throws NoSuchFieldException, IllegalAccessException {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        Field field = FrmCreatePrescription.class.getDeclaredField("txtId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        assertNotNull(txt);
    }

    @Test
    public void testTxtMedicationExists() throws NoSuchFieldException, IllegalAccessException {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        Field field = FrmCreatePrescription.class.getDeclaredField("txtMedication");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        assertNotNull(txt);
    }

    @Test
    public void testTxtBoxObservacionesExists() throws NoSuchFieldException, IllegalAccessException {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        Field field = FrmCreatePrescription.class.getDeclaredField("txtBoxobservaciones");
        field.setAccessible(true);
        JTextArea area = (JTextArea) field.get(frm);
        assertNotNull(area);
    }

    @Test
    public void testSaveButtonText() throws NoSuchFieldException, IllegalAccessException {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        Field field = FrmCreatePrescription.class.getDeclaredField("SaveButton");
        field.setAccessible(true);
        JButton btn = (JButton) field.get(frm);
        assertEquals("Guardar", btn.getText());
    }

    @Test
    public void testMainLabelText() throws NoSuchFieldException, IllegalAccessException {
        FrmCreatePrescription frm = new FrmCreatePrescription();
        Field field = FrmCreatePrescription.class.getDeclaredField("PrescriptionLb");
        field.setAccessible(true);
        JLabel lbl = (JLabel) field.get(frm);
        assertEquals("CREAR PRESCRIPCIÓN", lbl.getText());
    }
}
