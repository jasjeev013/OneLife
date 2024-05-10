package com.springboot.Onelife.appointment;

import com.springboot.Onelife.doctor.Doctor;
import com.springboot.Onelife.doctor.DoctorId;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment,AppointmentId> {
    public List<Appointment> findByAppointmentId_HospitalIdAndAppointmentId_PatientId(int doctorId,int patientId);
    public List<Appointment> findByAppointmentId_DoctorIdAndAppointmentId_HospitalId(int doctorId,int hospitalId);
    public void deleteByAppointmentId(AppointmentId appointmentId);
}
