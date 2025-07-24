package model;

import enums.Specialization;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {

    UUID doctorId;
    String doctorName;
    Specialization specialization;
    int Rank;
    List<Appointment> appointment = new ArrayList<>();
    List<TimeSlot> timeSlots = new ArrayList<>();

    public Doctor(String doctorName, String specilization) {
        this.doctorId = UUID.randomUUID();
        this.doctorName = doctorName;
        this.specialization = Specialization.fromString(specilization);
    }


    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public List<TimeSlot> getAvailableSlots() {
        return timeSlots;
    }

    public void setAvailableSlots(List<TimeSlot> availableSlots) {
        this.timeSlots = availableSlots;
    }
}
