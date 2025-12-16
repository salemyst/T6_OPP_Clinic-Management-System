
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Appointment;
import ec.edu.espe.clinicmanagementsystem.model.Date;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class AppointmentController {

    public void reschedule(Appointment appointment, Date newDate) {
        appointment.setDate(newDate);
        appointment.setStatus("Agendada"); 
        System.out.println("Cita " + appointment.getAppointmentId() + " reagendada para: " + newDate.toString());
    }


    public void cancel(Appointment appointment) {
        appointment.setStatus("Cancelada");
        System.out.println("Cita " + appointment.getAppointmentId() + " ha sido cancelada.");
    }


    public void markCompleted(Appointment appointment) {
        appointment.setStatus("Completada");
        System.out.println("Cita " + appointment.getAppointmentId() + " marcada como completada.");
    }
}
