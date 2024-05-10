package com.springboot.Onelife.appointment;

import java.io.Serializable;
import java.util.Objects;

public class AppointmentId implements Serializable {

    private int patientId;
    private int doctorId;
    private int hospitalId;

    public AppointmentId(int patientId, int doctorId, int hospitalId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
    }

    public AppointmentId() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentId that = (AppointmentId) o;
        return patientId == that.patientId && doctorId == that.doctorId && hospitalId == that.hospitalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, doctorId, hospitalId);
    }
}
