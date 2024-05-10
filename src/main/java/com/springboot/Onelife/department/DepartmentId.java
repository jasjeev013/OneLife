package com.springboot.Onelife.department;

import org.hibernate.annotations.SecondaryRow;

import java.io.Serializable;
import java.util.Objects;

public class DepartmentId implements Serializable {

    private int departmentId;
    private int hospitalId;

    public DepartmentId(int departmentId, int hospitalId) {
        this.departmentId = departmentId;
        this.hospitalId = hospitalId;
    }

    public DepartmentId() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        DepartmentId that = (DepartmentId) o;
        return departmentId == that.departmentId && hospitalId == that.hospitalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, hospitalId);
    }
}
