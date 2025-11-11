
package model;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class Billing {

    private String billId;
    private double amount;
    private Date date; // Usamos nuestra clase Date
    private String status; // Ej: "Paid", "Pending"
    private String patientId;

    public Billing() {
    }

    public Billing(String billId, double amount, Date date, String status, String patientId) {
        this.billId = billId;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.patientId = patientId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Billing{" + "billId=" + billId + ", amount=" + amount + ", date=" + date + ", status=" + status + '}';
    }
}