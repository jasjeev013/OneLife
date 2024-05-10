package com.springboot.Onelife.staff;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends CrudRepository<Staff,Integer> {
    public List<Staff> findByStaffId_HospitalId(int hospitalId);
    public List<Staff> findByStaffId_HospitalIdAndDepartment_DepartmentId(int hospitalId, DepartmentId departmentId);
    public Optional<Staff> findStaffByStaffId(StaffId staffId);

    public List<Staff> findByStaffFNameAndDepartment_DepartmentId(String staffFName, DepartmentId department_departmentId);
    public void deleteByStaffId(StaffId staffId);


}
