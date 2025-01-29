package HMS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1: 
                        System.out.print("Enter patient ID: ");
                        int patientId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter patient name: ");
                        String patientName = scanner.nextLine();
                        System.out.print("Enter patient age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter ailment: ");
                        String ailment = scanner.nextLine();
                        patients.add(new Patient(patientId, patientName, age, ailment));
                        System.out.println("Patient added successfully.");
                        break;

                    case 2: 
                        System.out.print("Enter doctor ID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter specialization: ");
                        String specialization = scanner.nextLine();
                        doctors.add(new Doctor(doctorId, doctorName, specialization));
                        System.out.println("Doctor added successfully.");
                        break;

                    case 3: 
                        System.out.print("Enter patient ID: ");
                        int patientIdForAppointment = scanner.nextInt();
                        scanner.nextLine();
                        Patient patient = patients.stream()
                                .filter(p -> p.getPatientId() == patientIdForAppointment)
                                .findFirst()
                                .orElseThrow(() -> new Exception("Patient not found!"));

                        System.out.print("Enter doctor ID: ");
                        int doctorIdForAppointment = scanner.nextInt();
                        scanner.nextLine();
                        Doctor doctor = doctors.stream()
                                .filter(d -> d.getDoctorId() == doctorIdForAppointment)
                                .findFirst()
                                .orElseThrow(() -> new Exception("Doctor not found!"));

                        System.out.print("Enter appointment date (YYYY-MM-DD): ");
                        String dateInput = scanner.nextLine();
                        Date appointmentDate = new Date(); // For simplicity, using current date
                        appointments.add(new Appointment(appointments.size() + 1, patient, doctor, appointmentDate));
                        System.out.println("Appointment scheduled successfully.");
                        break;

                    case 4: 
                        if (appointments.isEmpty()) {
                            System.out.println("No appointments scheduled.");
                        } else {
                            appointments.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        scanner.close();
    }
}
