package com.hopital.hospital_rest.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;    
    private Integer IdDoctor;    
    private Integer IdEspecialidad;

    public DoctorEspecialidad(){
        
    }

    public DoctorEspecialidad(Integer id, Integer idDoctor, Integer idEspecialidad) {
        Id = id;
        IdDoctor = idDoctor;
        IdEspecialidad = idEspecialidad;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        IdDoctor = idDoctor;
    }

    public Integer getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        IdEspecialidad = idEspecialidad;
    }
}