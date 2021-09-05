package com.xeype.dao;

import com.xeype.db.DoctorDB;
import com.xeype.entity.Doctor;

public class DoctorArrImpl implements DoctorDao {

    private DoctorDB db = new DoctorDB();

    public void addDoctor(Doctor doctor) {
        db.addDoctor(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        db.updateDoctor(doctor);
    }

    public void removeDoctor(String id) {
        db.removeDoctor(id);
    }

    public Doctor getDoctorById(String id) {
        return db.getDoctorById(id);
    }

    public Doctor[] getAllDoctors() {
        return db.getAllDoctors();
    }
}
