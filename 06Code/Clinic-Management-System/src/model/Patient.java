
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Patient {

    private String patientId;
    private String fullName;
    private String gender;
    private String phone;
    private String address;
    private List<MedicalHistory> medicalHistory;

    public Patient() {
        this.medicalHistory = new ArrayList<>();
    }

    public Patient(String patientId, String fullName, String gender, String phone, String address) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.medicalHistory = new ArrayList<>();
    }
    
    // Método helper
    public void addMedicalRecord(MedicalHistory record) {
        this.medicalHistory.add(record);
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", fullName=" + fullName + ", phone=" + phone + ", address=" + address + '}';
    }
}