package com.hopital.hospital_rest.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;    
    private String Nombre;
    private Date FechaCreacion;    
    private Date FechaActualizacion;    
    private String CreadoPor;
    private String ActualizadoPor;

    public Hospital(){

    }
    
    public Hospital(Integer id, String nombre, Date fechaCreacion, Date fechaActualizacion, String creadoPor, String actualizadoPor ) {
        Id = id;
        Nombre = nombre;
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