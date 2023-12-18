package Repositories;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import exceptions.*;

import entities.*;

public class DoctorRepository {
    HashMap<String, Doctor>doctors = new HashMap<>();
    HashMap<Specialization, List<Doctor>> doctorsForSpecialization = new HashMap<>();

    private static DoctorRepository doctorRepository;
    private DoctorRepository() {}

    public static DoctorRepository createDoctorRepositoryInstance() {
        if(doctorRepository == null)
            doctorRepository = new DoctorRepository();
        return doctorRepository;
    }   

    public void registerDoctor(Doctor doctor) {
        if(doctors.containsKey(doctor.getDoctorId())) {
            throw new DoctorAlreadyPresentException();
        }
        doctors.put(doctor.getDoctorId(), doctor);
        if(doctorsForSpecialization.containsKey(doctor.getDoctorSpecialization())) {
            List<Doctor> existingDoctor = doctorsForSpecialization.get(doctor.getDoctorSpecialization());
            existingDoctor.add(doctor);
            doctorsForSpecialization.put(doctor.getDoctorSpecialization(), existingDoctor);
        }
        else {
            List<Doctor> newDoctorsList = new ArrayList<>();
            newDoctorsList.add(doctor);
            doctorsForSpecialization.put(doctor.getDoctorSpecialization(), newDoctorsList);
        }
        System.out.println("Doctor Registered Successfully, Doctor Id " + doctor.getDoctorId());
    }

    public void addAvailableSlots(Doctor doctor, TimeSlot timeSlot) {
        if(!doctors.containsKey(doctor.getDoctorId())) {
            System.out.println("Doctor Not present ");
        }
        HashMap<TimeSlot, Boolean> slots = doctor.getSlots();
        slots.put(timeSlot, true);
        doctor.setSlots(slots);
        System.out.println("Added Slots Successfully, Doctor id " + doctor.getDoctorId());
    }

    public void showAvailableSlotsBySpeciality(Specialization specialization) {
        for(HashMap.Entry<Specialization, List<Doctor>> entry: doctorsForSpecialization.entrySet()) {
            if(entry.getKey() == specialization) {
                System.out.println("Doctor of " + specialization + "has following available time slots ");
                List<Doctor> existingDoctor = entry.getValue();
                for(int i=0;i<existingDoctor.size();i++) {
                    Doctor doctor = existingDoctor.get(i);
                    HashMap<TimeSlot, Boolean> slots = doctor.getSlots();
                    System.out.println("Doctor id " + doctor.getDoctorId() + ", Doctor name " + doctor.getDoctorName() + " Slots: ");
                    for(HashMap.Entry<TimeSlot, Boolean> slot : slots.entrySet()) {
                        if(slot.getValue()) {
                            System.out.println("from: " + slot.getKey().getStartTime() + " to: " + slot.getKey().getendTime());
                        }
                    }
                }
                return;
            }
        }
    }

    public Boolean isDoctorRegistered(String id) {
        if(doctors.containsKey(id)) {
            return true;
        }
        return false;
    }
}
