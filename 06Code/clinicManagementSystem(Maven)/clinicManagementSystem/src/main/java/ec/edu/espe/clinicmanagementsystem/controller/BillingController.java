
package ec.edu.espe.clinicmanagementsystem.controller;

import ec.edu.espe.clinicmanagementsystem.model.Billing;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class BillingController {

    public void generateBill(Billing billing) {
        billing.setStatus("Pending");
        System.out.println("Factura " + billing.getBillId() + " generada por un monto de " + billing.getAmount());
    }


    public void updatePaymentStatus(Billing billing, String newStatus) {
        billing.setStatus(newStatus);
        System.out.println("El estado de la Factura " + billing.getBillId() + " ha sido actualizado a: " + newStatus);
    }


    public void viewBill(Billing billing) {
        System.out.println("--- Viendo Factura ---");
        System.out.println("ID Factura: " + billing.getBillId());
        System.out.println("Paciente ID: " + billing.getPatientId());

        System.out.println("Fecha: " + billing.getDate().toString()); 
        System.out.println("Monto: $" + billing.getAmount());
        System.out.println("Estado: " + billing.getStatus());
        System.out.println("----------------------");
    }  
}
