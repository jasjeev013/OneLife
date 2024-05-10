package com.springboot.Onelife.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.Onelife.department.Department;
import com.springboot.Onelife.patient.Patient;
import com.springboot.Onelife.staff.Staff;
import jakarta.persistence.*;


public class Room {

    private int roomNumber;
    private String admissionDate;



    public Room(int roomNumber, String admissionDate) {
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
    }

    public Room() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }



    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }
}
