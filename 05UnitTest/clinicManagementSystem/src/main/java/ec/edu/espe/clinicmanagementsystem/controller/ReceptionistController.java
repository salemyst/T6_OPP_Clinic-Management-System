
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Appointment;
import ec.edu.espe.clinicmanagementsystem.model.Date;
import ec.edu.espe.clinicmanagementsystem.model.Patient;
import ec.edu.espe.clinicmanagementsystem.model.Receptionist;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class ReceptionistController {

    public Appointment createAppointment(Receptionist receptionist, int appId, Date appDate, int patId, int docId, ClinicController dataService) {
        System.out.println("Recepcionista " + receptionist.getName() + " creando cita.");
        

        Appointment newAppointment = new Appointment(appId, appDate, patId, docId);
        

        dataService.saveNewAppointment(newAppointment); 
        
        return newAppointment;
    }


    public Patient registerPatient(Receptionist receptionist, int patientId, String fullName, String gender, String phone, String address, ClinicController dataService) {
        System.out.println("Recepcionista " + receptionist.getName() + " registrando a " + fullName);
        

        Patient newPatient = new Patient(patientId, fullName, gender, phone, address);
        

        dataService.registerPatient(newPatient); 
        
        return newPatient;
    }


    public void updatePatientInfo(Receptionist receptionist, Patient patient, String newPhone, String newAddress, ClinicController dataService) {
        System.out.println("Recepcionista " + receptionist.getName() + " actualizando info de " + patient.getFullName());

        patient.setPhone(newPhone);
        patient.setAddress(newAddress);
        
    
        dataService.savePatientChanges(); 
        System.out.println("Información del paciente " + patient.getPatientId() + " actualizada y guardada.");
    }
}
