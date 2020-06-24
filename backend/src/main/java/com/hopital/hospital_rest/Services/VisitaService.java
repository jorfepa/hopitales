package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.VisitaRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitaService {
    @Autowired
    private VisitaRepository visitaRepository;

    public List<Visita> findByDoctor(Integer idDoctor){
        return visitaRepository.findByDoctor(idDoctor);
    }

    public List<Visita> findByPaciente(Integer idPaciente){
        return visitaRepository.findByPaciente(idPaciente);
    }
}