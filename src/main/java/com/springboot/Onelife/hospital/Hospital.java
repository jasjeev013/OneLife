package com.springboot.Onelife.hospital;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.department.Department;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "hospital_id")
    private int hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_address")
    private String hospitalAddress;
    @Column(name = "hospital_phone_number")
    private String hospitalPhoneNumber;

    @Column(name = "hospital_state")
    private String hospitalState;

    @Column(name = "zip_code")
    private String zipCode;
    @JsonIgnore
    @OneToMany(mappedBy = "hospital")
    private List<Department> depts;

    public Hospital(int hospitalId, String hospitalName, String hospitalAddress, String hospitalPhoneNumber, String hospitalState, String zipCode) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.hospitalPhoneNumber = hospitalPhoneNumber;
        this.hospitalState = hospitalState;
        this.zipCode = zipCode;
    }

    public void setDepts(List<Department> depts) {
        this.depts = depts;
    }



    public Hospital() {

    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalPhoneNumber() {
        return hospitalPhoneNumber;
    }

    public void setHospitalPhoneNumber(String hospitalPhoneNumber) {
        this.hospitalPhoneNumber = hospitalPhoneNumber;
    }

    public String getHospitalState() {
        return hospitalState;
    }

    public void setHospitalState(String hospitalState) {
        this.hospitalState = hospitalState;
    }

    public List<Department> getDepts() {
        return depts;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
