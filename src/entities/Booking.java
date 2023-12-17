package entities;

public class Booking {
    String bookingId;
    Doctor doctor;
    Patient patient;
    TimeSlot timeSlot;
    Boolean waitList;

    public Booking(String bookingId, Doctor doctor, Patient patient, TimeSlot timeSlot) {
        this.bookingId = bookingId;
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.waitList = false;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Boolean getWaitList() {
        return waitList;
    }

}
