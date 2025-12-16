
package ec.edu.espe.clinicmanagementsystem.controller;

import com.google.gson.reflect.TypeToken;
import ec.edu.espe.clinicmanagementsystem.model.Appointment;
import ec.edu.espe.clinicmanagementsystem.model.Billing;
import ec.edu.espe.clinicmanagementsystem.model.Doctor;
import ec.edu.espe.clinicmanagementsystem.model.Patient;
import ec.edu.espe.clinicmanagementsystem.model.Prescription;
import ec.edu.espe.clinicmanagementsystem.model.Receptionist;
import ec.edu.espe.clinicmanagementsystem.utils.JsonRepository;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class ClinicController {
  private JsonRepository<Patient> patientRepository;
    private JsonRepository<Doctor> doctorRepository;
    private JsonRepository<Receptionist> receptionistRepository;
    private JsonRepository<Billing> billingRepository;
    private JsonRepository<Appointment> appointmentRepository;
    private JsonRepository<Prescription> prescriptionRepository;

    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Receptionist> receptionists;
    private List<Appointment> appointments;
    private List<Billing> billings;
    private List<Prescription> prescriptions;  
    public ClinicController(){ 

        String dataDirectory = "data";
        new File(dataDirectory).mkdirs();

        String dir = dataDirectory + File.separator;

        Type patientListType = new TypeToken<ArrayList<Patient>>(){}.getType();
        Type doctorListType = new TypeToken<ArrayList<Doctor>>(){}.getType();
        Type receptionistListType = new TypeToken<ArrayList<Receptionist>>(){}.getType();
        Type billingListType = new TypeToken<ArrayList<Billing>>(){}.getType();
        Type appointmentListType = new TypeToken<ArrayList<Appointment>>(){}.getType();
        Type prescriptionListType = new TypeToken<ArrayList<Prescription>>(){}.getType();

        this.patientRepository = new JsonRepository<>(dir + "patients.json", patientListType);
        this.doctorRepository = new JsonRepository<>(dir + "doctors.json", doctorListType);
        this.receptionistRepository = new JsonRepository<>(dir + "receptionists.json", receptionistListType);
        this.billingRepository = new JsonRepository<>(dir + "billings.json", billingListType);
        this.appointmentRepository = new JsonRepository<>(dir + "appointments.json", appointmentListType);
        this.prescriptionRepository = new JsonRepository<>(dir + "prescriptions.json", prescriptionListType);

        this.patients = patientRepository.loadData();
        this.doctors = doctorRepository.loadData();
        this.receptionists = receptionistRepository.loadData();
        this.billings = billingRepository.loadData();
        this.appointments = appointmentRepository.loadData();
        this.prescriptions = prescriptionRepository.loadData();
    }
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        saveDoctorChanges();
    }

    public void addReceptionist(Receptionist receptionist) {
        this.receptionists.add(receptionist);
        saveReceptionistChanges();
    }
    
    public void registerPatient(Patient patient) {
        this.patients.add(patient);
        savePatientChanges();
    }
    
    public void saveNewAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        saveAppointmentChanges();
    }
    
    public void saveNewBill(Billing bill) {
        this.billings.add(bill);
        saveBillingChanges();
    }
    
    public void saveNewPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
        savePrescriptionChanges();
    }

  

    public void savePatientChanges() {
        this.patientRepository.saveData(this.patients);
    }
    
    public void saveDoctorChanges() {
        this.doctorRepository.saveData(this.doctors);
    }

    public void saveReceptionistChanges() {
        this.receptionistRepository.saveData(this.receptionists);
    }
    
    public void saveBillingChanges() {
        this.billingRepository.saveData(this.billings);
    }
    
    public void saveAppointmentChanges() {
        this.appointmentRepository.saveData(this.appointments);
    }

    public void savePrescriptionChanges() {
        this.prescriptionRepository.saveData(this.prescriptions);
    }



    public Patient searchPatient(int patientId) {
        for (Patient p : patients) {
            if (p.getPatientId() == patientId) {
                return p;
            }
        }
        return null;
    }
    
    public Doctor searchDoctor(int doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == doctorId) {
                return d;
            }
        }
        return null;
    }
    
    public Receptionist searchReceptionist(int receptionistId) {
        for (Receptionist r : receptionists) {
            if (r.getReceptionistId() == receptionistId) {
                return r;
            }
        }
        return null;
    }
    
    public Billing searchBill(int billId) {
        for (Billing b : billings) {
            if (b.getBillId() == billId) {
                return b;
            }
        }
        return null;
    }

    // --- Getters para obtener las listas (si se necesitan) ---

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Receptionist> getReceptionists() {
        return receptionists;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
    public List<Billing> getBillings() {
        return billings;
    }
    
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
    }

