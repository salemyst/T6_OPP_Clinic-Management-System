
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Prescription;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class PrescriptionController {

    public void printPrescription(Prescription prescription) {
        System.out.println("\n--- Imprimiendo Prescripcion ---");
        System.out.println("ID Prescripcion: " + prescription.getPrescriptionId());
        System.out.println("Paciente ID: " + prescription.getPatientId());
        System.out.println("Fecha: " + prescription.getDate().toString());
        System.out.println("---------------------------------");
        System.out.println("Medicamento: " + prescription.getMedication());
        System.out.println("Dosis: " + prescription.getDosage());
        System.out.println("Instrucciones: " + prescription.getInstructions());
        System.out.println("---------------------------------");
        

    }
}
