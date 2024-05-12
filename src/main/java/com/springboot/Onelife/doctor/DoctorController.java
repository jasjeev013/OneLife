package com.springboot.Onelife.doctor;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentController;
import com.springboot.Onelife.department.DepartmentId;
import com.springboot.Onelife.department.DepartmentRepository;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private DepartmentRepository departmentRepository;
    private DoctorRepository doctorRepository;

    public DoctorController(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    //    Get All Doctors
    @GetMapping("/hospitals/{hospId}/doctors")
    public List<Doctor> retrieveDoctorsForDepartment(@PathVariable int hospId){
        return doctorRepository.findByDoctorId_HospitalId(hospId);
    }

    @GetMapping("/hospitals/{hospId}/departments/{deptId}/doctors")
    public List<Doctor> retrieveDoctorsForDepartment(@PathVariable int hospId,@PathVariable int deptId){
        return doctorRepository.findByDoctorId_HospitalIdAndDepartment_DepartmentId(hospId,new DepartmentId(deptId,hospId));
    }



//    Get By Id
    @GetMapping("/hospitals/{hospId}/doctors/{docId}")
    public Optional<Doctor> retrieveDoctorsForDepartmentById(@PathVariable int hospId,@PathVariable int docId){
        return doctorRepository.findDoctorByDoctorId(new DoctorId(hospId,docId));
    }

//    get by name
    @GetMapping("/hospitals/{hospId}/departments/{deptId}/doctorsbyname/{docName}")
    public List<Doctor> retrieveDoctorsForDepartmentByName(@PathVariable int hospId,@PathVariable int deptId,@PathVariable String docName){
        return doctorRepository.findByDoctorFNameAndDepartment_DepartmentId(docName,new DepartmentId(deptId,hospId));
    }


//    add doctor
    @PostMapping("/hospitals/{hospId}/departments/{id}/doctors")
    public void addDoctorForDepartment(@PathVariable int hospId, @PathVariable int id, @RequestBody Doctor doctor){
            Optional<Department> department = departmentRepository.findDepartmentByDepartmentId(new DepartmentId(id,hospId));
            if (department.isPresent()){
                doctor.setDepartment(department.get());
                doctorRepository.save(doctor);
            }
    }


//    update doctor
    @PutMapping("/hospitals/{hospId}/doctors/{docId}")
    public void updateDoctorForDepartment(@PathVariable int hospId, @PathVariable int docId,@RequestBody Doctor doctor){
        doctor.setDoctorId(new DoctorId(hospId,docId));
        doctorRepository.save(doctor);


    }

//    delete doctor
    @DeleteMapping("/hospitals/{hospId}/doctors/{doctId}")
    public void deleteDoctorForDepartment(@PathVariable int hospId, @PathVariable int id, @PathVariable int doctId){
        doctorRepository.deleteByDoctorId(new DoctorId(hospId,doctId));
    }






}
