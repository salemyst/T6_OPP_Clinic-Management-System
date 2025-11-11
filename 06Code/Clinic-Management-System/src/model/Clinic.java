package model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import utils.JsonRepository;

public class Clinic {

    private String name;
    private String address;
    private String phone;

    private transient JsonRepository<Patient> patientRepository;
    private transient JsonRepository<Doctor> doctorRepository;
    private transient JsonRepository<Receptionist> receptionistRepository;
    private transient JsonRepository<Billing> billingRepository;

    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Receptionist> receptionists;
    private List<Appointment> appointments;
    private List<Billing> billings;

    public Clinic(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        Type patientListType = new TypeToken<ArrayList<Patient>>(){}.getType();
        Type doctorListType = new TypeToken<ArrayList<Doctor>>(){}.getType();
        Type receptionistListType = new TypeToken<ArrayList<Receptionist>>(){}.getType();
        Type billingListType = new TypeToken<ArrayList<Billing>>(){}.getType();

        this.patientRepository = new JsonRepository<>("patients.json", patientListType);
        this.doctorRepository = new JsonRepository<>("doctors.json", doctorListType);
        this.receptionistRepository = new JsonRepository<>("receptionists.json", receptionistListType);
        this.billingRepository = new JsonRepository<>("billings.json", billingListType);

        this.patients = patientRepository.loadData();
        this.doctors = doctorRepository.loadData();
        this.receptionists = receptionistRepository.loadData();
        this.billings = billingRepository.loadData();
        
        this.appointments = new ArrayList<>(); 
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        this.doctorRepository.saveData(this.doctors);
    }

    public void addReceptionist(Receptionist receptionist) {
        this.receptionists.add(receptionist);
        this.receptionistRepository.saveData(this.receptionists);
    }
    
    public void registerPatient(Patient patient) {
        this.patients.add(patient);
        this.patientRepository.saveData(this.patients);
    }

    public Patient searchPatient(int patientId) {
        for (Patient p : patients) {
            if (p.getPatientId() == patientId) {
                return p;
            }
        }
        return null;
    }
        
    public void saveNewAppointment(Appointment appointment) {
        this.appointments.add(appointment);
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
    
    public void saveNewBill(Billing bill) {
        this.billings.add(bill);
        this.billingRepository.saveData(this.billings);
    }
    
    public void saveBillingChanges() {
        this.billingRepository.saveData(this.billings);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public JsonRepository<Patient> getPatientRepository() {
        return patientRepository;
    }

    public void setPatientRepository(JsonRepository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
    }

    public JsonRepository<Doctor> getDoctorRepository() {
        return doctorRepository;
    }

    public void setDoctorRepository(JsonRepository<Doctor> doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public JsonRepository<Receptionist> getReceptionistRepository() {
        return receptionistRepository;
    }

    public void setReceptionistRepository(JsonRepository<Receptionist> receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Receptionist> getReceptionists() {
        return receptionists;
    }

    public void setReceptionists(List<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    public List<Billing> getBillings() {
        return billings;
    }

    public void setBillings(List<Billing> billings) {
        this.billings = billings;
    }
    
    public JsonRepository<Billing> getBillingRepository() {
        return billingRepository;
    }

    public void setBillingRepository(JsonRepository<Billing> billingRepository) {
        this.billingRepository = billingRepository;
    }
}