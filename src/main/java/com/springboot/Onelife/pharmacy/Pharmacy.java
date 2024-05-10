package com.springboot.Onelife.pharmacy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.patient.Patient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @EmbeddedId
    @Column(table = "pharmacy_id")
    private PharmacyId pharmacyId;

    @Column(name = "pharmacy_name")
    private String pharmacyName;

    @Column(name = "pharmacy_address")
    private String pharmacyAddress;

    @Column(name = "pharmacy_phone_number")
    private String pharmacyPhoneNumber;


    public Pharmacy(PharmacyId pharmacyId, String pharmacyName, String pharmacyAddress, String pharmacyPhoneNumber) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyPhoneNumber = pharmacyPhoneNumber;
    }

    public Pharmacy() {

    }

    @OneToMany(mappedBy = "pharmacy")
    @JsonIgnore
    private List<Patient> patients;

    public PharmacyId getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(PharmacyId pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyPhoneNumber() {
        return pharmacyPhoneNumber;
    }

    public void setPharmacyPhoneNumber(String pharmacyPhoneNumber) {
        this.pharmacyPhoneNumber = pharmacyPhoneNumber;
    }
}
