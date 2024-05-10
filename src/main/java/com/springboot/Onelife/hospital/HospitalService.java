package com.springboot.Onelife.hospital;


import java.util.ArrayList;
import java.util.List;

//@Service
public class HospitalService {
    private static List<Hospital> hospitals =new ArrayList<>();
    public static int hospitalCount = 0;

//    static {
//        hospitals.add(new Hospital(++hospitalCount,"AIIMS","South ex","9013511256","Delhi","110027"));
//        hospitals.add(new Hospital(++hospitalCount,"K R MANGLAM","South ex","9013511256","Delhi","110027"));
//        hospitals.add(new Hospital(++hospitalCount,"SHRI KAMALDAS","South ex","9013511256","Delhi","110027"));
//    }

    public List<Hospital> findAll(){
        return hospitals;
    }

    public List<Hospital> findById(int id) {
        return hospitals.stream()
                .filter(hospital -> hospital.getHospitalId()==id)
                .toList();
    }

    public void addHospital(Hospital hospital){
        hospital.setHospitalId(++hospitalCount);
        hospitals.add(hospital);
    }

    public void updatebyId(int id,Hospital updatedHospital){
        deletebyId(id);
        hospitals.add(updatedHospital);
    }

    public void deletebyId(int id){
        hospitals.removeIf(hospital -> hospital.getHospitalId()==id);
    }






}
