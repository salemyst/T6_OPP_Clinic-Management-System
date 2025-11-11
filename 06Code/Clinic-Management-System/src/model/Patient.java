package model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private int patientId;
    private String fullName;
    private String gender;
    private String phone;
    private String address;
    private List<MedicalHistory> medicalHistory;

    public Patient() {
        this.medicalHistory = new ArrayList<>();
    }

    public Patient(int patientId, String fullName, String gender, String phone, String address) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.medicalHistory = new ArrayList<>();
    }
    
    public void addMedicalRecord(MedicalHistory record) {
        this.medicalHistory.add(record);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
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
    
    public void requestAppointment() {
        System.out.println("Paciente " + this.fullName + " esta solicitando una cita.");
    }

    public void viewMedicalHistory() {
        System.out.println("--- Mostrando Historial Medico para " + this.fullName + " ---");
        if (this.medicalHistory == null || this.medicalHistory.isEmpty()) {
            System.out.println("No hay registros medicos disponibles.");
            return;
        }
        
        for (MedicalHistory record : this.medicalHistory) {
            System.out.println(record.toString());
        }
    }

    public void payBill(Billing bill) {
        System.out.println("Paciente " + this.fullName + " esta pagando la factura " + bill.getBillId());
        bill.updatePayment("Pagado"); 
        System.out.println("Factura pagada. Nuevo estado: " + bill.getStatus());
    }
}