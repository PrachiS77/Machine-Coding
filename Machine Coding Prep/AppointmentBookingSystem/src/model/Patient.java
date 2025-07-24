package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Patient {

    UUID patientId;
    String patientName;
    List<Appointment> appointmentList = new ArrayList<>();

    public Patient(String patientName) {
        this.patientName = patientName;
        this.patientId = UUID.randomUUID();
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
