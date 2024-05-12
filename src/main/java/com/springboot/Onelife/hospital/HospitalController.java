package com.springboot.Onelife.hospital;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {

//    private HospitalService hospitalService;
    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;

    public HospitalController(HospitalRepository hospitalRepository,DepartmentRepository departmentRepository) {
        this.hospitalRepository = hospitalRepository;
        this.departmentRepository = departmentRepository;
    }


//  Get All Hospitals
    @GetMapping("/hospitals")
    public Iterable<Hospital> retrieveAllHospitals(){
        return hospitalRepository.findAll();
    }

//  Get Hospital By Id
    @GetMapping("/hospitals/{id}")
    public Optional<Hospital> retrieveHospitalById(@PathVariable int id){
        return hospitalRepository.findHospitalByHospitalId(id);
    }

//    Get Hospital By Name
    @GetMapping("/hospitals/findByName/{name}")
    public List<Hospital> retrieveHospitalByName(@PathVariable String name){
        return hospitalRepository.findByHospitalName(name);
    }

//    Get Hospital By Address
    @GetMapping("/hospitals/findByAddress/{address}")
    public List<Hospital> retrieveHospitalByAddress(@PathVariable String address){
        return hospitalRepository.findByHospitalAddressContainingIgnoreCase(address);
    }

//    Add Hospital
    @PostMapping("/hospitals")
    public void addHospital( @RequestBody Hospital hospital){
        hospitalRepository.save(hospital);
    }



//    Update Hospital
    @PutMapping("/hospitals/{id}")
    public void updateHospital(@PathVariable int id,@RequestBody Hospital updatedHospital){
        updatedHospital.setHospitalId(id);
        hospitalRepository.save(updatedHospital);
    }

//    Delete Hospital
    @DeleteMapping("/hospitals/delete/{id}")
    public void deleteHospital(@PathVariable int id){
        hospitalRepository.deleteById(id);
    }

    @GetMapping("/contact")
    public String getContacts(){
        return "Got all the contacts";
    }

}
