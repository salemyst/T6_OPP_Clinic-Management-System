
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Prescription {

    private String prescriptionId;
    private String medication;
    private String dosage;
    private String instructions;
    private Date date; // Usamos nuestra clase Date

    public Prescription() {
    }

    public Prescription(String prescriptionId, String medication, String dosage, String instructions, Date date) {
        this.prescriptionId = prescriptionId;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.date = date;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
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
        return "Prescription{" + "prescriptionId=" + prescriptionId + ", medication=" + medication + ", dosage=" + dosage + ", date=" + date + '}';
    }
}