package ec.espe.edu.clinicmanagementsystem.model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

public class MedicalHistory {

    private int historyId;
    private Date date; 
    private String allergies;
    private String diseases;
    private String treatments;
    private String observations;

    public MedicalHistory() {
    }

    public MedicalHistory(int historyId, Date date, String allergies, String diseases, String treatments, String observations) {
        this.historyId = historyId;
        this.date = date;
        this.allergies = allergies;
        this.diseases = diseases;
        this.treatments = treatments;
        this.observations = observations;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Historial Medico" + 
                "\n ID: " + historyId + 
                "\nFecha: " + date + 
                "\nAlergias: "+ allergies +
                "\nEnfermedades: "+ diseases + 
                "\nTratamientos: " + treatments +
                "\nObservaciones: " + observations ;
    }
    
    public void addRecord() {
        System.out.println("Historial ID: " + this.historyId);
    }
    
    public void updateHistory() {
        System.out.println("Historial ID: " + this.historyId);
    }
}