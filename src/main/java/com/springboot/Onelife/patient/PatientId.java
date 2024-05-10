package com.springboot.Onelife.patient;

import java.io.Serializable;
import java.util.Objects;

public class PatientId implements Serializable {
    private int hospitalId;
    private int patientId;

    public PatientId(int hospitalId, int patientId) {
        this.hospitalId = hospitalId;
        this.patientId = patientId;
    }

    public PatientId() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientId patientId1 = (PatientId) o;
        return hospitalId == patientId1.hospitalId && patientId == patientId1.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, patientId);
    }
}
