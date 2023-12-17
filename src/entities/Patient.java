package entities;

import java.util.*;

public class Patient {
    String patientName;
    String patientId;
    HashMap<Doctor, List<TimeSlot>> bookedSlots;

    public Patient(String patientName, String patientId, HashMap<Doctor, List<TimeSlot>> bookedSlots) {
        this.patientId= patientId;
        this.patientName = patientName;
        this.bookedSlots = bookedSlots;
    }

    public void setBookedSlots(HashMap<Doctor, List<TimeSlot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public HashMap<Doctor, List<TimeSlot>> getBookedSlots() {
        return this.bookedSlots;
    }
}
