package com.hopital.hospital_rest.Repositories;

import com.hopital.hospital_rest.Entities.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    
}