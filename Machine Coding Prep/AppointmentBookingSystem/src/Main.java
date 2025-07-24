import Dao.DoctorDao;
import Dao.impl.DoctorDaoImpl;
import Dao.impl.PatientDaoImpl;
import service.impl.AppointmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.PatientServiceImpl;

public class Main {
    public static void main(String[] args) {

        DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        PatientDaoImpl patientDao = new PatientDaoImpl();

        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl(doctorDao, patientDao);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorDao);
        PatientServiceImpl patientService = new PatientServiceImpl(patientDao);
        System.out.println("Hello Welcome to the Portal!");

        doctorService.register("Dr. Curious", "cardiologist");
        doctorService.getAllRegistredDoctors();

        doctorService.markAvailability("09:00", "10:00", "Dr. Curious");
        doctorService.markAvailability("09:30", "10:00", "Dr. Curious");
        doctorService.markAvailability("12:30", "13:00", "Dr. Curious");
        doctorService.markAvailability("16:30", "17:00", "Dr. Curious");

        doctorService.register("Dr. Dreadful", "dermatologist");
        doctorService.markAvailability("09:30", "10:00", "Dr. Dreadful");
        doctorService.markAvailability("12:30", "13:00", "Dr. Dreadful");
        doctorService.markAvailability("16:30", "17:00", "Dr. Dreadful");

        patientService.register("PatientA");

        doctorService.getAllAvailableSlots("Dr. Curious");
        doctorService.getAllAvailableSlots("Dr. Dreadful");








    }
}