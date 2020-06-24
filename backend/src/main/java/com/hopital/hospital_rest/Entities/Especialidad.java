package com.hopital.hospital_rest.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;    
    private String Nombre;
    private String Descripcion;
    private String Icono;
    private Date FechaCreacion;    
    private Date FechaActualizacion;    
    private String CreadoPor;
    private String ActualizadoPor;

    public Especialidad(){

    }
    
    public Especialidad(Integer id, String nombre, String descripcion, String icono, Date fechaCreacion, Date fechaActualizacion, String creadoPor, String actualizadoPor ) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Icono = icono;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getIcono() {
        return Icono;
    }

    public void setIcono(String icono) {
        Icono = icono;
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