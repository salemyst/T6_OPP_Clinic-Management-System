package ec.espe.edu.clinicmanagementsystem.view;

import ec.espe.edu.clinicmanagementsystem.model.Appointment;
import ec.espe.edu.clinicmanagementsystem.model.Billing;
import ec.espe.edu.clinicmanagementsystem.model.Clinic;
import ec.espe.edu.clinicmanagementsystem.model.Date;
import ec.espe.edu.clinicmanagementsystem.model.Doctor;
import ec.espe.edu.clinicmanagementsystem.model.MedicalHistory;
import ec.espe.edu.clinicmanagementsystem.model.Notification;
import ec.espe.edu.clinicmanagementsystem.model.Patient;
import ec.espe.edu.clinicmanagementsystem.model.Prescription;
import ec.espe.edu.clinicmanagementsystem.model.Receptionist;
import ec.espe.edu.clinicmanagementsystem.utils.Validation;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Adrian Toapanta, Paradigm, @ESPE
 */

public class MainView {

    private static Clinic clinic;
    private static Receptionist loggedInReceptionist;
    private static Doctor loggedInDoctor;
    private static Patient loggedInPatient;

    public static void main(String[] args) {

        clinic = new Clinic("Toamedical", "Av. America", "098-765-4321");

        if (clinic.getDoctors().isEmpty()) {
            clinic.addDoctor(new Doctor(1, "Dr. Alan Grant", "Cardiologia", "099123456", "agrant@clinic.com", "agrant", "***"));
            clinic.addDoctor(new Doctor(2, "Dra. Ellie Sattler", "Pediatria", "099123457", "esattler@clinic.com", "esattler", "****"));
        }
        if (clinic.getReceptionists().isEmpty()) {
            clinic.addReceptionist(new Receptionist(1, "John Hammond", "099654321", "jhammond@clinic.com", "jhammond", "1234"));
        }

        loggedInReceptionist = null;
        loggedInDoctor = null;

        runMainMenu();
    }

    private static void runMainMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Sistema de Gestion de Clinica ---");
            System.out.println("Clinica: " + clinic.getName());
            System.out.println("Seleccione su rol:");
            System.out.println("1. Recepcionista");
            System.out.println("2. Doctor");
            System.out.println("3. Paciente");
            System.out.println("4. Salir");

            choice = Validation.readInt("Opcion: ");

            switch (choice) {
                case 1:
                    runReceptionistMenu();
                    break;
                case 2:
                    runDoctorMenu();
                    break;
                case 3:
                    runPatientMenu();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private static void runReceptionistMenu() {
        
        if (loggedInReceptionist == null) {
            boolean loginSuccess = doReceptionistLogin();
            if (!loginSuccess) {
                return;
            }
        }

        int choice = 0;
        while (choice != 8) {
            System.out.println("\n== Menu Recepcionista (" + loggedInReceptionist.getName() + ") ==");
            System.out.println("1. Registrar Nuevo Paciente");
            System.out.println("2. Agendar Cita");
            System.out.println("3. Actualizar Informacion de Paciente");
            System.out.println("4. Reagendar Cita");
            System.out.println("5. Cancelar Cita");
            System.out.println("6. Modificar Doctor");
            System.out.println("7. Modificar Recepcionista");
            System.out.println("8. Volver al Menu Principal (Cerrar Sesion)");

            choice = Validation.readInt("Opcion: ");

            switch (choice) {
                case 1: doRegisterNewPatient(); break;
                case 2: doScheduleNewAppointment(); break;
                case 3: doUpdatePatientInfo(); break;
                case 4: doRescheduleAppointment(); break;
                case 5: doCancelAppointment(); break;
                case 6: doModifyDoctor(); break;
                case 7: doModifyReceptionist(); break;
                case 8: 
                    System.out.println("Cerrando sesion de recepcionista...");
                    loggedInReceptionist = null;
                    return;
                default: System.out.println("Opcion no valida.");
            }
        }
    }

    private static void runDoctorMenu() {

        if (loggedInDoctor == null) {
            boolean loginSuccess = doDoctorLogin();
            if (!loginSuccess) {
                return;
            }
        }

        int choice = 0;
        while (choice != 8) {
            System.out.println("\n== Menu Doctor (" + loggedInDoctor.getFullName() + ") ==");
            System.out.println("1. Anadir Registro a Historia Clinica");
            System.out.println("2. Modificar Registro de Historia Clinica");
            System.out.println("3. Ver Historia Clinica de Paciente");
            System.out.println("4. Crear Prescripcion");
            System.out.println("5. Ver mis Citas");
            System.out.println("6. Marcar Cita como Completada");
            System.out.println("7. Generar Factura (Billing)");
            System.out.println("8. Volver al Menu Principal (Cerrar Sesion)");

            choice = Validation.readInt("Opcion: ");

            switch (choice) {
                case 1: doAddNewMedicalRecord(); break;
                case 2: doModifyMedicalRecord(); break;
                case 3: doDoctorViewMedicalHistory(); break;
                case 4: doCreatePrescription(); break;
                case 5: loggedInDoctor.viewAppointments(clinic); break;
                case 6: doMarkAppointmentCompleted(); break;
                case 7: doGenerateBill(); break;
                case 8:
                    System.out.println("Cerrando sesion de doctor...");
                    loggedInDoctor = null;
                    return;
                default: System.out.println("Opcion no valida.");
            }
        }
    }

    private static void runPatientMenu() {
        System.out.println("\n== Menu Paciente ==");
        int patientId = Validation.readInt("Por favor, ingrese su ID de Paciente para continuar: ");
        loggedInPatient = clinic.searchPatient(patientId);

        if (loggedInPatient == null) {
            System.out.println("Error: Paciente con ID " + patientId + " no encontrado.");
            return;
        }

        int choice = 0;
        while (choice != 5) {
            System.out.println("\n== Menu Paciente (Hola, " + loggedInPatient.getFullName() + ") ==");
            System.out.println("1. Ver mi Historia Clinica");
            System.out.println("2. Solicitar una Cita (Simulacion)");
            System.out.println("3. Ver/Pagar Facturas");
            System.out.println("4. Ver mis Prescripciones");
            System.out.println("5. Salir (Cerrar Sesion de Paciente)");

            choice = Validation.readInt("Opcion: ");

            switch (choice) {
                case 1: loggedInPatient.viewMedicalHistory(); break;
                case 2: loggedInPatient.requestAppointment(); break;
                case 3: doPayBill(); break;
                case 4: doPrintPrescription(); break;
                case 5: System.out.println("Cerrando sesion de paciente..."); loggedInPatient = null; break;
                default: System.out.println("Opcion no valida.");
            }
        }
    }

    private static boolean doDoctorLogin() {
        System.out.println("\n--- Inicio de Sesion (Doctor) ---");
        String username = Validation.readString("Usuario: ");
        String password = Validation.readString("Contrasena: ");

        for (Doctor doctor : clinic.getDoctors()) {
            if (username.equals(doctor.getUsername()) && password.equals(doctor.getPassword())) {
                loggedInDoctor = doctor;
                System.out.println("Bienvenido, " + doctor.getFullName());
                return true;
            }
        }

        System.out.println("Error: Usuario o contrasena incorrectos.");
        return false;
    }
    
    private static boolean doReceptionistLogin() {
        System.out.println("\n--- Inicio de Sesion (Recepcionista) ---");
        String username = Validation.readString("Usuario: ");
        String password = Validation.readString("Contrasena: ");

        for (Receptionist rec : clinic.getReceptionists()) {
            if (username.equals(rec.getUsername()) && password.equals(rec.getPassword())) {
                loggedInReceptionist = rec;
                System.out.println("Bienvenido, " + rec.getName());
                return true;
            }
        }

        System.out.println("Error: Usuario o contrasena incorrectos.");
        return false;
    }

    private static void doRegisterNewPatient() {
        System.out.println("\n--- Registrar Nuevo Paciente ---");
        int id = Validation.readPositiveInt("ID del Paciente (numero): ");

        if (clinic.searchPatient(id) != null) {
            System.out.println("Error: Ya existe un paciente con el ID " + id + ". Registro cancelado.");
            return;
        }
        
        String name = null;
        String gender = null;
        String phone = null;
        String address = null;
        Patient tempPatient = new Patient(id,name,gender,phone,address);

        while (name == null) {
            String input = Validation.readString("Nombre Completo: ");
            try {
                tempPatient.setFullName(input);
                name = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese el nombre nuevamente.");
            }
        }

        while (gender == null) {
            String input = Validation.readString("Genero: ");
            try {
                tempPatient.setGender(input);
                gender = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese el genero nuevamente.");
            }
        }

        while (phone == null) {
            String input = Validation.readString("Telefono: ");
            try {
                tempPatient.setPhone(input);
                phone = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese el telefono nuevamente.");
            }
        }

        while (address == null) {
            String input = Validation.readString("Direccion: ");
            try {
                tempPatient.setAddress(input);
                address = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese la direccion nuevamente.");
            }
        }
        
        loggedInReceptionist.registerPatient(clinic, id, name, gender, phone, address);
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void doScheduleNewAppointment() {
        System.out.println("\n--- Agendar Cita ---");

        int appId = Validation.readPositiveInt("ID de la Cita (numero): ");
        if (findAppointmentById(appId) != null) {
            System.out.println("Error: Ya existe una cita con el ID " + appId + ". Agendamiento cancelado.");
            return;
        }

        int patId = Validation.readPositiveInt("ID del Paciente (numero): ");
        Patient patient = clinic.searchPatient(patId);
        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        int docId = Validation.readPositiveInt("ID del Doctor (numero): ");
        if (clinic.searchDoctor(docId) == null) {
            System.out.println("Error: Doctor no encontrado.");
            return;
        }

        Date appDate = Validation.readDate("--- Fecha y Hora de la Cita ---");

        for (Appointment existingApp : clinic.getAppointments()) {
            if (existingApp.getDoctorId() == docId && existingApp.getDate().toString().equals(appDate.toString())) {
                System.out.println("Error: El Dr. (ID " + docId + ") ya tiene una cita agendada a esa misma hora.");
                System.out.println("Agendamiento cancelado.");
                return;
            }
        }

        loggedInReceptionist.createAppointment(clinic, appId, appDate, patId, docId);
        System.out.println("Cita agendada exitosamente.");

        String patientName = (patient.getFullName() != null) ? patient.getFullName() : "Paciente ID " + patient.getPatientId();
        String message = "Confirmacion para " + patientName +
                         ": Su cita (ID " + appId + ") ha sido agendada para el " +
                         appDate.toString();

        Date notificationDate = new Date(appDate.getDay(), appDate.getMonth(), appDate.getYear(), appDate.getHour(), appDate.getMinute() + 1);

        Notification notification = new Notification(message, notificationDate);
        notification.send();
    }

    private static void doUpdatePatientInfo() {
        System.out.println("\n--- Actualizar Info de Paciente ---");
        int patientId = Validation.readPositiveInt("ID del Paciente a actualizar: ");
        Patient patient = clinic.searchPatient(patientId);

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        System.out.println("Paciente encontrado: " + patient.getFullName());
        System.out.println("Deje en blanco si no desea cambiar el dato.");

        String newPhone = null;
        String newAddress = null;

        while (newPhone == null) {
            System.out.print("Nuevo Telefono (" + patient.getPhone() + "): ");
            String input = Validation.readString(""); 
            if (input.isEmpty()) {
                newPhone = patient.getPhone();
                break;
            }
            try {
                patient.setPhone(input);
                newPhone = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese el telefono nuevamente.");
            }
        }

        while (newAddress == null) {
            System.out.print("Nueva Direccion (" + patient.getAddress() + "): ");
            String input = Validation.readString("");
            if (input.isEmpty()) {
                newAddress = patient.getAddress();
                break;
            }
            try {
                patient.setAddress(input);
                newAddress = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor, ingrese la direccion nuevamente.");
            }
        }

        loggedInReceptionist.updatePatientInfo(clinic, patient, newPhone, newAddress);
        System.out.println("Informacion actualizada exitosamente.");
    }

    private static void doRescheduleAppointment() {
        System.out.println("\n--- Reagendar Cita ---");
        int appId = Validation.readPositiveInt("ID de la Cita a reagendar: ");
        Appointment app = findAppointmentById(appId);

        if (app == null) {
            System.out.println("Error: Cita no encontrada.");
            return;
        }

        System.out.println("Cita encontrada: " + app.toString());
        Date newDate = Validation.readDate("--- Nueva Fecha y Hora ---");

        for (Appointment existingApp : clinic.getAppointments()) {
            if (existingApp.getAppointmentId() != app.getAppointmentId() && 
                existingApp.getDoctorId() == app.getDoctorId() && 
                existingApp.getDate().toString().equals(newDate.toString())) {
                System.out.println("Error: El Dr. (ID " + app.getDoctorId() + ") ya tiene una cita agendada a esa misma hora.");
                System.out.println("Reagendamiento cancelado.");
                return;
            }
        }

        app.reschedule(newDate);
        clinic.saveAppointmentChanges();
        
        Patient patient = clinic.searchPatient(app.getPatientId());
        String patientName = (patient != null && patient.getFullName() != null) ? patient.getFullName() : "Paciente ID " + app.getPatientId();
        String message = "Aviso para " + patientName + ": Su cita (ID " + app.getAppointmentId() + ") ha sido REAGENDADA para el " + newDate.toString();
        Date notificationDate = new Date(newDate.getDay(), newDate.getMonth(), newDate.getYear(), newDate.getHour(), newDate.getMinute() + 1);
        Notification notification = new Notification(message, notificationDate);
        notification.send();
    }

    private static void doCancelAppointment() {
        System.out.println("\n--- Cancelar Cita ---");
        int appId = Validation.readPositiveInt("ID de la Cita a cancelar: ");
        Appointment app = findAppointmentById(appId);

        if (app == null) {
            System.out.println("Error: Cita no encontrada.");
            return;
        }

        app.cancel();
        clinic.saveAppointmentChanges();

        Patient patient = clinic.searchPatient(app.getPatientId());
        String patientName = (patient != null && patient.getFullName() != null) ? patient.getFullName() : "Paciente ID " + app.getPatientId();
        Date currentDate = new Date(11, 11, 2025, 12, 0); 
        String message = "Aviso para " + patientName + ": Su cita (ID " + app.getAppointmentId() + ") del " + app.getDate().toString() + " ha sido CANCELADA.";
        Notification notification = new Notification(message, currentDate);
        notification.send();
    }
    
    private static void doModifyDoctor() {
        System.out.println("\n--- Modificar Doctor ---");
        int doctorId = Validation.readPositiveInt("ID del Doctor a modificar: ");
        Doctor doctor = clinic.searchDoctor(doctorId);

        if (doctor == null) {
            System.out.println("Error: Doctor no encontrado.");
            return;
        }

        System.out.println("Doctor encontrado: " + doctor.getFullName());
        System.out.println("Deje en blanco si no desea cambiar el dato.");

        String newPhone = null;
        String newEmail = null;

        while (newPhone == null) {
            System.out.print("Nuevo Telefono (" + doctor.getPhone() + "): ");
            String input = Validation.readString("");
            if (input.isEmpty()) {
                newPhone = doctor.getPhone();
                break;
            }
            try {
                new Patient().setPhone(input);
                newPhone = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: El telefono debe tener 10 digitos. Intente de nuevo.");
            }
        }

        System.out.print("Nuevo Email (" + doctor.getEmail() + "): ");
        newEmail = Validation.readString("");

        if (newEmail.isEmpty()) newEmail = doctor.getEmail();

        doctor.setPhone(newPhone);
        doctor.setEmail(newEmail);

        clinic.saveDoctorChanges();
        System.out.println("Doctor actualizado exitosamente.");
    }

    private static void doModifyReceptionist() {
        System.out.println("\n--- Modificar Recepcionista ---");
        int recId = Validation.readPositiveInt("ID del Recepcionista a modificar: ");
        Receptionist rec = clinic.searchReceptionist(recId);

        if (rec == null) {
            System.out.println("Error: Recepcionista no encontrado.");
            return;
        }

        System.out.println("Recepcionista encontrado: " + rec.getName());
        System.out.println("Deje en blanco si no desea cambiar el dato.");

        String newPhone = null;
        String newEmail = null;

        while (newPhone == null) {
            System.out.print("Nuevo Telefono (" + rec.getPhone() + "): ");
            String input = Validation.readString("");
            if (input.isEmpty()) {
                newPhone = rec.getPhone();
                break;
            }
            try {
                new Patient().setPhone(input);
                newPhone = input;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: El telefono debe tener 10 digitos. Intente de nuevo.");
            }
        }

        System.out.print("Nuevo Email (" + rec.getEmail() + "): ");
        newEmail = Validation.readString("");

        if (newEmail.isEmpty()) newEmail = rec.getEmail();

        rec.setPhone(newPhone);
        rec.setEmail(newEmail);

        clinic.saveReceptionistChanges();
        System.out.println("Recepcionista actualizado exitosamente.");
    }

    private static void doAddNewMedicalRecord() {
        System.out.println("\n--- Anadir Registro a Historia Clinica ---");
        int patientId = Validation.readPositiveInt("Ingrese ID del Paciente: ");
        Patient patient = clinic.searchPatient(patientId); 

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        System.out.println("Paciente encontrado: " + patient.getFullName());
        int historyId = Validation.readPositiveInt("ID del nuevo Registro de Historia (numero): ");
        String observations = Validation.readString("Observaciones: ");
        String treatments = Validation.readString("Tratamientos: ");
        String allergies = Validation.readString("Alergias: ");
        String diseases = Validation.readString("Enfermedades: ");

        Date recordDate = Validation.readDate("--- Fecha del Registro ---");

        MedicalHistory newRecord = new MedicalHistory(historyId, recordDate, allergies, diseases, treatments, observations);
        
        newRecord.addRecord();

        loggedInDoctor.updateMedicalHistory(clinic, patient, newRecord);
        System.out.println("Historial actualizado exitosamente.");
    }
    
    private static void doModifyMedicalRecord() {
        System.out.println("\n--- Modificar Registro de Historia Clinica ---");
        int patientId = Validation.readPositiveInt("Ingrese ID del Paciente: ");
        Patient patient = clinic.searchPatient(patientId); 

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }
        
        if (patient.getMedicalHistory() == null || patient.getMedicalHistory().isEmpty()) {
            System.out.println("El paciente no tiene registros para modificar.");
            return;
        }
        
        System.out.println("Registros existentes para " + patient.getFullName() + ":");
        patient.viewMedicalHistory();
        
        int historyId = Validation.readPositiveInt("Ingrese el ID del registro que desea modificar: ");
        
        MedicalHistory recordToModify = null;
        for (MedicalHistory record : patient.getMedicalHistory()) {
            if (record.getHistoryId() == historyId) {
                recordToModify = record;
                break;
            }
        }
        
        if (recordToModify == null) {
            System.out.println("Error: No se encontro un registro con ese ID.");
            return;
        }
        
        System.out.println("Registro encontrado. Deje en blanco para no cambiar.");
        
        System.out.print("Nuevas Observaciones (" + recordToModify.getObservations() + "): ");
        String newObs = Validation.readString("");
        System.out.print("Nuevos Tratamientos (" + recordToModify.getTreatments() + "): ");
        String newTreat = Validation.readString("");
        
        if (!newObs.isEmpty()) recordToModify.setObservations(newObs);
        if (!newTreat.isEmpty()) recordToModify.setTreatments(newTreat);
        
        recordToModify.updateHistory();
        
        clinic.savePatientChanges();
        System.out.println("Registro modificado exitosamente.");
    }

    private static void doDoctorViewMedicalHistory() {
        System.out.println("\n--- Ver Historia Clinica de Paciente ---");
        int patientId = Validation.readPositiveInt("Ingrese ID del Paciente: ");
        Patient patient = clinic.searchPatient(patientId);

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        patient.viewMedicalHistory();
    }

    private static void doCreatePrescription() {
        System.out.println("\n--- Crear Prescripcion ---");
        int patientId = Validation.readPositiveInt("ID del Paciente: ");
        Patient patient = clinic.searchPatient(patientId);

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        int presId = Validation.readPositiveInt("ID de la Prescripcion (numero): ");
        String medication = Validation.readString("Medicamento: ");
        String dosage = Validation.readString("Dosis (ej. 100mg): ");
        String instructions = Validation.readString("Instrucciones (ej. cada 8 horas): ");
        Date presDate = Validation.readDate("--- Fecha de la Prescripcion ---");

        Prescription p = new Prescription(presId, patientId, medication, dosage, instructions, presDate);
        
        clinic.saveNewPrescription(p);
        System.out.println("Prescripcion guardada exitosamente.");

        p.printPrescription();
    }

    private static void doMarkAppointmentCompleted() {
        System.out.println("\n--- Marcar Cita como Completada ---");
        int appId = Validation.readPositiveInt("ID de la Cita a completar: ");
        Appointment app = findAppointmentById(appId);

        if (app == null) {
            System.out.println("Error: Cita no encontrada.");
            return;
        }

        app.markCompleted();
        clinic.saveAppointmentChanges();
    }

    private static void doGenerateBill() {
        System.out.println("\n--- Generar Factura ---");
        int patientId = Validation.readPositiveInt("ID del Paciente a facturar: ");
        Patient patient = clinic.searchPatient(patientId);

        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        int billId = Validation.readPositiveInt("ID de la Factura (numero): ");
        double amount = Validation.readPositiveDouble("Monto de la Factura (ej. 40.50): ");
        Date billDate = Validation.readDate("--- Fecha de la Factura ---");

        Billing bill = new Billing(billId, amount, billDate, "Pending", patientId);
        bill.generateBill();

        clinic.saveNewBill(bill);

        System.out.println("Factura guardada exitosamente.");
        bill.viewBill();
    }

    private static void doPayBill() {
        System.out.println("\n--- Pagar Factura ---");

        List<Billing> pendingBills = new ArrayList<>();
        for (Billing bill : clinic.getBillings()) {
            if (bill.getPatientId() == loggedInPatient.getPatientId() &&
                bill.getStatus().equalsIgnoreCase("Pending")) {
                pendingBills.add(bill);
            }
        }

        if (pendingBills.isEmpty()) {
            System.out.println("No tiene facturas pendientes por pagar.");
            return;
        }

        System.out.println("Facturas pendientes:");
        for (Billing bill : pendingBills) {
            System.out.println("  ID: " + bill.getBillId() + ", Monto: $" + bill.getAmount() + ", Fecha: " + bill.getDate().getDate());
        }

        int billId = Validation.readInt("Ingrese el ID de la factura que desea pagar (0 para cancelar): ");
        if (billId == 0) return;

        Billing billToPay = clinic.searchBill(billId);

        if (billToPay == null || billToPay.getPatientId() != loggedInPatient.getPatientId() || !billToPay.getStatus().equalsIgnoreCase("Pending")) {
            System.out.println("Error: ID de factura no valido o ya esta pagada.");
            return;
        }

        System.out.println("--- Factura a Pagar ---");
        billToPay.viewBill();

        loggedInPatient.payBill(billToPay);
        clinic.saveBillingChanges();

        System.out.println("--- Estado Actualizado de la Factura ---");
        billToPay.viewBill();
    }

    private static void doPrintPrescription() {
        System.out.println("\n--- Ver Mis Prescripciones ---");
        
        List<Prescription> myPrescriptions = new ArrayList<>();
        for (Prescription p : clinic.getPrescriptions()) {
            if (p.getPatientId() == loggedInPatient.getPatientId()) {
                myPrescriptions.add(p);
            }
        }
        
        if (myPrescriptions.isEmpty()) {
            System.out.println("No tiene prescripciones registradas.");
            return;
        }
        
        for (Prescription p : myPrescriptions) {
            p.printPrescription();
        }
    }
    
    private static Appointment findAppointmentById(int appId) {
        for (Appointment app : clinic.getAppointments()) {
            if (app.getAppointmentId() == appId) {
                return app;
            }
        }
        return null;
    }
}