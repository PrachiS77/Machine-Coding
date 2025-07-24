package Dao;

import model.Appointment;
import model.TimeSlot;

import java.util.List;
import java.util.UUID;

public interface DoctorDao {

    void registerDoctor(String doctorName, String specialization);

    void setAvailableSlots(TimeSlot slot, UUID doctorId);

    List<TimeSlot> getAvailableSlots(String doctorName);

    void addAppointment(Appointment appointment);

}
