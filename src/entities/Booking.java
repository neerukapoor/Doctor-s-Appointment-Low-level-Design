package entities;

import java.sql.Time;

import javax.print.Doc;

public class Booking {
    Integer bookingId;
    Doctor doctor;
    Patient patient;
    TimeSlot timeSlot;

    public Booking(Integer bookingId, Doctor doctor, Patient patient, TimeSlot timeSlot) {
        this.bookingId = bookingId;
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }
}
