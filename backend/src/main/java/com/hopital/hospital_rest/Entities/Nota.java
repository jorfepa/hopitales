package com.hopital.hospital_rest.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;    
    private Integer IdPaciente;
    private Integer IdDoctor;
    private String Descripcion;
    private Date Fecha;
    private Date FechaCreacion;    
    private Date FechaActualizacion;    
    private String CreadoPor;
    private String ActualizadoPor;

    public Nota(){
        
    }

    public Nota(Integer id, Integer idPaciente, Integer idDoctor, String descripcion, Date fecha,
            Date fechaCreacion, Date fechaActualizacion, String creadoPor, String actualizadoPor) {
        Id = id;
        IdPaciente = idPaciente;
        IdDoctor = idDoctor;
        Descripcion = descripcion;
        Fecha = fecha;
        FechaCreacion = fechaCreacion;
        FechaActualizacion = fechaActualizacion;
        CreadoPor = creadoPor;
        ActualizadoPor = actualizadoPor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public Integer getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        IdDoctor = idDoctor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        FechaActualizacion = fechaActualizacion;
    }

    public String getCreadoPor() {
        return CreadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        CreadoPor = creadoPor;
    }

    public String getActualizadoPor() {
        return ActualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        ActualizadoPor = actualizadoPor;
    }

}