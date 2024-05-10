package com.springboot.Onelife.prescription;

import com.springboot.Onelife.patient.Patient;
import jakarta.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @EmbeddedId
    @Column(name = "prescription_number")
    private PrescriptionId prescriptionNumber;
    @Column(name = "medication_name")
    private String medicationName;
    @Column(name = "prescription_date")
    private String prescriptionDate;
    @Column(name = "prescription_cost")
    private String prescriptionCost;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;


    public Prescription(PrescriptionId prescriptionNumber, String medicationName, String prescriptionDate, String prescriptionCost) {
        this.prescriptionNumber = prescriptionNumber;
        this.medicationName = medicationName;
        this.prescriptionDate = prescriptionDate;
        this.prescriptionCost = prescriptionCost;
    }

    public Prescription() {

    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PrescriptionId getPrescriptionNumber() {
        return prescriptionNumber;
    }

    public void setPrescriptionNumber(PrescriptionId prescriptionNumber) {
        this.prescriptionNumber = prescriptionNumber;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getPrescriptionCost() {
        return prescriptionCost;
    }

    public void setPrescriptionCost(String prescriptionCost) {
        this.prescriptionCost = prescriptionCost;
    }
}
