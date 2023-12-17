package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Repositories.DoctorRepository;
import Repositories.PatientRepository;
import entities.Doctor;
import entities.Patient;
import entities.TimeSlot;
import entities.Booking;

public class BookingService {
    DoctorRepository doctorRepository;
    PatientRepository patientRepository;
    HashMap<String, Booking> bookings = new HashMap<>();
    Map<String, List<TimeSlot>> patientSlots = new HashMap<>();

    static int index = 1;

    public BookingService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void registerBooking(Patient patient, Doctor doctor, TimeSlot timeSlot) {
        if(!patientRepository.isPatientRegistered(patient.getPatientId())) {
            // implement exception
            System.out.println("Patient doesn't registered ");
        }
        if(!doctorRepository.isDoctorRegistered(doctor.getDoctorId())) {
            //implement exception
            System.out.println("Doctor doesn't exsit");
        }
        if(patientSlots.containsKey(patient.getPatientId())) {
            for(TimeSlot slot:patientSlots.get(patient.getPatientId())) {
                if(slot.getStartTime() == timeSlot.getStartTime())
                {
                    //implement exception
                    System.out.println("Patient already booked for this time slot");
                    return;
                }
            } 
        }
        else {
            patientSlots.put(patient.getPatientId(), new ArrayList<>());
        }

        // work from here

    }

}
