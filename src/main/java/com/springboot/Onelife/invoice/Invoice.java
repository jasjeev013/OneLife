package com.springboot.Onelife.invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.patient.Patient;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @EmbeddedId
    @Column(name = "invoice_id")
    private InvoiceId invoiceNumber;

    @Column(name = "service_description")
    private String serviceDescription;

    @Column(name = "cost")
    private int cost;

    @Column(name = "total")
    private int total;

    public Invoice(InvoiceId invoiceNumber, String serviceDescription, int cost, int total) {
        this.invoiceNumber = invoiceNumber;
        this.serviceDescription = serviceDescription;
        this.cost = cost;
        this.total = total;
    }

    public Invoice() {

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public InvoiceId getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(InvoiceId invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
