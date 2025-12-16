package ec.edu.espe.clinicmanagementsystem.model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

public class Prescription {

    private int prescriptionId;
    private int patientId; 
    private String medication;
    private String dosage;
    private String instructions;
    private Date date; 

    public Prescription() {
    }

    public Prescription(int prescriptionId, int patientId, String medication, String dosage, String instructions, Date date) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId; 
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.date = date;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    
    public int getPatientId() { 
        return patientId;
    }

    public void setPatientId(int patientId) { 
        this.patientId = patientId;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Prescription{" + "prescriptionId=" + prescriptionId + ", patientId=" + patientId + ", medication=" + medication + ", dosage=" + dosage + '}';
    }
    

}