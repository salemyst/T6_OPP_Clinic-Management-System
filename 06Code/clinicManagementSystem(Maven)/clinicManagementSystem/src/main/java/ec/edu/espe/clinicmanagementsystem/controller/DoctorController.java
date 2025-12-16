
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Appointment;
import ec.edu.espe.clinicmanagementsystem.model.Date;
import ec.edu.espe.clinicmanagementsystem.model.Doctor;
import ec.edu.espe.clinicmanagementsystem.model.MedicalHistory;
import ec.edu.espe.clinicmanagementsystem.model.Patient;
import ec.edu.espe.clinicmanagementsystem.model.Prescription;
import java.util.List;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class DoctorController {

    public void viewAppointments(Doctor doctor, List<Appointment> appointments) {
        System.out.println("--- Citas para el Dr. " + doctor.getFullName() + " ---");
        boolean found = false;
        for (Appointment app : appointments) {
            if (app.getDoctorId() == doctor.getDoctorId()) {
                System.out.println(app.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay citas agendadas.");
        }
    }


    public void updateMedicalHistory(Doctor doctor, Patient patient, MedicalHistory newRecord, Runnable dataServiceSavePatientChanges) {
        System.out.println(doctor.getFullName() + " actualizando historial de " + patient.getFullName());

        patient.addMedicalRecord(newRecord); 
        

        dataServiceSavePatientChanges.run(); 
        System.out.println("Historial médico del paciente " + patient.getPatientId() + " guardado con éxito.");
    }


    public Prescription createPrescription(Doctor doctor, Patient patient, int presId, String medication, String dosage, String instructions, Date date) {
        System.out.println("Dr. " + doctor.getFullName() + " creando prescripcion para " + patient.getFullName());
        Prescription newPrescription = new Prescription(presId, patient.getPatientId(), medication, dosage, instructions, date);
        return newPrescription;
    }
    
  
    public void diagnose(Doctor doctor, Patient patient, String diagnosis) {
        System.out.println(doctor.getFullName() + " diagnostico a " + patient.getFullName() + " con: " + diagnosis);

    }
}
