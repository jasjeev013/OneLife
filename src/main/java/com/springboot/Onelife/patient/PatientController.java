package com.springboot.Onelife.patient;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentRepository;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;

import com.springboot.Onelife.pharmacy.Pharmacy;
import com.springboot.Onelife.pharmacy.PharmacyId;
import com.springboot.Onelife.pharmacy.PharmacyRepository;
import com.springboot.Onelife.staff.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private PharmacyRepository pharmacyRepository;
    private PatientRepository patientRepository;

    public PatientController(PharmacyRepository pharmacyRepository, PatientRepository patientRepository) {
        this.pharmacyRepository = pharmacyRepository;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/hospitals/{hospId}/patients")
    public List<Patient> getAllPatientsOfHospital(@PathVariable int hospId){
        return patientRepository.findByPatientId_HospitalId(hospId);
    }

    @PostMapping("/hospitals/{hospId}/pharmacy/{pharmacyId}/patients")
    public void addPatient(@PathVariable int hospId, @PathVariable int pharmacyId, @RequestBody Patient patient){
        Optional<Pharmacy> pharmacy = pharmacyRepository.findByPharmacyId(new PharmacyId(hospId,pharmacyId));
        if (pharmacy.isPresent()){
            patient.setPharmacy(pharmacy.get());
            patientRepository.save(patient);
        }

    }

    @PutMapping("/hospitals/{hospId}/patients/{patientId}")
    public void updatePatient(@PathVariable int hospId,@PathVariable int patientId,@RequestBody Patient patient){
        patient.setPatientId(new PatientId(hospId,patientId));
        patientRepository.save(patient);
    }

    @DeleteMapping("/hospitals/{hospId}/patients/{patientId}")
    public void deletePatientOfHospital(@PathVariable int hospId,@PathVariable int patientId){
        patientRepository.deleteByPatientId(new PatientId(hospId,patientId));
    }





}
