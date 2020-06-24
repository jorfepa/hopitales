package com.hopital.hospital_rest.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import com.hopital.hospital_rest.Services.HospitalService;
import com.hopital.hospital_rest.Entities.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    
    @Autowired
    private HospitalService service;

    @GetMapping("/hospitales")
    public List<Hospital> list(){
        return service.list();
    }

    @GetMapping("/hospitales/{id}")
    public Hospital get(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping("/hospitales")
    public Hospital add(@RequestBody Hospital hospital){
        Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
        hospital.setCreadoPor("Usuario Creacion");
        hospital.setFechaCreacion(fechaActual);
        return service.save(hospital);
    }

    @PutMapping("/hospitales/{id}")
    public Hospital update(@RequestBody Hospital hospital, @PathVariable Integer id){
        try{
            Hospital existHospital = service.get(id);
            existHospital.setNombre(hospital.getNombre());
            existHospital.setActualizadoPor("Actualizado Creacion");
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
            existHospital.setFechaActualizacion(fechaActual);
            return service.save(existHospital);
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @DeleteMapping("/hospitales/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}