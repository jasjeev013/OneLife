package com.springboot.Onelife.room;

import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.department.DepartmentRepository;
import com.springboot.Onelife.hospital.Hospital;
import com.springboot.Onelife.hospital.HospitalRepository;
import com.springboot.Onelife.staff.Staff;
import com.springboot.Onelife.staff.StaffRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class RoomController {
/*
    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;
    private StaffRepository staffRepository;
    private RoomRepository roomRepository;

    public RoomController(HospitalRepository hospitalRepository, DepartmentRepository departmentRepository, StaffRepository staffRepository, RoomRepository roomRepository) {
        this.hospitalRepository = hospitalRepository;
        this.departmentRepository = departmentRepository;
        this.staffRepository = staffRepository;
        this.roomRepository = roomRepository;
    }

//    get all
    @GetMapping("/hospitals/{hospId}/departments/{deptId}/staff/{staffId}/rooms")
    public List<Room> getAllRooms(@PathVariable int hospId,@PathVariable int deptId,@PathVariable int staffId){
        Optional<Hospital> hospital = hospitalRepository.findById(hospId);
        if (hospital.isPresent()){
            Optional<Department> department = departmentRepository.findByDepartmentIdAndHospital(deptId,hospital.get())
                    .stream().findFirst();
            if (department.isPresent()){
                Optional<Staff> staff = staffRepository.findByStaffIdAndDepartment(staffId,department.get())
                        .stream().findFirst();
                if (staff.isPresent()){
                    return staff.get().getRooms();
                }
            }
         }
        return null;
    }

//    get by id
    @GetMapping("/hospitals/{hospId}/departments/{deptId}/staff/{staffId}/rooms/{roomId}")
    public List<Room> getAllRoomById(@PathVariable int hospId,@PathVariable int deptId,@PathVariable int staffId,@PathVariable int roomId){
        Optional<Hospital> hospital = hospitalRepository.findById(hospId);
        if (hospital.isPresent()){
            Optional<Department> department = departmentRepository.findByDepartmentIdAndHospital(deptId,hospital.get())
                    .stream().findFirst();
            if (department.isPresent()){
                Optional<Staff> staff = staffRepository.findByStaffIdAndDepartment(staffId,department.get())
                        .stream().findFirst();
                if (staff.isPresent()){
                    return roomRepository.findByRoomNumberAndStaff(roomId,staff.get());
                }
            }
        }
        return null;
    }

//    add room
    @PostMapping("/hospitals/{hospId}/departments/{deptId}/staff/{staffId}/rooms")
    public void addRoom(@PathVariable int hospId, @PathVariable int deptId, @PathVariable int staffId, @RequestBody Room room){
        Optional<Hospital> hospital = hospitalRepository.findById(hospId);
        if (hospital.isPresent()){
            Optional<Department> department = departmentRepository.findByDepartmentIdAndHospital(deptId,hospital.get())
                    .stream().findFirst();
            if (department.isPresent()){
                Optional<Staff> staff = staffRepository.findByStaffIdAndDepartment(staffId,department.get())
                        .stream().findFirst();
               staff.ifPresent(room::setStaff);
               roomRepository.save(room);
            }
        }
    }

//    update room
    @PutMapping("/hospitals/{hospId}/departments/{deptId}/staff/{staffId}/rooms/{roomId}")
    public void  updateRoom(@PathVariable int hospId, @PathVariable int deptId, @PathVariable int staffId, @PathVariable int roomId, @RequestBody Room room){
        Optional<Hospital> hospital = hospitalRepository.findById(hospId);
        if (hospital.isPresent()){
            Optional<Department> department = departmentRepository.findByDepartmentIdAndHospital(deptId,hospital.get())
                    .stream().findFirst();
            if (department.isPresent()){
                Optional<Staff> staff = staffRepository.findByStaffIdAndDepartment(staffId,department.get())
                        .stream().findFirst();
                room.setRoomNumber(roomId);
                room.setStaff(staff.get());
                roomRepository.save(room);
            }
        }

    }
//    delete room
    @DeleteMapping("/hospitals/{hospId}/departments/{deptId}/staff/{staffId}/rooms/{roomId}")
    public void updateRoom(@PathVariable int hospId, @PathVariable int deptId, @PathVariable int staffId, @PathVariable int roomId){

        Optional<Hospital> hospital = hospitalRepository.findById(hospId);
        if (hospital.isPresent()){
            Optional<Department> department = departmentRepository.findByDepartmentIdAndHospital(deptId,hospital.get())
                    .stream().findFirst();
            if (department.isPresent()){
                Optional<Staff> staff = staffRepository.findByStaffIdAndDepartment(staffId,department.get())
                        .stream().findFirst();
                staff.ifPresent(value -> roomRepository.deleteByRoomNumberAndStaff(roomId, value));
            }
        }

    }




*/

}
