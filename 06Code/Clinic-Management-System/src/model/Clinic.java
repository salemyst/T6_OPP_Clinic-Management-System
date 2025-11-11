
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Receptionist> receptionists;
    private List<Appointment> appointments;
    
    private PatientRepository patientRepository;

    public Clinic(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        // Carga los pacientes desde el archivo JSON al iniciar
        this.patients = patientRepository.loadPatients();
        
        // Inicializamos las otras listas
        this.doctors = new ArrayList<>();
        this.receptionists = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    // --- Métodos de Paciente (Con persistencia JSON) ---
    
    public void registerPatient(Patient patient) {
        this.patients.add(patient);
        // Guarda la lista actualizada en el JSON
        this.patientRepository.savePatients(this.patients);
        System.out.println("Paciente registrado y guardado en JSON.");
    }
    
    public Patient searchPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }
    
    public void updatePatientMedicalHistory(Patient patient, MedicalHistory newRecord) {
        patient.addMedicalRecord(newRecord);
        // Guarda la lista de pacientes (con el historial actualizado) en el JSON
        this.patientRepository.savePatients(this.patients);
        System.out.println("Historial médico actualizado y guardado en JSON.");
    }

    // --- Métodos para otros objetos ---

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        System.out.println("Doctor añadido al sistema.");
    }

    public void addReceptionist(Receptionist receptionist) {
        this.receptionists.add(receptionist);
        System.out.println("Recepcionista añadido al sistema.");
    }

    public void scheduleAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        System.out.println("Cita agendada.");
        // Simulación de <<Include>> Send Notifications
        sendNotification("Cita agendada para paciente " + appointment.getPatientId());
    }
    
    public void sendNotification(String message) {
        System.out.println("[NOTIFICACIÓN]: " + message);
    }
    
    // Getters para las listas
    public List<Patient> getPatients() { return patients; }
    public List<Doctor> getDoctors() { return doctors; }
    public List<Appointment> getAppointments() { return appointments; }

    public Object getReceptionists() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}