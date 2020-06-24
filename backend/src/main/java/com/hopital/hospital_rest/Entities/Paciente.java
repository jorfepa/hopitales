package com.hopital.hospital_rest.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;    
    private Integer IdHospital;    
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private String Direccion;
    private String Foto;
    private Date FechaCreacion;    
    private Date FechaActualizacion;    
    private String CreadoPor;
    private String ActualizadoPor;

    public Paciente(){
        
    }

    public Paciente(Integer id, Integer idHospital, String nombre, String apellido, Date fechaNacimiento, 
    String foto, String direccion,
            Date fechaCreacion, Date fechaActualizacion, String creadoPor, String actualizadoPor) {
        Id = id;
        IdHospital = idHospital;
        Nombre = nombre;
        Apellido = apellido;
        FechaNacimiento = fechaNacimiento;
        Direccion = direccion;
        Foto = foto;
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

    public Integer getIdHospital() {
        return IdHospital;
    }

    public void setIdHospital(Integer idHospital) {
        IdHospital = idHospital;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
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