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
import java.lang.reflect.Method;

public class FrmCancelAppointmentTest {

    @Test
    public void testInstanceNotNull() {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        assertNotNull(frm);
    }

    @Test
    public void testGetValueValid() throws NoSuchFieldException, IllegalAccessException {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        Field field = FrmCancelAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("555");
        assertEquals(555, frm.getValue());
    }

    @Test
    public void testGetValueInvalid() throws NoSuchFieldException, IllegalAccessException {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        Field field = FrmCancelAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("Invalid");
        assertThrows(NumberFormatException.class, () -> frm.getValue());
    }

    @Test
    public void testEmptyFieldsLogic() throws NoSuchFieldException, IllegalAccessException, Exception {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        Field field = FrmCancelAppointment.class.getDeclaredField("txtAppointmentId");
        field.setAccessible(true);
        JTextField txt = (JTextField) field.get(frm);
        txt.setText("123");

        Method method = FrmCancelAppointment.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", txt.getText());
    }

    @Test
    public void testButtonText() throws NoSuchFieldException, IllegalAccessException {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        Field field = FrmCancelAppointment.class.getDeclaredField("btnCancelAppointment");
        field.setAccessible(true);
        JButton btn = (JButton) field.get(frm);
        assertEquals("Cancelar Cita", btn.getText());
    }

    @Test
    public void testTitleLabel() throws NoSuchFieldException, IllegalAccessException {
        FrmCancelAppointment frm = new FrmCancelAppointment();
        Field field = FrmCancelAppointment.class.getDeclaredField("jLabel10");
        field.setAccessible(true);
        JLabel lbl = (JLabel) field.get(frm);
        assertEquals("CLÍNICA TOAMEDICAL", lbl.getText());
    }
}
