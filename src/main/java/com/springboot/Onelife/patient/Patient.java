package com.springboot.Onelife.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.appointment.Appointment;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.invoice.Invoice;
import com.springboot.Onelife.pharmacy.Pharmacy;
import com.springboot.Onelife.prescription.Prescription;
import com.springboot.Onelife.room.Room;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @EmbeddedId
    @Column(name = "patient_id")
    private PatientId patientId;

    @Column(name = "patient_f_name")
    private String patientFName;

    @Column(name = "patient_l_name")
    private String patientLName;

    @Column(name = "patient_address")
    private String patientAddress;
    @Column(name = "patient_phone_number")
    private String patientPhoneNumber;



    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Prescription> prescriptions;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Invoice> invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;


    public Patient(PatientId patientId, String patientFName, String patientLName, String patientAddress, String patientPhoneNumber) {
        this.patientId = patientId;
        this.patientFName = patientFName;
        this.patientLName = patientLName;
        this.patientAddress = patientAddress;
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public Patient() {

    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public PatientId getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientId patientId) {
        this.patientId = patientId;
    }

    public String getPatientFName() {
        return patientFName;
    }

    public void setPatientFName(String patientFName) {
        this.patientFName = patientFName;
    }

    public String getPatientLName() {
        return patientLName;
    }

    public void setPatientLName(String patientLName) {
        this.patientLName = patientLName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }
}
