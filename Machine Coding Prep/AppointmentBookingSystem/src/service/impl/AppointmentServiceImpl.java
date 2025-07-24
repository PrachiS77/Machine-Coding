package service.impl;

import Dao.DoctorDao;
import Dao.impl.DoctorDaoImpl;
import Dao.impl.PatientDaoImpl;
import model.Appointment;
import model.Doctor;
import model.Patient;
import model.TimeSlot;

import java.util.Objects;
import java.util.Optional;

public class AppointmentServiceImpl {

    DoctorDaoImpl doctorDao;

    PatientDaoImpl patientDao;


    public AppointmentServiceImpl(DoctorDaoImpl doctorDao, PatientDaoImpl patientDao) {
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
    }

    public void bookAppointment(String startTime, String endTime, String doctorName, String patientName) {
        Optional<TimeSlot> slot = doctorDao.getAvailableSlots(doctorName).stream().filter(timeSlot ->
            (Objects.equals(timeSlot.getStartTime().toString(), startTime) &&
                    Objects.equals(timeSlot.getEndTime().toString(), endTime))).findFirst();


        if (!slot.isPresent())
            System.out.println("No available slot for the " + doctorName);

        if (!slot.get().isAvailable()) {

        }

        Optional<Patient> patient = patientDao.getPatientWithName(patientName);

        if (!patient.isPresent())
            System.out.println("No patient registered with the name" + patientName);

        Optional<Doctor> doctor = doctorDao.getDoctorFromName(doctorName);

        if (!doctor.isPresent())
            System.out.println("No doctor found for the " + doctorName);

        Appointment appointment = new Appointment(slot.get(), doctor.get(), patient.get());
        slot.get().setAvailable(false);

        doctor.get().getAppointment().add(appointment);

        patient.get().getAppointmentList().add(appointment);


    }
}
