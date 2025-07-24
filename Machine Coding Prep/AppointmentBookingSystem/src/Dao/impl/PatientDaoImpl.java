package Dao.impl;

import model.Patient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class PatientDaoImpl {

    Map<UUID, Patient> patientMap = new HashMap<>();

    public void register(String patientName) {
        Patient patient = new Patient(patientName);
        patientMap.put(patient.getPatientId(), patient);
    }

    public Optional<Patient> getPatientWithName(String patientName) {
        return patientMap.values().stream().filter(patient -> patient.getPatientName().equals(patientName)).findFirst();
    }
}
