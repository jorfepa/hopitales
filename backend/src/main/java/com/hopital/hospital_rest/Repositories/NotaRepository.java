package com.hopital.hospital_rest.Repositories;


import java.util.List;

import com.hopital.hospital_rest.Entities.Nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotaRepository extends JpaRepository<Nota, Integer>{
    @Query(value = "SELECT * FROM nota WHERE id_paciente = ?1", nativeQuery = true)
    List<Nota> findByIdPaciente(Integer idPaciente);
}