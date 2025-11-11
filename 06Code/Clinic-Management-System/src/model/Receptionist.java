package model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

public class Receptionist {

    private int receptionistId;
    private String name;
    private String phone;
    private String email;

    public Receptionist() {
    }

    public Receptionist(int receptionistId, String name, String phone, String email) {
        this.receptionistId = receptionistId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(int receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Appointment createAppointment(Clinic clinic, int appId, Date appDate, int patId, int docId) {
        System.out.println("Recepcionista " + this.name + " creando cita.");
        Appointment newAppointment = new Appointment(appId, appDate, patId, docId);
        clinic.saveNewAppointment(newAppointment); 
        return newAppointment;
    }

    public Patient registerPatient(Clinic clinic, int patientId, String fullName, String gender, String phone, String address) {
        System.out.println("Recepcionista " + this.name + " registrando a " + fullName);
        Patient newPatient = new Patient(patientId, fullName, gender, phone, address);
        clinic.registerPatient(newPatient); 
        return newPatient;
    }

    public void updatePatientInfo(Clinic clinic, Patient patient, String newPhone, String newAddress) {
        System.out.println("Recepcionista " + this.name + " actualizando info de " + patient.getFullName());
        patient.setPhone(newPhone);
        patient.setAddress(newAddress);
        clinic.savePatientChanges(); 
    }

    @Override
    public String toString() {
        return "Receptionist{" + "receptionistId=" + receptionistId + ", name=" + name + '}';
    }
}