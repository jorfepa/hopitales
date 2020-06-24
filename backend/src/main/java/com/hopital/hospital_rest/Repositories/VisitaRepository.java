package com.hopital.hospital_rest.Repositories;

import java.util.List;

import com.hopital.hospital_rest.Entities.Visita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitaRepository extends JpaRepository<Visita, Integer> {
    @Query(value = "SELECT nota.id, paciente.nombre, paciente.apellido, nota.descripcion, nota.fecha FROM nota " +
    "INNER JOIN paciente on nota.id_paciente=paciente.id "+
    "INNER JOIN doctor ON nota.id_doctor=doctor.id where doctor.id=?1", nativeQuery = true)
    List<Visita> findByDoctor(Integer idDoctor);

    @Query(value = "SELECT nota.id, doctor.nombre, doctor.apellido, nota.descripcion, nota.fecha FROM nota " +
    "INNER JOIN doctor ON nota.id_doctor=doctor.id " +
    "INNER JOIN paciente ON nota.id_paciente=paciente.id where paciente.id=?1", nativeQuery = true)
    List<Visita> findByPaciente(Integer idPaciente);
}