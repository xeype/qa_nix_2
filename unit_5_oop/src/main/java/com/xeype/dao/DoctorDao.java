package com.xeype.dao;

import com.xeype.entity.Doctor;

public interface DoctorDao {

    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void removeDoctor(String id);
    Doctor getDoctorById(String id);
    Doctor[] getAllDoctors();
}
