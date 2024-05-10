package com.springboot.Onelife.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.appointment.Appointment;
import com.springboot.Onelife.department.Department;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @EmbeddedId
    @Column(name = "doctor_id")
    private DoctorId doctorId;
    @Column(name = "doctor_f_name")
    private String doctorFName;
    @Column(name = "doctor_l_name")
    private String doctorLName;

    @Column(name="doctor_phone_number")
    private String doctorPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointments;



    public Doctor(DoctorId doctorId, String doctorFName, String doctorLName, String doctorPhoneNumber) {
        this.doctorId = doctorId;
        this.doctorFName = doctorFName;
        this.doctorLName = doctorLName;
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public Doctor() {

    }

    public List<Appointment> getAppointments() {
        return appointments;
    }


    public DoctorId getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(DoctorId doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorFName() {
        return doctorFName;
    }

    public void setDoctorFName(String doctorFName) {
        this.doctorFName = doctorFName;
    }

    public String getDoctorLName() {
        return doctorLName;
    }

    public void setDoctorLName(String doctorLName) {
        this.doctorLName = doctorLName;
    }



    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }
}
