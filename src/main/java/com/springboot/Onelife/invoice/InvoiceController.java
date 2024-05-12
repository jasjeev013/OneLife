package com.springboot.Onelife.invoice;

import com.springboot.Onelife.patient.Patient;
import com.springboot.Onelife.patient.PatientId;
import com.springboot.Onelife.patient.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {

    private PatientRepository patientRepository;
    private InvoiceRepository invoiceRepository;

    public InvoiceController(PatientRepository patientRepository, InvoiceRepository invoiceRepository) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
    }


    @GetMapping("/hospital/{hospitalId}/patients/{patientId}/invoices")
    public List<Invoice> getAllInvoice(@PathVariable int hospitalId,@PathVariable int patientId){
        return invoiceRepository.findByPatient_PatientId(new PatientId(hospitalId,patientId));
    }

    @GetMapping("/hospitals/{hospitalId}/patients/{patientId}/invoices/{invoiceId}")
    public List<Invoice> getInvoiceById(@PathVariable int hospitalId,@PathVariable int patientId,@PathVariable int invoiceId){
        return invoiceRepository.findByInvoiceNumberAndPatient_PatientId(new InvoiceId(hospitalId,invoiceId),new PatientId(hospitalId,patientId));
    }

    @PostMapping("/hospital/{hospitalId}/patients/{patientId}/invoices")
    public void addInvoice(@PathVariable int hospitalId,@PathVariable int patientId, @RequestBody Invoice invoice){
        Optional<Patient> patient = patientRepository.findPatientByPatientId(new PatientId(hospitalId,patientId));
        if (patient.isPresent()){
            invoice.setPatient(patient.get());
            invoiceRepository.save(invoice);
        }
    }

    @PutMapping("/hospital/{hospitalId}/invoices/{invoiceId}")
    public void updateInvoice(@PathVariable int hospitalId,@PathVariable int invoiceId, @RequestBody Invoice invoice){
        invoice.setInvoiceNumber(new InvoiceId(hospitalId,invoiceId));
        invoiceRepository.save(invoice);
    }

    @DeleteMapping("/hospital/{hospitalId}/invoices/{invoiceId}")
    public void deleteInvoice(@PathVariable int hospitalId,@PathVariable int invoiceId){
        invoiceRepository.deleteByInvoiceNumber(new InvoiceId(hospitalId, invoiceId));
    }




}
