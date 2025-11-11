
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Receptionist {

    private String receptionistId;
    private String name;
    private String phone;
    private String email;

    public Receptionist() {
    }

    public Receptionist(String receptionistId, String name, String phone, String email) {
        this.receptionistId = receptionistId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
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

    @Override
    public String toString() {
        return "Receptionist{" + "receptionistId=" + receptionistId + ", name=" + name + '}';
    }
}
