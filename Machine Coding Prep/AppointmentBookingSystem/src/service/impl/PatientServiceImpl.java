package service.impl;

import Dao.impl.PatientDaoImpl;

public class PatientServiceImpl {

    PatientDaoImpl patientDao;

    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    public void register(String patientName) {
        patientDao.register(patientName);
        System.out.println(patientName + " registered successfully!!");
    }
}
