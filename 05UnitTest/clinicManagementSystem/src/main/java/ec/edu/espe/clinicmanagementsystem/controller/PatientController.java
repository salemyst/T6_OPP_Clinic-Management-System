
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Billing;
import ec.edu.espe.clinicmanagementsystem.model.MedicalHistory;
import ec.edu.espe.clinicmanagementsystem.model.Patient;
import java.util.List;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class PatientController {
  

    public void validateAndSetFullName(Patient patient, String fullName) {
        if (fullName == null || fullName.trim().isEmpty() || !fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("El nombre del paciente solo debe contener letras y espacios.");
        }
        patient.setFullName(fullName.trim());
    }
    
    public void validateAndSetGender(Patient patient, String gender) {
        if (gender == null || gender.trim().isEmpty() || !gender.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("El genero solo debe contener letras.");
        }
        patient.setGender(gender.trim());
    }

    public void validateAndSetPhone(Patient patient, String phone) {
        if (phone == null || !phone.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("El numero de telefono debe tener exactamente 10 digitos numericos.");
        }
        patient.setPhone(phone);
    }

    public void validateAndSetAddress(Patient patient, String address) {
        if (address == null || address.trim().isEmpty() || !address.matches("^[a-zA-Z0-9\\s.,#-]+$")) {
            throw new IllegalArgumentException("La direccion contiene caracteres invalidos o está vacía.");
        }
        patient.setAddress(address.trim());
    }


    public void requestAppointment(Patient patient) {
        System.out.println("Paciente " + patient.getFullName() + " esta solicitando una cita.");

    }

    public void viewMedicalHistory(Patient patient) {
        System.out.println("--- Mostrando Historial Medico para " + patient.getFullName() + " ---");
        List<MedicalHistory> history = patient.getMedicalHistory();

        if (history == null || history.isEmpty()) {
            System.out.println("No hay registros medicos disponibles.");
            return;
        }
        
        for (MedicalHistory record : history) {
            System.out.println(record.toString());
        }
    }

    
    public void payBill(Patient patient, Billing bill, BillingController billingController) {
        System.out.println("Paciente " + patient.getFullName() + " esta pagando la factura " + bill.getBillId());
        

        billingController.updatePaymentStatus(bill, "Pagado");
        
        System.out.println("Factura pagada. Nuevo estado: " + bill.getStatus());
    }
    

    public void addMedicalRecord(Patient patient, MedicalHistory record) {
         patient.getMedicalHistory().add(record);
         System.out.println("Registro médico " + record.getHistoryId() + " añadido al historial del paciente " + patient.getPatientId());

    } 
}
