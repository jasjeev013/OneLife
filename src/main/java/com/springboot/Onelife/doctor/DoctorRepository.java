package com.springboot.Onelife.doctor;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

    public List<Doctor> findByDoctorId_HospitalId(int hospitalId);
    public List<Doctor> findByDoctorId_HospitalIdAndDepartment_DepartmentId(int hospitalId, DepartmentId departmentId);
    public Optional<Doctor> findDoctorByDoctorId(DoctorId doctorId);
    public List<Doctor> findByDoctorFNameAndDepartment_DepartmentId(String docFName,DepartmentId departmentId);
    public void deleteByDoctorId(DoctorId doctorId);

}
