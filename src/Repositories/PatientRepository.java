package Repositories;

import java.util.HashMap;
import entities.*;

public class PatientRepository {
    HashMap<String, Patient>patients = new HashMap<>();

    static PatientRepository patientRepository;

    private PatientRepository() {}

    public static PatientRepository createPatientRepository() {
        if(patientRepository == null)
            patientRepository = new PatientRepository();
        return patientRepository;
    }

    public void registerPatient(Patient patient) {
        if(patients.containsKey(patient.getPatientId()))
        {
            System.out.println("Patient with this id already present");
        }
        patients.put(patient.getPatientId(), patient);
        System.out.println("Patient registered successfully");
    }

    public Boolean isPatientRegistered(String id) {
        if(patients.containsKey(id)) {
            return true; 
        }
        return false;
    }
}
