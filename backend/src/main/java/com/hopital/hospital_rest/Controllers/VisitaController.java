package com.hopital.hospital_rest.Controllers;

import java.util.List;

import com.hopital.hospital_rest.Services.VisitaService;
import com.hopital.hospital_rest.Entities.Visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitaController {    

    @Autowired
    private VisitaService service;

    @GetMapping("/visitas/doctor/{id}")
    public List<Visita> listByIdDoctor(@PathVariable Integer id){
        return service.findByDoctor(id);
    }

    @GetMapping("/visitas/paciente/{id}")
    public List<Visita> listByIdPaciente(@PathVariable Integer id){
        return service.findByPaciente(id);
    }
}