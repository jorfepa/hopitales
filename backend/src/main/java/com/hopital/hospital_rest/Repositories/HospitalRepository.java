package com.hopital.hospital_rest.Repositories;

import com.hopital.hospital_rest.Entities.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
    
}