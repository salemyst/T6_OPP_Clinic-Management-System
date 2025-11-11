
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class MedicalHistory {

    private String historyId;
    private Date date; // Usamos nuestra clase Date
    private String allergies;
    private String diseases;
    private String treatments;
    private String observations;

    public MedicalHistory() {
    }

    public MedicalHistory(String historyId, Date date, String allergies, String diseases, String treatments, String observations) {
        this.historyId = historyId;
        this.date = date;
        this.allergies = allergies;
        this.diseases = diseases;
        this.treatments = treatments;
        this.observations = observations;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
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
        return "MedicalHistory{" + "historyId=" + historyId + ", date=" + date + ", observations=" + observations + ", treatments=" + treatments + '}';
    }
}
