package Services;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import Repositories.DoctorRepository;
import entities.*;

public class DoctorService {
    
    DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void registerDoctor(Doctor doctor) {
        doctorRepository.registerDoctor(doctor);
    }

    public void addAvailableSlots(Doctor doctor, TimeSlot timeSlot) {
        String startTime = timeSlot.getStartTime();
        String endTime = timeSlot.getendTime();

        String[] time = startTime.split(":");
        LocalTime start = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
        time = endTime.split(":");
        LocalTime end = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

        if(ChronoUnit.MINUTES.between(start, end) > 30) {
            System.err.println("Please Book Slots of 30 mins only");
        }
        doctorRepository.addAvailableSlots(doctor, timeSlot);
    }

    public void showAvailableSlotsBySpeciality(Specialization specialization) {
        doctorRepository.showAvailableSlotsBySpeciality(specialization);
    }
}
