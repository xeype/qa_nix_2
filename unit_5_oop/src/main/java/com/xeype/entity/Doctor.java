package com.xeype.entity;

public class Doctor extends BaseEntity {

    private String fullName;
    private String specialty;
    private byte age;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", age=" + age +
                " id=" + getId() +
                '}';
    }
}
