package Dao.impl;

import Dao.DoctorDao;
import model.Appointment;
import model.Doctor;
import model.TimeSlot;

import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;

public class DoctorDaoImpl implements DoctorDao {

    HashMap<UUID, Doctor> doctorMap = new HashMap<>();
    @Override
    public void registerDoctor(String doctorName, String specialization) {
        Doctor doctor = new Doctor(doctorName, specialization);
        doctorMap.put(doctor.getDoctorId(), doctor);
        System.out.println("Welcome " + doctorName + "!!");

    }

    @Override
    public void setAvailableSlots(TimeSlot slots, UUID doctorId) {
        Doctor doctor = doctorMap.get(doctorId);
        doctor.getAvailableSlots().add(slots);
    }

    @Override
    public List<TimeSlot> getAvailableSlots(String doctorName) {

        Doctor doctor = doctorMap.get(getDoctorFromName(doctorName));

        return doctor.getAvailableSlots().stream()
                .filter(TimeSlot::isAvailable)
                .collect(Collectors.toList());
    }

    @Override
    public void addAppointment(Appointment appointment) {

        doctorMap.get(appointment.getDoctor().getId()).getAppointment().add(appointment);


    }

    public Optional<Doctor> getDoctorFromName(String doctorName) {
        Optional<Doctor> result =  doctorMap.values().stream()
                .filter(doctor -> doctor.getDoctorName().equals(doctorName)).findFirst();

        return result;
    }

    public List<String> getAllDoctors() {

        return doctorMap.values().stream().map(Doctor::getDoctorName).collect(Collectors.toList());
    }

    public String getDoctorBySpecialization(String specialization) {

        Optional<Doctor> specializedDoctor = doctorMap.values().stream().filter(doctor -> doctor
                .getSpecialization().toString().equals(specialization)).findFirst();
        return specializedDoctor.get().getDoctorName();
    }
}
