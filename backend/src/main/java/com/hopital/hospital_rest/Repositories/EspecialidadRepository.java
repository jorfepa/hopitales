package com.hopital.hospital_rest.Repositories;

import java.util.List;

import com.hopital.hospital_rest.Entities.Especialidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
    @Query(value = "SELECT doctor_especialidad.id, especialidad.nombre, especialidad.descripcion, especialidad.icono, " + 
            "especialidad.fecha_creacion, especialidad.fecha_actualizacion, especialidad.creado_por, " +
            "especialidad.actualizado_por from doctor "+            
            "INNER JOIN doctor_especialidad ON doctor.id=doctor_especialidad.id_doctor "+
            "INNER JOIN especialidad on especialidad.id=doctor_especialidad.id_especialidad "+
            "where doctor.id = ?1", nativeQuery = true)
    List<Especialidad> findByIdDoctor(Integer idDoctor); 

    @Query(value="select id, nombre, descripcion, icono, fecha_creacion,fecha_actualizacion, " +
    "creado_por,actualizado_por FROM especialidad " +
    "where id NOT in(SELECT doctor_especialidad.id_especialidad " + 
    "FROM doctor_especialidad where doctor_especialidad.id_doctor=?1)", nativeQuery = true)
    List<Especialidad> findNotInDoctor(Integer idDoctor);   
}