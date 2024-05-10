package com.springboot.Onelife.department;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.doctor.Doctor;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.staff.Staff;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @EmbeddedId
    @Column(name = "department_id")
    private DepartmentId departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Staff> staff;


    public Department(DepartmentId departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department() {

    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }


    public DepartmentId getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentId departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctors = doctors;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
