package com.xeype.controller;

import com.xeype.entity.Doctor;
import com.xeype.service.DoctorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoctorController {

    private DoctorService doctorService = new DoctorService();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        byte choice = 1;

        System.out.println("----- START -----");

        while (choice != 0) {
            System.out.print("\nEnter the action!\n"
                    + "1 - Add doctor\n"
                    + "2 - Update doctor\n"
                    + "3 - Remove doctor\n"
                    + "4 - Get doctor by ID\n"
                    + "5 - Get all doctors\n"
                    + "\n0 - Exit\n\nAction: ");


            try {
                choice = (byte) Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 0: {
                    System.out.println("\n----- END -----");
                }
                break;
                case 1:
                    addDoctor(reader);
                    break;
                case 2:
                    updateDoctor(reader);
                    break;
                case 3:
                    removeDoctor(reader);
                    break;
                case 4:
                    getDoctorById(reader);
                    break;
                case 5:
                    getAllDoctors(reader);
                    break;
                default: {
                    System.out.println("\nPlease enter the correct action: ");
                }
            }
        }
    }

    public void addDoctor(BufferedReader reader) {
        try {
            System.out.println("Please enter the doctor's full name: ");
            String fullName = reader.readLine();
            System.out.println("Please enter the doctor's specialty: ");
            String specialty = reader.readLine();
            System.out.println("Please enter the doctor's age: ");
            String age = reader.readLine();
            byte ageByte = Byte.parseByte(age);
            Doctor doctor = new Doctor();
            doctor.setFullName(fullName);
            doctor.setAge(ageByte);
            doctor.setSpecialty(specialty);
            doctorService.addDoctor(doctor);
        } catch (IOException e) {
            System.out.println("error = " + e.getMessage());
        }

    }

    public void updateDoctor(BufferedReader reader) {
        try {
            System.out.println("Please enter the doctor's id: ");
            String id = reader.readLine();
            System.out.println("Please enter the doctor's full name: ");
            String fullName = reader.readLine();
            System.out.println("Please enter the doctor's specialty: ");
            String specialty = reader.readLine();
            System.out.println("Please enter the doctor's age: ");
            String age = reader.readLine();
            byte ageByte = Byte.parseByte(age);
            Doctor doctor = new Doctor();
            doctor.setId(id);
            doctor.setFullName(fullName);
            doctor.setSpecialty(specialty);
            doctor.setAge(ageByte);
            doctorService.updateDoctor(doctor);
        } catch (IOException e) {
            System.out.println("error = " + e.getMessage());
        }
    }

    public void removeDoctor(BufferedReader reader) {
        try {
            System.out.println("Please enter the doctor's id: ");
            String id = reader.readLine();
            doctorService.removeDoctor(id);
        } catch (IOException e) {
            System.out.println("error = " + e.getMessage());
        }
    }

    public void getDoctorById(BufferedReader reader) {
        Doctor[] doctors = doctorService.getAllDoctors();
        try {
            System.out.println("Please enter the doctor's id: ");
            String id = reader.readLine();
            Doctor doctor = doctorService.getDoctorById(id);
            System.out.println("doctor = " + doctor);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("error = " + e.getMessage());
        }
    }

    public void getAllDoctors(BufferedReader reader) {
        Doctor[] doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println("doctor = " + doctor);
        }
    }
}
