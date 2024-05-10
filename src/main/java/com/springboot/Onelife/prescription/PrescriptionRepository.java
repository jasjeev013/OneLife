package com.springboot.Onelife.prescription;

import com.springboot.Onelife.patient.Patient;
import com.springboot.Onelife.patient.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends CrudRepository<Prescription,Integer> {

    public List<Prescription> findByPatient_PatientId(PatientId patientId);
    public Optional<Prescription> findPrescriptionByPrescriptionNumber(PrescriptionId prescriptionNumber);
    public void deleteByPrescriptionNumber(PrescriptionId prescriptionId);
}
