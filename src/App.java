import java.util.*;

import Repositories.DoctorRepository;
import Repositories.PatientRepository;
import Services.BookingService;
import Services.DoctorService;
import Services.PatientService;
import entities.Doctor;
import entities.Patient;
import entities.TimeSlot;
import entities.Specialization;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner s = new Scanner(System.in);
        DoctorRepository doctorRepository = DoctorRepository.createDoctorRepositoryInstance();
        DoctorRepository doctorRepository1 = DoctorRepository.createDoctorRepositoryInstance();
        DoctorService doctorService = new DoctorService(doctorRepository);
        Doctor doctor1 = new Doctor("dheeraj", "1", new HashMap<>(), Specialization.CARDIOLOGIST);
        doctorService.registerDoctor(doctor1);

        Doctor doctor2 = new Doctor("neeru", "2", new HashMap<>(), Specialization.CARDIOLOGIST);
        doctorService.registerDoctor(doctor2);

        Doctor doctor3 = new Doctor("ram", "3", new HashMap<>(), Specialization.DERMATOLOGIST);
        doctorService.registerDoctor(doctor3);

        doctorService.addAvailableSlots(doctor1, new TimeSlot("9:00", "9:30"));
        doctorService.addAvailableSlots(doctor1, new TimeSlot("9:30", "10:00"));
        doctorService.addAvailableSlots(doctor1, new TimeSlot("4:00", "4:30"));

        doctorService.addAvailableSlots(doctor2, new TimeSlot("11:00", "11:30"));
        doctorService.addAvailableSlots(doctor2, new TimeSlot("11:30", "12:00"));
        doctorService.addAvailableSlots(doctor2, new TimeSlot("5:00", "5:30"));

        doctorService.addAvailableSlots(doctor3, new TimeSlot("12:00", "12:30"));
        doctorService.addAvailableSlots(doctor3, new TimeSlot("3:30", "4:00"));

        System.out.println("");
        doctorService.showAvailableSlotsBySpeciality(Specialization.CARDIOLOGIST);

        PatientRepository patientRepository = PatientRepository.createPatientRepository();
        PatientService patientService = new PatientService(patientRepository);

        Patient patient = new Patient("soma", "1", new HashMap<>());
        patientService.registerPatient(patient);

        Patient patient1 = new Patient("neha", "2", new HashMap<>());
        patientService.registerPatient(patient1);

        PatientRepository patientRepository1 = PatientRepository.createPatientRepository();
        BookingService bookingService = new BookingService(doctorRepository1, patientRepository1);
        bookingService.registerBooking(patient1, doctor3, new TimeSlot("12:00", "12:30"));
        bookingService.registerBooking(patient, doctor3, new TimeSlot("12:00", "12:30"));

        bookingService.showAllBookings();
    }
}
