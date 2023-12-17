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
        DoctorRepository doctorRepository = new DoctorRepository();
        DoctorService doctorService = new DoctorService(doctorRepository);
        Doctor doctor = new Doctor("dheeraj", "1", new HashMap<>(), Specialization.CARDIOLOGIST);
        doctorService.registerDoctor(doctor);

        Doctor doctor1 = new Doctor("neeru", "2", new HashMap<>(), Specialization.CARDIOLOGIST);
        doctorService.registerDoctor(doctor1);

        Doctor doctor2 = new Doctor("ram", "3", new HashMap<>(), Specialization.DERMATOLOGIST);
        doctorService.registerDoctor(doctor2);

        doctorService.addAvailableSlots(doctor, new TimeSlot("9:00", "9:30"));
        doctorService.addAvailableSlots(doctor, new TimeSlot("9:30", "10:00"));
        doctorService.addAvailableSlots(doctor, new TimeSlot("4:00", "4:30"));

        doctorService.addAvailableSlots(doctor1, new TimeSlot("11:00", "11:30"));
        doctorService.addAvailableSlots(doctor1, new TimeSlot("11:30", "12:00"));
        doctorService.addAvailableSlots(doctor1, new TimeSlot("5:00", "5:30"));

        doctorService.addAvailableSlots(doctor2, new TimeSlot("12:00", "12:30"));
        doctorService.addAvailableSlots(doctor2, new TimeSlot("3:30", "4:00"));

        System.out.println("");
        doctorService.showAvailableSlotsBySpeciality(Specialization.CARDIOLOGIST);

        PatientRepository patientRepository = new PatientRepository();
        PatientService patientService = new PatientService(patientRepository);
        Patient patient = new Patient("soma", "1", new HashMap<>());
        patientService.registerPatient(patient);

        BookingService bookingService = new BookingService();
    }
}
