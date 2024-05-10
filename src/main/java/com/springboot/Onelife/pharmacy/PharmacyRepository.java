package com.springboot.Onelife.pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PharmacyRepository extends CrudRepository<Pharmacy,Integer> {
    public List<Pharmacy> findByPharmacyId_HospitalId(int hospitalId);
    public Optional<Pharmacy> findByPharmacyId(PharmacyId pharmacyId);
    public void deleteByPharmacyId(PharmacyId pharmacyId);
}
