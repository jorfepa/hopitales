package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.PacienteRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> list(){
        return pacienteRepository.findAll();
    }

    public Paciente get(Integer id){
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(Integer id){
        pacienteRepository.deleteById(id); 
    } 

    
}