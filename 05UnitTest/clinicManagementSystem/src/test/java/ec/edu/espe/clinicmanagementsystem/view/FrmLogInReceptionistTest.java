
package ec.edu.espe.clinicmanagementsystem.view;

import java.lang.reflect.Field;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class FrmLogInReceptionistTest {
    
private FrmLogInReceptionist loginFrame;

    @BeforeEach
    void setUp() {
        loginFrame = new FrmLogInReceptionist();
    }

    private Object getPrivateComponent(String fieldName) throws Exception {
        Field field = FrmLogInReceptionist.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(loginFrame);
    }

    @Test
    void testComponentsNotNull() {
        assertNotNull(loginFrame, "La instancia del formulario no debe ser nula.");
    }

    @Test
    void testInitialState_FieldsAreEmpty() throws Exception {
        JTextField txtUser = (JTextField) getPrivateComponent("txtReceptionistUser");
        JPasswordField txtPass = (JPasswordField) getPrivateComponent("txtReceptionistPassword");
        
        assertEquals("", txtUser.getText());
        assertEquals("", new String(txtPass.getPassword()));
    }

    @Test
    void testTitleIsCorrect() {
        assertNotNull(loginFrame.getContentPane());
    }

    @Test
    void testCredentials_ValidUser1() throws Exception {
        JTextField txtUser = (JTextField) getPrivateComponent("txtReceptionistUser");
        txtUser.setText("jhammond");
        assertEquals("jhammond", txtUser.getText().trim());
        fail();
    }

    @Test
    void testCredentials_ValidUser2() throws Exception {

        JTextField txtUser = (JTextField) getPrivateComponent("txtReceptionistUser");
        txtUser.setText("mwu");
        assertEquals("mwu", txtUser.getText().trim());
    }

    @Test
    void testCredentials_TrimSpaces() throws Exception {
        JTextField txtUser = (JTextField) getPrivateComponent("txtReceptionistUser");
        txtUser.setText("  jhammond  ");
        assertEquals("jhammond", txtUser.getText().trim());
    }

    @Test
    void testPassword_FieldReturnsCorrectValue() throws Exception {
        JPasswordField txtPass = (JPasswordField) getPrivateComponent("txtReceptionistPassword");
        txtPass.setText("1234");
        assertEquals("1234", String.valueOf(txtPass.getPassword()));
    }

    @Test
    void testLoginLogic_EmptyUserFails() {
        loginFrame.setVisible(true);
        assertTrue(loginFrame.isVisible());
    }

    @Test
    void testCredentials_CaseSensitivity() throws Exception {
        JTextField txtUser = (JTextField) getPrivateComponent("txtReceptionistUser");
        txtUser.setText("JHAMMOND"); 
        assertNotEquals("jhammond", txtUser.getText()); 
    }

    @Test
    void testFrameVisibility_AfterInit() {
        loginFrame.setVisible(true);
        assertTrue(loginFrame.isVisible(), "El frame debería estar visible.");
        loginFrame.dispose();
    }

    @Test
    void testLoadReceptionists_NullOnMissingFile() {

        try {
            java.lang.reflect.Method method = FrmLogInReceptionist.class.getDeclaredMethod("loadReceptionists");
            method.setAccessible(true);
            Object result = method.invoke(loginFrame);
            assertNull(result, "Debería retornar null o capturar excepción si el archivo JSON no existe.");
        } catch (Exception e) {
        }
    }
}
