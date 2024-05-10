package com.springboot.Onelife.staff;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentId;
import com.springboot.Onelife.department.DepartmentRepository;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StaffController {

    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;
    private StaffRepository staffRepository;

    public StaffController(HospitalRepository hospitalRepository, DepartmentRepository departmentRepository, StaffRepository staffRepository) {
        this.hospitalRepository = hospitalRepository;
        this.departmentRepository = departmentRepository;
        this.staffRepository = staffRepository;
    }

//    get all staff
    @GetMapping("/hospitals/{hospId}/staff")
    public List<Staff> retrieveAllStaff(@PathVariable int hospId){
        return staffRepository.findByStaffId_HospitalId(hospId);
    }

//    get all staff for a specific department
    @GetMapping("/hospitals/{hospId}/departments/{deptId}/staff")
    public List<Staff> retrieveStaffForDepartment(@PathVariable int hospId, @PathVariable int deptId){
        return staffRepository.findByStaffId_HospitalIdAndDepartment_DepartmentId(hospId,new DepartmentId(deptId,hospId));
    }

//    get by id
    @GetMapping("/hospitals/{hospId}/staff/{staffId}")
    public Optional<Staff> retrieveStaffForDepartmentById(@PathVariable int hospId,@PathVariable int staffId){
        return staffRepository.findStaffByStaffId(new StaffId(hospId,staffId));
    }

//    get by name
    @GetMapping("/hospitals/{hospId}/departments/{id}/staffbyname/{staffName}")
    public List<Staff> retrieveStaffForDepartmentByName(@PathVariable int hospId, @PathVariable int id, @PathVariable String staffName){
        return staffRepository.findByStaffFNameAndDepartment_DepartmentId(staffName,new DepartmentId(id,hospId));
    }

//    add staff
    @PostMapping("/hospitals/{hospId}/departments/{id}/staff")
    public void addStaffForDepartment(@PathVariable int hospId, @PathVariable int id, @RequestBody Staff staff){
        Optional<Department> department = departmentRepository.findDepartmentByDepartmentId(new DepartmentId(id,hospId));
        if (department.isPresent()){
            staff.setDepartment(department.get());
            staffRepository.save(staff);
        }


    }

//    update staff
    @PutMapping("/hospitals/{hospId}/staff/{staffId}")
    public void updateStaffForDepartment(@PathVariable int hospId,@PathVariable int staffId,@RequestBody Staff staff) {

        staff.setStaffId(new StaffId(hospId, staffId));
        staffRepository.save(staff);

    }

//    delete staff
    @DeleteMapping("/hospitals/{hospId}/staff/{staffId}")
    public void deleteStaffForDepartment(@PathVariable int hospId,@PathVariable int staffId){
        staffRepository.deleteByStaffId(new StaffId(hospId,staffId));
    }




}
