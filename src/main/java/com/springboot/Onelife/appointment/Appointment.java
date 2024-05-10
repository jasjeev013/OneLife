package com.springboot.Onelife.appointment;

import com.springboot.Onelife.doctor.Doctor;
import com.springboot.Onelife.patient.Patient;
import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @EmbeddedId
    @Column(name = "appointment_id")
    private AppointmentId appointmentId;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    
    public Appointment(AppointmentId appointmentId, String date, String time) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
    }

    public Appointment() {

    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(AppointmentId appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
