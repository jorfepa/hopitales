package com.hopital.hospital_rest.Controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

import com.hopital.hospital_rest.Services.NotaService;
import com.hopital.hospital_rest.Entities.Nota;

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
public class NotaController {
    
    @Autowired
    private NotaService service;

    @GetMapping("/notas")
    public List<Nota> list(){
        return service.list();
    }

    @GetMapping("/notas/{id}")
    public Nota get(@PathVariable Integer id){
        return service.get(id);
    }

    @GetMapping("/notas/paciente/{id}")
    public List<Nota> listByIdPaciente(@PathVariable Integer id){
        return service.listByIdPaciente(id);
    }

    @PostMapping("/notas")
    public void add(@RequestBody Nota nota){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());              
        nota.setFecha(nota.getFecha());
        nota.setCreadoPor("Usuario Creacion");
        nota.setFechaCreacion(fechaActual);
        service.save(nota);
    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<?> update(@RequestBody Nota nota, @PathVariable Integer id){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        try{
            Nota existNota = service.get(id);
            existNota.setIdPaciente(nota.getIdPaciente());
            existNota.setIdDoctor(nota.getIdDoctor());
            existNota.setDescripcion(nota.getDescripcion());
            existNota.setFecha(nota.getFecha());
            existNota.setActualizadoPor("Actualizado Creacion");
            Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
            existNota.setFechaActualizacion(fechaActual);
            service.save(existNota);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);            
        }
    }

    @DeleteMapping("/notas/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}