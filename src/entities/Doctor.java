package entities;

import java.util.HashMap;

public class Doctor {
    String doctorName;
    String doctorId;
    HashMap<TimeSlot, Boolean> slots;
    Specialization specialization;
    Integer rating;

    public Doctor(String doctorName, String doctorId, HashMap<TimeSlot, Boolean>slots, Specialization specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.slots = slots;
        this.specialization = specialization;
    }

    public void setSlots(HashMap<TimeSlot, Boolean> slot) {
        this.slots = slots;
    }

    public String getDoctorId() {
        return this.doctorId;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public Specialization getDoctorSpecialization() {
        return this.specialization;
    }

    public Integer getRating() {
        return this.rating;
    }

    public HashMap<TimeSlot, Boolean> getSlots() {
        return this.slots;
    }
}
