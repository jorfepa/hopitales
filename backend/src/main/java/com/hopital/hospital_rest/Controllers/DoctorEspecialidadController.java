package com.hopital.hospital_rest.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.hopital.hospital_rest.Services.DoctorEspecialidadService;
import com.hopital.hospital_rest.Entities.DoctorEspecialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorEspecialidadController {
    
    @Autowired
    private DoctorEspecialidadService service;

    @GetMapping("/doctor_especialidades")
    public List<DoctorEspecialidad> list(){
        return service.list();
    }

    @GetMapping("/doctor_especialidades/{id}")
    public DoctorEspecialidad get(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping("/doctor_especialidades")
    public void add(@RequestBody DoctorEspecialidad doctorEspecialidad){
        service.save(doctorEspecialidad);
    }

    @PutMapping("/doctor_especialidades/{id}")
    public ResponseEntity<?> update(@RequestBody DoctorEspecialidad doctorEspecialidad, @PathVariable Integer id){
        try{
            DoctorEspecialidad doctorEspecialidadExists = service.get(id);
            doctorEspecialidadExists.setIdDoctor(doctorEspecialidad.getIdDoctor());
            doctorEspecialidadExists.setIdEspecialidad(doctorEspecialidad.getIdEspecialidad());
            service.save(doctorEspecialidadExists);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);            
        }
    }

    @DeleteMapping("/doctor_especialidades/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}