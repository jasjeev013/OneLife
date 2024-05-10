package com.springboot.Onelife.prescription;

import java.io.Serializable;
import java.util.Objects;

public class PrescriptionId implements Serializable {
    private int hospitalId;
    private int prescriptionId;

    public PrescriptionId(int hospitalId, int prescriptionId) {
        this.hospitalId = hospitalId;
        this.prescriptionId = prescriptionId;
    }

    public PrescriptionId() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionId that = (PrescriptionId) o;
        return hospitalId == that.hospitalId && prescriptionId == that.prescriptionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, prescriptionId);
    }
}
