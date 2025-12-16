
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Notification;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class NotificationController {
 
    public void send(Notification notification) {
        System.out.println("\n--- ENVIANDO NOTIFICACION ---");
        System.out.println("Fecha: " + notification.getDate().toString());
        System.out.println("Mensaje: " + notification.getMessage());
        System.out.println("-----------------------------");

    }
}
