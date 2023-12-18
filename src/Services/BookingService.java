package Services;

import java.sql.Time;
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
    HashMap<Integer, Booking> bookings = new HashMap<>();
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
        HashMap<TimeSlot, Boolean> doctorSlots = doctor.getSlots();
        for(HashMap.Entry<TimeSlot, Boolean> slots: doctorSlots.entrySet()) {
            if(timeSlot.getStartTime() == slots.getKey().getStartTime() && slots.getValue()) {
                HashMap<TimeSlot, Boolean> newSlotList = new HashMap<>();
                for(HashMap.Entry<TimeSlot, Boolean> existingSlots : doctorSlots.entrySet()) {
                    if(existingSlots.getKey().getStartTime() != timeSlot.getStartTime()) {
                        newSlotList.put(existingSlots.getKey(), existingSlots.getValue());
                    }
                    else {
                        newSlotList.put(existingSlots.getKey(), false);
                    }
                }
                doctor.setSlots(newSlotList);
                Booking booking = new Booking(index++, doctor, patient, timeSlot);
                bookings.put(booking.getBookingId(), booking);
                System.out.println("Booked successfully, your booking id: " + booking.getBookingId());
                return;
            }
            else if(timeSlot.getStartTime() == slots.getKey().getStartTime() && !slots.getValue()){
                System.out.println("Doctor not available at this time slot ");
                return;
            }
        }
        System.out.println("Doctor not available at this time");
    }

    public void showAllBookings() {
        for(HashMap.Entry<Integer, Booking> booking: bookings.entrySet()) {
            System.out.println("Booking id: " + booking.getKey() + ", Doctor Name: " + booking.getValue().getDoctor().getDoctorName() + ", at time: " + booking.getValue().getTimeSlot().getStartTime() + " to " + booking.getValue().getTimeSlot().getendTime() + ", Patient Name: " + booking.getValue().getPatient().getPatientName());
        }
    }
}
