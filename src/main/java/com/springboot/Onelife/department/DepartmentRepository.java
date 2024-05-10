package com.springboot.Onelife.department;

import com.springboot.Onelife.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    public List<Department> findByHospital_HospitalId(int hospitalId);
    public Optional<Department> findDepartmentByDepartmentId(DepartmentId departmentName);
    public List<Department> findByDepartmentNameAndDepartmentId_HospitalId(String departmentName,int hospitalId);
    public void deleteByDepartmentId(DepartmentId departmentId);

}
