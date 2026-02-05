
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.GoogleUser;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author Thais Santórum
 */
public class GoogleAuthController {

    public GoogleUser loginWithGoogle() {

        try {
            Desktop.getDesktop().browse(
                new URI("https://accounts.google.com")
            );

            String email = JOptionPane.showInputDialog(
                null,
                "Ingresa tu email:"
            );

            if (email != null && email.contains("@")) {
                return new GoogleUser(email, "Google uuario");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Error."
            );
        }

        return null;
    }
}
