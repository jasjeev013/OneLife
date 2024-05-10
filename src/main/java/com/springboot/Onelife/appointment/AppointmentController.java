package com.springboot.Onelife.appointment;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentRepository;
import com.springboot.Onelife.doctor.Doctor;
import com.springboot.Onelife.doctor.DoctorId;
import com.springboot.Onelife.doctor.DoctorRepository;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;
import com.springboot.Onelife.patient.Patient;
import com.springboot.Onelife.patient.PatientId;
import com.springboot.Onelife.patient.PatientRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    public AppointmentController(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    //    get all by doctor
    @GetMapping("/hospitals/{hospId}/doctors/{docId}/appointments")
    public List<Appointment> getAllAppointmentOfDoctor(@PathVariable int hospId,@PathVariable int docId){
        return appointmentRepository.findByAppointmentId_DoctorIdAndAppointmentId_HospitalId(docId,hospId);
    }

    // get all by patient
    @GetMapping("/hospitals/{hospId}/appointments/{patientId}")
    public List<Appointment> getAppointmentOfDoctor(@PathVariable int hospId,@PathVariable int patientId){
        return appointmentRepository.findByAppointmentId_HospitalIdAndAppointmentId_PatientId(hospId,patientId);
    }


    @GetMapping("hospital/{hospId}/patient/{patientId}/appointments/{doctorId}")
    public Optional<Appointment> getAppointmentOfPatient(@PathVariable int hospId,@PathVariable int patientId,@PathVariable int doctorId){
        return appointmentRepository.findById(new AppointmentId(patientId,doctorId,hospId));
    }

    @PostMapping("/hospitals/{hospId}/doctors/{docId}/patients/{patientId}")
    public void addAppointment(@PathVariable int hospId,@PathVariable int docId, @PathVariable int patientId, @RequestBody Appointment appointment){
        appointment.setDoctor(doctorRepository.findDoctorByDoctorId(new DoctorId(hospId,docId)).get());
        appointment.setPatient(patientRepository.findPatientByPatientId(new PatientId(hospId,patientId)).get());
        appointment.setAppointmentId(new AppointmentId(patientId,docId,hospId));
        appointmentRepository.save(appointment);
    }

    @PutMapping("hospital/{hospitalId}/doctor/{doctorId}/patient/{patientId}")
    public void updateAppointment(@PathVariable int hospitalId,@PathVariable int doctorId,@PathVariable int patientId,@RequestBody Appointment appointment){
        appointment.setAppointmentId(new AppointmentId(patientId,doctorId,hospitalId));
        appointmentRepository.save(appointment);
    }


    @DeleteMapping("/hospital/{hospitalId}/doctors/{doctorId}/patients/{patientId}")
    public void deleteAppointment(@PathVariable int hospitalId,@PathVariable int doctorId,@PathVariable int patientId){
        appointmentRepository.deleteByAppointmentId(new AppointmentId(patientId,doctorId,hospitalId));
    }
}
