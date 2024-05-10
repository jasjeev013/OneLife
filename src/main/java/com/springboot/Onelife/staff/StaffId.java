package com.springboot.Onelife.staff;

import java.io.Serializable;
import java.util.Objects;

public class StaffId implements Serializable {
    private int hospitalId;
    private int staffId;

    public StaffId(int hospitalId, int staffId) {
        this.hospitalId = hospitalId;
        this.staffId = staffId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public StaffId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffId staffId = (StaffId) o;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, staffId);
    }
}
