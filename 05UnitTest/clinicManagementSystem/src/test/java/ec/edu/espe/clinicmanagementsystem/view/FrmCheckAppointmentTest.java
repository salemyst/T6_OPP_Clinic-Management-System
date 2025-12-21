package ec.edu.espe.clinicmanagementsystem.view;

/**
 *
 * @author Cesar Vargas, Paradigm, @ESPE
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class FrmCheckAppointmentTest {
@Test
    public void testInstanceNotNull() {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        assertNotNull(frm);
    }

    @Test
    public void testEmptyIdValidation() throws NoSuchFieldException, IllegalAccessException {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        Field field = FrmCheckAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("");
        assertTrue(txt.getText().trim().isEmpty());
    }

    @Test
    public void testWhitespaceIdValidation() throws NoSuchFieldException, IllegalAccessException {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        Field field = FrmCheckAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("   ");
        assertTrue(txt.getText().trim().isEmpty());
    }

    @Test
    public void testNonEmptyIdValidation() throws NoSuchFieldException, IllegalAccessException {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        Field field = FrmCheckAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("1001");
        assertFalse(txt.getText().trim().isEmpty());
    }

    @Test
    public void testUpdateButtonText() throws NoSuchFieldException, IllegalAccessException {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        Field field = FrmCheckAppointment.class.getDeclaredField("btnUpdate");
        field.setAccessible(true);
        JButton btn = (JButton) field.get(frm);
        assertEquals("Actualizar", btn.getText());
    }

    @Test
    public void testHeaderLabel() throws NoSuchFieldException, IllegalAccessException {
        FrmCheckAppointment frm = new FrmCheckAppointment();
        Field field = FrmCheckAppointment.class.getDeclaredField("jLabel2");
        field.setAccessible(true);
        JLabel lbl = (JLabel) field.get(frm);
        assertEquals("MARCAR CITA COMO COMPLETADA", lbl.getText());
    }
}
