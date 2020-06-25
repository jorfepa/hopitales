package com.hopital.hospital_rest.Interfaces;

import java.sql.Date;

public interface INotaDetallada {
    Integer getId();
    Integer getIdPaciente();
    String getNombrePaciente();
    Integer getIddoctor();
    String getNombreDoctor();
    String getDescripcion();
    Date getFecha();
    Date getFechaCreacion();
    Date getFechaActualizacion();
    String getCreadoPor();
    String getActualizadoPor();
}