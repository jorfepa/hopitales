package com.hopital.hospital_rest.Repositories;

import com.hopital.hospital_rest.Entities.DoctorEspecialidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorEspecialidadRepository extends JpaRepository<DoctorEspecialidad, Integer>{
    
}