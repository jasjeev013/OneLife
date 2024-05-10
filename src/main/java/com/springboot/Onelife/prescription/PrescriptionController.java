package com.springboot.Onelife.prescription;

import com.springboot.Onelife.patient.Patient;
import com.springboot.Onelife.patient.PatientId;
import com.springboot.Onelife.patient.PatientRepository;
import org.hibernate.annotations.Parent;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PrescriptionController {

    private PatientRepository patientRepository;
    private PrescriptionRepository prescriptionRepository;

    public PrescriptionController(PatientRepository patientRepository, PrescriptionRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

//    get all prescriptions by patient
    @GetMapping("hospitals/{hospitalId}/patients/{patientId}/prescriptions")
    public List<Prescription> getAllPrescriptions(@PathVariable int hospitalId,@PathVariable int patientId){
        return prescriptionRepository.findByPatient_PatientId(new PatientId(hospitalId,patientId));
    }

//    get prescription by ID
    @GetMapping("/hospitals/{hospitalId}/prescriptions/{prescriptionId}")
    public Optional<Prescription> getAllPrescriptionsById(@PathVariable int hospitalId,@PathVariable int prescriptionId){
        return prescriptionRepository.findPrescriptionByPrescriptionNumber(new PrescriptionId(hospitalId,prescriptionId));
    }

//    add prescription
    @PostMapping("/hospitals/{hospitalId}/patients/{patientId}/prescriptions")
    public void addPrescription(@PathVariable int hospitalId,@PathVariable int patientId, @RequestBody Prescription prescription){
        Optional<Patient> patient = patientRepository.findPatientByPatientId(new PatientId(hospitalId,patientId));
        if (patient.isPresent()){
            prescription.setPatient(patient.get());
            prescriptionRepository.save(prescription);
        }
    }

//    update prescription
    @PutMapping("/hospital/{hospitalId}/prescriptions/{prescriptionId}")
    public void updatePrescription(@PathVariable int hospitalId, @PathVariable int prescriptionId,@RequestBody Prescription prescription){
        prescription.setPrescriptionNumber(new PrescriptionId(hospitalId,prescriptionId));
        prescriptionRepository.save(prescription);
    }

//    delete prescription
    @DeleteMapping("/hospitals/{hospitalId}/prescriptions/{prescriptionId}")
    public void deletePrescription(@PathVariable int hospitalId,@PathVariable int prescriptionId){
        prescriptionRepository.deleteByPrescriptionNumber(new PrescriptionId(hospitalId,prescriptionId));
    }

}
