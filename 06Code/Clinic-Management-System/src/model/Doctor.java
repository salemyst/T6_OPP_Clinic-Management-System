
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Doctor {

    private String doctorId;
    private String fullName;
    private String specialty;
    private String phone;
    private String email;

    public Doctor() {
    }

    public Doctor(String doctorId, String fullName, String specialty, String phone, String email) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specialty = specialty;
        this.phone = phone;
        this.email = email;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
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

    @Override
    public String toString() {
        return "Doctor{" + "doctorId=" + doctorId + ", fullName=" + fullName + ", specialty=" + specialty + '}';
    }
}
