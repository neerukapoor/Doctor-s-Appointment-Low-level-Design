package Services;

import Repositories.PatientRepository;
import entities.*;

public class PatientService {

    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
    }

    public void registerPatient(Patient patient) {
        patientRepository.registerPatient(patient);
    }
}
