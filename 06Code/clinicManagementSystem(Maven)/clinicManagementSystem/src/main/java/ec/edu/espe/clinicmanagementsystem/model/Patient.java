package ec.edu.espe.clinicmanagementsystem.model;
/**
 *
 * @author Adrian Toapanta, Paradigm, @ESPE
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
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty() || !fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("El nombre del paciente solo debe contener letras y espacios.");
        }
        this.fullName = fullName.trim();
    }
    
    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty() || !gender.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("El genero solo debe contener letras.");
        }
        this.gender = gender.trim();
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("El numero de telefono debe tener exactamente 10 digitos numericos.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty() || !address.matches("^[a-zA-Z0-9\\s.,#-]+$")) {
            throw new IllegalArgumentException("La direccion contiene caracteres invalidos o está vacía.");
        }
        this.address = address.trim();
    }
    

    public int getPatientId() { return patientId; }
    public String getFullName() { return fullName; }
    public String getGender() { return gender; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public List<MedicalHistory> getMedicalHistory() { return medicalHistory; }

    public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    public void addMedicalRecord(MedicalHistory record) {
        this.medicalHistory.add(record);
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