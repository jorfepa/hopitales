package com.hopital.hospital_rest.Repositories;


import java.util.List;

import com.hopital.hospital_rest.Entities.Nota;
import com.hopital.hospital_rest.Interfaces.INotaDetallada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotaRepository extends JpaRepository<Nota, Integer>{
    /* @Query(value = "SELECT * FROM nota WHERE id_paciente = ?1", nativeQuery = true)
    List<Nota> findByIdPaciente(Integer idPaciente); */
    @Query(value = "SELECT nota.id, id_paciente as idpaciente ,concat_Ws(' ',paciente.nombre,paciente.apellido) "+ 
    "as nombrepaciente, id_doctor as iddoctor,concat_Ws(' ',doctor.nombre,doctor.apellido)  as nombredoctor, " + 
    "descripcion, fecha FROM  nota  inner join paciente on paciente.id= nota.id_paciente " +
    "inner join doctor on doctor.id=nota.id_doctor WHERE nota.id_paciente = ?1", nativeQuery = true)
    List<INotaDetallada> findByIdPaciente(Integer idPaciente);
}