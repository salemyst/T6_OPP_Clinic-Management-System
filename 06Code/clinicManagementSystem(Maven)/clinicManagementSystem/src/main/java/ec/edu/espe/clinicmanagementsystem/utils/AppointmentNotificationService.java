package ec.edu.espe.clinicmanagementsystem.utils;

/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class AppointmentNotificationService {

    private final String senderEmail;
    private final String appPassword;
    private final Session mailSession;

    public AppointmentNotificationService(String senderEmail, String appPassword) {
        this.senderEmail = senderEmail;
        this.appPassword = appPassword;
        this.mailSession = createMailSession();
    }

    private Session createMailSession() {
    Properties props = new Properties();  
    props.put("mail.smtp.host", "smtp.gmail.com"); 
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

    return Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmail, appPassword);
        }
    });
}

    /**
     * Sends a confirmation email specifically for a clinic appointment.
     *
     * @param recipientEmail The patient's email address.
     * @param patientName The full name of the patient.
     * @param appointmentDetails Date and time or relevant details of the
     * appointment.
     */
    public void sendReservationConfirmation(String recipientEmail, String patientName, String appointmentDetails) {
        System.out.println("Iniciando proceso de envío de notificación...");

        try {
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            String subject = "Confirmación de Cita Médica - Clínica Toamedical";
            message.setSubject(subject);
            String emailBody = buildEmailBody(patientName, appointmentDetails);
            message.setText(emailBody);

            Transport.send(message);

            System.out.println(" Notificación enviada correctamente a: " + recipientEmail);

        } catch (MessagingException e) {
            System.err.println(" Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String buildEmailBody(String name, String details) {
        return "Estimado/a " + name + ",\n\n"
                + "Su cita ha sido reservada exitosamente.\n"
                + "Fecha de la cita agendada: " + details + "\n\n"
                + "Por favor, llegue 10 minutos antes.\n"
                + "Atentamente,\n"
                + "Tú clínica de confianza Toamedical.";
    }

}
