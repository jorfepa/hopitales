package com.hopital.hospital_rest.Repositories;

import com.hopital.hospital_rest.Entities.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    
}