package com.springboot.Onelife.staff;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.room.Room;
import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Table(name = "staff")
public class Staff {

    @EmbeddedId
    @Column(name = "staff_id")
    private StaffId staffId;

    @Column(name = "staff_f_name")
    private String staffFName;
    @Column(name = "staff_l_name")
    private String staffLName;
    @Column(name = "staff_address")
    private String staffAddress;
    @Column(name = "staff_phone_number")
    private String staffPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


    public Staff(StaffId staffId, String staffFName, String staffLName, String staffAddress, String staffPhoneNumber) {
        this.staffId = staffId;
        this.staffFName = staffFName;
        this.staffLName = staffLName;
        this.staffAddress = staffAddress;
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public Staff() {

    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public StaffId getStaffId() {
        return staffId;
    }

    public void setStaffId(StaffId staffId) {
        this.staffId = staffId;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public String getStaffLName() {
        return staffLName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }
}
