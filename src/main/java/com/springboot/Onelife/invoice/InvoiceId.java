package com.springboot.Onelife.invoice;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceId implements Serializable {

    private int hospitalId;
    private int invoiceId;

    public InvoiceId(int hospitalId, int invoiceId) {
        this.hospitalId = hospitalId;
        this.invoiceId = invoiceId;
    }

    public InvoiceId() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceId invoiceId1 = (InvoiceId) o;
        return hospitalId == invoiceId1.hospitalId && invoiceId == invoiceId1.invoiceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, invoiceId);
    }
}
