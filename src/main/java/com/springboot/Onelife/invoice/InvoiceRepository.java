package com.springboot.Onelife.invoice;

import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.patient.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {
    public List<Invoice> findByInvoiceNumberAndPatient_PatientId(InvoiceId invoiceId,PatientId patientId);
    public List<Invoice> findByPatient_PatientId(PatientId patient_patientId);
    public void deleteByInvoiceNumber(InvoiceId invoiceId);
}
