package com.springboot.Onelife.patient;

import com.springboot.Onelife.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    public Optional<Patient> findPatientByPatientId(PatientId patientId);
    public List<Patient> findByPatientId_HospitalId(int hospitalId);
    public void deleteByPatientId(PatientId patientId);

}
