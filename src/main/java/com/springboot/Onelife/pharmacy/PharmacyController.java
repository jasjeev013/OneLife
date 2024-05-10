package com.springboot.Onelife.pharmacy;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PharmacyController {

    private PharmacyRepository pharmacyRepository;

    public PharmacyController(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

//    get all
    @GetMapping("hospitals/{hospitalId}/pharmacies")
    public List<Pharmacy> getPharmacies(@PathVariable int hospitalId){
        return pharmacyRepository.findByPharmacyId_HospitalId(hospitalId);
    }

//    get by id
    @GetMapping("/hospitals/{hospitalId}/pharmacies/{pharmId}")
    public Optional<Pharmacy> getPharmacyById(@PathVariable int hospitalId,@PathVariable int pharmId){
        return pharmacyRepository.findByPharmacyId(new PharmacyId(hospitalId,pharmId));
    }

//    add pharmacy
    @PostMapping("/hospitals/{hospitalId}/pharmacy")
    public void addPharmacy(@PathVariable int hospitalId,@RequestBody Pharmacy pharmacy){
        pharmacyRepository.save(pharmacy);
    }

//    update pharmacy
    @PutMapping("/hospitals/{hospitalId}/pharmacy/{pharmId}")
    public void updatePharmacy(@PathVariable int hospitalId,@PathVariable int pharmId,@RequestBody Pharmacy pharmacy){
        pharmacy.setPharmacyId(new PharmacyId(hospitalId,pharmId));
        pharmacyRepository.save(pharmacy);
    }

//    delete pharmacy
    @DeleteMapping("/hospital/{hospitalId}/pharmacy/{pharmacyId}")
    public void deletePharmacy(@PathVariable int hospitalId,@PathVariable int pharmacyId){
        pharmacyRepository.deleteByPharmacyId(new PharmacyId(hospitalId,pharmacyId));
    }





}
