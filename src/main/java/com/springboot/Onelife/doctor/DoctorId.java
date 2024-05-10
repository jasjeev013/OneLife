package com.springboot.Onelife.doctor;

import java.io.Serializable;
import java.util.Objects;

public class DoctorId implements Serializable {
    private int hospitalId;
    private int doctorId;

    public DoctorId(int hospitalId, int doctorId) {
        this.hospitalId = hospitalId;
        this.doctorId = doctorId;
    }

    public DoctorId() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorId doctorId1 = (DoctorId) o;
        return hospitalId == doctorId1.hospitalId && doctorId == doctorId1.doctorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, doctorId);
    }
}
