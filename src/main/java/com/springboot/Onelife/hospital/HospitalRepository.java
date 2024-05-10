package com.springboot.Onelife.hospital;

import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends CrudRepository<Hospital,Integer> {

    public Optional<Hospital> findHospitalByHospitalId(int hospitalId);

    public List<Hospital> findByHospitalName(String hospitalName);
    public List<Hospital> findByHospitalAddressContainingIgnoreCase(String hospitalAddress);

}
