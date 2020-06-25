package com.hopital.hospital_rest.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

import com.hopital.hospital_rest.Services.DoctorService;
import com.hopital.hospital_rest.Entities.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    
    @Autowired
    private DoctorService service;

    @GetMapping("/doctores")
    public List<Doctor> list(){
        return service.list();
    }

    @GetMapping("/doctores/{id}")
    public Doctor get(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping("/doctores")
    public Doctor add(@RequestBody Doctor doctor){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
        doctor.setCreadoPor("Usuario Creacion");
        doctor.setFechaCreacion(fechaActual);
        return service.save(doctor);
    }

    @PutMapping("/doctores/{id}")
    public Doctor update(@RequestBody Doctor doctor, @PathVariable Integer id){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        try{
            Doctor doctorPaciente = service.get(id);
            doctorPaciente.setIdHospital(doctor.getIdHospital());
            doctorPaciente.setNombre(doctor.getNombre());
            doctorPaciente.setApellido(doctor.getApellido());
            doctorPaciente.setFechaNacimiento(doctor.getFechaNacimiento());
            doctorPaciente.setFoto(doctor.getFoto());
            doctorPaciente.setDireccion(doctor.getDireccion());
            doctorPaciente.setActualizadoPor("Actualizado Creacion");
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
            doctorPaciente.setFechaActualizacion(fechaActual);
            return service.save(doctorPaciente);
        }catch(NoSuchElementException e){
            return null;            
        }
    }

    @DeleteMapping("/doctores/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}