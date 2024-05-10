package com.springboot.Onelife.pharmacy;

import java.io.Serializable;
import java.util.Objects;

public class PharmacyId implements Serializable {
    private int hospitalId;
    private int pharmacyId;

    public PharmacyId(int hospitalId, int pharmacyId) {
        this.hospitalId = hospitalId;
        this.pharmacyId = pharmacyId;
    }

    public PharmacyId() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyId that = (PharmacyId) o;
        return hospitalId == that.hospitalId && pharmacyId == that.pharmacyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, pharmacyId);
    }
}
