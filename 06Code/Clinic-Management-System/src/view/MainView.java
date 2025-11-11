
package view;

import model.Appointment;
import model.Clinic;
import model.Date; //
import model.Doctor;
import model.MedicalHistory;
import model.Patient;
import model.PatientRepository;
import model.Receptionist;

import java.util.Scanner;
/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */



public class MainView {

    private static Clinic clinic;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Define el nombre del archivo JSON (se guardará en la raíz del proyecto)
        PatientRepository patientRepository = new PatientRepository("patients.json");
        

        clinic = new Clinic(patientRepository);

        if (clinic.getDoctors().isEmpty()) {
            clinic.addDoctor(new Doctor("D001", "Dr. Alan Grant", "Cardiología", "099123456", "agrant@clinic.com"));
        }
        if (clinic.getReceptionists().isEmpty) {
            clinic.addReceptionist(new Receptionist("R001", "John Hammond", "099654321", "jhammond@clinic.com"));
        }

        runMainMenu();
    }

    private static void runMainMenu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- Sistema de Gestión de Clínica ---");
            System.out.println("Seleccione su rol:");
            System.out.println("1. Admin");
            System.out.println("2. Recepcionista");
            System.out.println("3. Doctor");
            System.out.println("4. Paciente");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> runAdminMenu();
                case 2 -> runReceptionistMenu();
                case 3 -> runDoctorMenu();
                case 4 -> runPatientMenu();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // --- Menús de Actores (Simplificados) ---

    private static void runAdminMenu() {
        System.out.println("\n== Menú Admin ==");
        System.out.println("Doctores actuales:");
        clinic.getDoctors().forEach(System.out::println);
    }

    private static void runReceptionistMenu() {
        System.out.println("\n== Menú Recepcionista ==");
        System.out.println("1. Registrar Nuevo Paciente");
        System.out.println("2. Agendar Cita");
        System.out.print("Opción: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            registerNewPatient();
        } else if (choice == 2) {
            scheduleNewAppointment();
        }
    }

    private static void runDoctorMenu() {
        System.out.println("\n== Menú Doctor ==");
        System.out.println("1. Actualizar Historia Clínica");
        System.out.print("Opción: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            updateMedicalHistory();
        }
    }
    
    private static void runPatientMenu() {
        System.out.println("\n== Menú Paciente ==");
        System.out.println("1. Ver mi Historia Clínica");
        System.out.print("Opción: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            viewMedicalHistory();
        }
    }

    // --- Lógica de Casos de Uso ---

    private static void registerNewPatient() {
        System.out.println("\n--- Registrar Nuevo Paciente ---");
        System.out.print("ID del Paciente (ej. P001): ");
        String id = scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String name = scanner.nextLine();
        System.out.print("Género: ");
        String gender = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        
        Patient newPatient = new Patient(id, name, gender, phone, address);
        clinic.registerPatient(newPatient); // Esto guarda en JSON
    }
    
    private static void scheduleNewAppointment() {
        System.out.println("\n--- Agendar Cita ---");
        System.out.print("ID de la Cita (ej. A001): ");
        String appId = scanner.nextLine();
        System.out.print("ID del Paciente (ej. P001): ");
        String patId = scanner.nextLine();
        System.out.print("ID del Doctor (ej. D001): ");
        String docId = scanner.nextLine();
        
        // Pedimos los datos para nuestra clase Date
        System.out.println("Ingrese fecha y hora de la cita:");
        System.out.print("Año (ej. 2025): ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Mes (1-12): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Día (1-31): ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Hora (0-23): ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Minuto (0-59): ");
        int minute = Integer.parseInt(scanner.nextLine());
        
        Date appDate = new Date(day, month, year, hour, minute);
        
        Appointment newAppointment = new Appointment(appId, appDate, patId, docId);
        clinic.scheduleAppointment(newAppointment);
        System.out.println("Cita agendada para " + appDate.toString());
    }
    
    private static void updateMedicalHistory() {
        System.out.println("\n--- Actualizar Historia Clínica ---");
        System.out.print("Ingrese ID del Paciente: ");
        String patientId = scanner.nextLine();
        
        Patient patient = clinic.searchPatientById(patientId);
        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }
        
        System.out.println("Paciente encontrado: " + patient.getFullName());
        System.out.print("ID del Registro de Historia (ej. H001): ");
        String historyId = scanner.nextLine();
        System.out.print("Observaciones: ");
        String observations = scanner.nextLine();
        System.out.print("Tratamientos: ");
        String treatments = scanner.nextLine();
        System.out.print("Alergias: ");
        String allergies = scanner.nextLine();
        System.out.print("Enfermedades: ");
        String diseases = scanner.nextLine();
        
        // Usamos una fecha simple (actual) para el registro
        Date recordDate = new Date(10, 11, 2025, 21, 0); // Simulación de fecha actual
        
        MedicalHistory newRecord = new MedicalHistory(historyId, recordDate, allergies, diseases, treatments, observations);
        
        // Este método actualiza el paciente y guarda en JSON
        clinic.updatePatientMedicalHistory(patient, newRecord); 
    }
    
    private static void viewMedicalHistory() {
        System.out.println("\n--- Ver Historia Clínica ---");
        System.out.print("Ingrese su ID de Paciente: ");
        String patientId = scanner.nextLine();

        Patient patient = clinic.searchPatientById(patientId);
        if (patient == null) {
            System.out.println("Error: Paciente no encontrado.");
            return;
        }

        System.out.println("Mostrando historial para: " + patient.getFullName());
        if (patient.getMedicalHistory().isEmpty()) {
            System.out.println("No hay registros médicos.");
        } else {
            for (MedicalHistory record : patient.getMedicalHistory()) {
                System.out.println(" - " + record.toString());
            }
        }
    }
}