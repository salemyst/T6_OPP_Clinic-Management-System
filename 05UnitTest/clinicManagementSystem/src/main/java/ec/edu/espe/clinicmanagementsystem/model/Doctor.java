package ec.edu.espe.clinicmanagementsystem.model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

public class Doctor {

    private int doctorId;
    private String fullName;
    private String specialty;
    private String phone;
    private String email;
    private String username;
    private String password;

    public Doctor() {
    }

    public Doctor(int doctorId, String fullName, String specialty, String phone, String email, String username, String password) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialty = specialty;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    @Override
    public String toString() {
        return "Doctor{" + "doctorId=" + doctorId + ", fullName=" + fullName + ", specialty=" + specialty + '}';
    }
}