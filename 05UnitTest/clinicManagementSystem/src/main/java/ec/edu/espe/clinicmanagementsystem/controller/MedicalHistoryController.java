
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.MedicalHistory;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class MedicalHistoryController {


    public void addRecord(MedicalHistory medicalHistory) {
 
        System.out.println("Registro de Historial Médico ID: " + medicalHistory.getHistoryId() + " ha sido añadido al sistema.");
    }

 
    public void updateHistory(MedicalHistory medicalHistory, String newObservations, String newTreatments) {

        medicalHistory.setObservations(newObservations);
        medicalHistory.setTreatments(newTreatments);
        
        System.out.println("Historial Médico ID: " + medicalHistory.getHistoryId() + " ha sido actualizado con nueva información en la fecha: " + medicalHistory.getDate().toString());

    }  
}
