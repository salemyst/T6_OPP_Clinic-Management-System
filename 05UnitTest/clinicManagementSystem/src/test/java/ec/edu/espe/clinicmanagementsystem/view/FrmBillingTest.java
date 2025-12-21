package ec.edu.espe.clinicmanagementsystem.view;

/**
 *
 * @author Cesar Vargas, Paradigm, @ESPE
 */
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FrmBillingTest {

    @Test
    public void testInstanceNotNull() {
        FrmBilling frm = new FrmBilling();
        assertNotNull(frm);
    }

    @Test
    public void testTableModelColumnCount() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("tblBilling");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals(4, table.getModel().getColumnCount());
    }

    @Test
    public void testColumnNameId() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("tblBilling");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("ID", table.getModel().getColumnName(0));
    }

    @Test
    public void testColumnNameName() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("tblBilling");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Nombre", table.getModel().getColumnName(1));
    }

    @Test
    public void testColumnNameAddress() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("tblBilling");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Dirección", table.getModel().getColumnName(2));
    }

    @Test
    public void testColumnNameCost() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("tblBilling");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Costo", table.getModel().getColumnName(3));
    }

    @Test
    public void testClearFieldsLogic() throws Exception {
        FrmBilling frm = new FrmBilling();

        Field fId = FrmBilling.class.getDeclaredField("txtId");
        fId.setAccessible(true);
        ((JTextPane) fId.get(frm)).setText("1");

        Field fName = FrmBilling.class.getDeclaredField("txtName");
        fName.setAccessible(true);
        ((JTextPane) fName.get(frm)).setText("Test");

        Method method = FrmBilling.class.getDeclaredMethod("clearFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextPane) fId.get(frm)).getText());
        assertEquals("", ((JTextPane) fName.get(frm)).getText());
    }

    @Test
    public void testTableInitialRowCount() throws NoSuchFieldException, IllegalAccessException {
        FrmBilling frm = new FrmBilling();
        Field field = FrmBilling.class.getDeclaredField("model");
        field.setAccessible(true);
        DefaultTableModel model = (DefaultTableModel) field.get(frm);
        assertNotNull(model);
    }
}
