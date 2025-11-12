package ec.espe.edu.clinicmanagementsystem.model;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

public class Billing {

    private int billId;
    private double amount;
    private Date date; 
    private String status; 
    private int patientId;

    public Billing() {
    }

    public Billing(int billId, double amount, Date date, String status, int patientId) {
        this.billId = billId;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.patientId = patientId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Billing{" + "billId=" + billId + ", amount=" + amount + ", date=" + date + ", status=" + status + '}';
    }
    
    public void generateBill() {
        System.out.println("Factura " + this.billId + " generada por un monto de " + this.amount);
        this.status = "Pending"; 
    }

    public void updatePayment(String newStatus) {
        this.status = newStatus;
    }

    public void viewBill() {
        System.out.println("--- Viendo Factura ---");
        System.out.println("ID Factura: " + this.billId);
        System.out.println("Paciente ID: " + this.patientId);
        System.out.println("Fecha: " + this.date.toString());
        System.out.println("Monto: $" + this.amount);
        System.out.println("Estado: " + this.status);
        System.out.println("----------------------");
    }
}