package com.hopital.hospital_rest.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import com.hopital.hospital_rest.Services.EspecialidadService;
import com.hopital.hospital_rest.Entities.Especialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EspecialidadController {
    
    @Autowired
    private EspecialidadService service;

    @GetMapping("/especialidades")
    public List<Especialidad> list(){
        return service.list();
    }

    @GetMapping("/especialidades/{id}")
    public Especialidad get(@PathVariable Integer id){
        return service.get(id);
    }

    @GetMapping("/especialidades/doctor/{id}")
    public List<Especialidad> findByIdDoctor(@PathVariable Integer id){
        return service.findByIdDoctor(id);
    }

    @GetMapping("/especialidades/sin/doctor/{id}")
    public List<Especialidad> findNotInDoctor(@PathVariable Integer id){
        return service.findNotInDoctor(id);
    }

    @PostMapping("/especialidades")
    public Especialidad add(@RequestBody Especialidad especialidad){
        Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
        especialidad.setCreadoPor("Usuario Creacion");
        especialidad.setFechaCreacion(fechaActual);
        return service.save(especialidad);
    }

    @PutMapping("/especialidades/{id}")
    public Especialidad update(@RequestBody Especialidad especialidad, @PathVariable Integer id){
        try{
            Especialidad existEspecialidad = service.get(id);
            existEspecialidad.setNombre(especialidad.getNombre());
            existEspecialidad.setDescripcion(especialidad.getDescripcion());
            existEspecialidad.setIcono(especialidad.getIcono());
            existEspecialidad.setActualizadoPor("Actualizado Creacion");
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
            existEspecialidad.setFechaActualizacion(fechaActual);
            return service.save(existEspecialidad);
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @DeleteMapping("/especialidades/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}