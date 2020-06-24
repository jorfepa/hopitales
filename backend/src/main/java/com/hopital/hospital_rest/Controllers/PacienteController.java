package com.hopital.hospital_rest.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import com.hopital.hospital_rest.Services.PacienteService;
import com.hopital.hospital_rest.Entities.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
    
    @Autowired
    private PacienteService service;

    @GetMapping("/pacientes")
    public List<Paciente> list(){
        return service.list();
    }

    @GetMapping("/pacientes/{id}")
    public Paciente get(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping("/pacientes")
    public Paciente add(@RequestBody Paciente paciente){
        Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());              
        paciente.setFechaNacimiento(paciente.getFechaNacimiento());
        paciente.setCreadoPor("Usuario Creacion");
        paciente.setFechaCreacion(fechaActual);
        return service.save(paciente);
    }

    @PutMapping("/pacientes/{id}")
    public Paciente update(@RequestBody Paciente paciente, @PathVariable Integer id){
        try{
            Paciente existPaciente = service.get(id);
            existPaciente.setIdHospital(paciente.getIdHospital());
            existPaciente.setNombre(paciente.getNombre());
            existPaciente.setApellido(paciente.getApellido());
            existPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
            existPaciente.setFoto(paciente.getFoto());
            existPaciente.setDireccion(paciente.getDireccion());
            existPaciente.setActualizadoPor("Actualizado Creacion");
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
            existPaciente.setFechaActualizacion(fechaActual);
            return service.save(existPaciente);
        }catch(NoSuchElementException e){
            return null;            
        }
    }

    @DeleteMapping("/pacientes/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}