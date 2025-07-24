package model;

import java.util.HashSet;
import java.util.UUID;

public class Appointment {

    TimeSlot slot;

    boolean isAvailable = true;

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    Doctor doctorId;

    Patient patientId;

    HashSet<UUID> waitList = new HashSet<>();

    public Appointment(TimeSlot slot, Doctor doctorId, Patient patientId) {
        this.slot = slot;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public HashSet<UUID> getWaitList() {
        return waitList;
    }

    public void setWaitList(HashSet<UUID> waitList) {
        this.waitList = waitList;
    }
}
