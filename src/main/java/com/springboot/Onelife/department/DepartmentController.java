package com.springboot.Onelife.department;

import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;

    public DepartmentController(HospitalRepository hospitalRepository,DepartmentRepository departmentRepository) {
        this.hospitalRepository = hospitalRepository;
        this.departmentRepository = departmentRepository;
    }

    //   Get Departments
    @GetMapping("/hospitals/{id}/departments")
    public List<Department> retrieveDepartmentsForHospital(@PathVariable int id){
        return departmentRepository.findByHospital_HospitalId(id);
    }

    //   Get Departments By Id
    @GetMapping("/hospitals/{id}/departments/{dept_id}")
    public Optional<Department> retrieveDepartmentsForHospitalById(@PathVariable int id,@PathVariable int dept_id){
        return departmentRepository.findDepartmentByDepartmentId(new DepartmentId(dept_id,id));
    }

    //   Get Departments By Name
    @GetMapping("/hospitals/{id}/departments/filterByName/{name}")
    public List<Department> retrieveDepartmentsForHospitalByName(@PathVariable int id,@PathVariable String name){
        return departmentRepository.findByDepartmentNameAndDepartmentId_HospitalId(name,id);
    }

//    Add Department
    @PostMapping("/hospitals/{id}/departments")
    public void addDepartment(@PathVariable int id, @RequestBody Department department){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        hospital.ifPresent(department::setHospital);
        department.setDepartmentId(new DepartmentId(department.getDepartmentId().getDepartmentId(),id));
        departmentRepository.save(department);
    }


    //    Update department
    @PutMapping("hospitals/{id}/departments/{dept_id}")
    public void updateDepartment(@PathVariable int id,@PathVariable int dept_id,@RequestBody Department department){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        department.setDepartmentId(new DepartmentId(dept_id,id));
        department.setHospital(hospital.get());
        departmentRepository.save(department);
    }

    //    Delete Department
    @DeleteMapping("/hospitals/{id}/departments/{dept_id}")
    public void deleteDepartment(@PathVariable int id,@PathVariable int dept_id){
        departmentRepository.deleteByDepartmentId(new DepartmentId(dept_id,id));
    }
}
