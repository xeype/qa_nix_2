package com.xeype.service;

import com.xeype.dao.DoctorArrImpl;
import com.xeype.dao.DoctorDao;
import com.xeype.entity.Doctor;

public class DoctorService {

    private DoctorDao dao = new DoctorArrImpl();

    public void addDoctor(Doctor doctor) {
        dao.addDoctor(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        dao.updateDoctor(doctor);
    }

    public void removeDoctor(String id) {
        dao.removeDoctor(id);
    }

    public Doctor getDoctorById(String id) {
        return dao.getDoctorById(id);
    }

    public Doctor[] getAllDoctors() {
        return dao.getAllDoctors();
    }
}
