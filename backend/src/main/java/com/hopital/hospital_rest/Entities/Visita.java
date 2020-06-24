package com.hopital.hospital_rest.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id; 
    private String Nombre;
    private String Apellido;
    private String Descripcion;
    private Date Fecha;

    public Visita(){
        
    }

    public Visita(Integer id, String nombre, String apellido, String descripcion, Date fecha) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Descripcion = descripcion;
        Fecha = fecha;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
}