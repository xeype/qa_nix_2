package com.xeype.db;

import com.xeype.entity.Doctor;

import java.util.UUID;

public class DoctorDB {

    private Doctor[] doctors = new Doctor[0];

    public void addDoctor(Doctor doctor) {
        doctor.setId(generateId());
        boolean availableSpace = false;
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] == null) {
                doctors[i] = doctor;
                availableSpace = true;
                break;
            }
        }
        if (!availableSpace) {
            Doctor[] increasedDoctors = new Doctor[doctors.length + 1];
            for (int i = 0; i < doctors.length; i++) {
                increasedDoctors[i] = doctors[i];
            }
            increasedDoctors[doctors.length] = doctor;
            doctors = increasedDoctors;
        }
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Doctor doctor : doctors) {
            if (doctor != null && doctor.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private int findPosition(String id) {
        int position = -1;
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] != null && doctors[i].getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public Doctor[] getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(String id) {
        int position = findPosition(id);
        return doctors[position];
    }

    public void updateDoctor(Doctor doctor) {
        int position = findPosition(doctor.getId());
        doctors[position].setFullName(doctor.getFullName());
        doctors[position].setAge(doctor.getAge());
        doctors[position].setSpecialty(doctor.getSpecialty());
    }

    public void removeDoctor(String id) {
        int position = findPosition(id);
        if (position == doctors.length - 1) {
            doctors[position] = null;
        } else {
            for (int i = position; i < doctors.length - 2; i++) {
                doctors[i] = doctors[i + 1];
            }
        }

        if (doctors.length > 1) {
            Doctor[] newDoctors = new Doctor[doctors.length - 1];
            for (int i = 0; i < newDoctors.length; i++) {
                newDoctors[i] = doctors[i];
            }
            doctors = newDoctors;
        }
    }
}
