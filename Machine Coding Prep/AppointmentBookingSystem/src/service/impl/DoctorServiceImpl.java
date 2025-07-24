package service.impl;

import Dao.DoctorDao;
import Dao.impl.DoctorDaoImpl;
import enums.Specialization;
import model.TimeSlot;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorServiceImpl {

    public DoctorServiceImpl(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    DoctorDaoImpl doctorDao;

    public void register(String doctorName, String specialization) {
        doctorDao.registerDoctor(doctorName, specialization);
    }

    public List<String> getAllRegistredDoctors() {

        List<String> all = doctorDao.getAllDoctors();
        System.out.println(all);
        return all;

    }

    public void markAvailability(String startTime, String endTime, String doctor) {

        LocalTime end = LocalTime.parse(endTime);
        LocalTime start = LocalTime.parse(startTime);

        if (Duration.between(start, end).toMinutes() > 30) {
            System.out.println("Sorry " + doctor + " slots are 30 mins only");
            return;
        }
        doctorDao.setAvailableSlots(new TimeSlot(start, end), doctorDao.getDoctorFromName(doctor).get().getDoctorId());
    }

    public List<String> getAllAvailableSlots(String doctorName) {

        System.out.println("All available slots for " + doctorName + " are : ");
        List<TimeSlot> slots = doctorDao.getAvailableSlots(doctorName);
        List<String> data = slots.stream().map(timeSlot -> {
            String slot = timeSlot.getStartTime() + " to " + timeSlot.getEndTime();
            return slot;
        }).collect(Collectors.toList());
        System.out.println(data);
        return data;
    }

    public String showDoctorBySpecialization(String specialization) {

        return doctorDao.getDoctorBySpecialization(specialization);
    }
}
