package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.NotaRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> list(){
        return notaRepository.findAll();
    }

    public Nota get(Integer id){
        return notaRepository.findById(id).get();
    }

    public List<Nota> listByIdPaciente(Integer idPaciente){
        return notaRepository.findByIdPaciente(idPaciente);
    }

    public void save(Nota nota){
        notaRepository.save(nota);
    }

    public void delete(Integer id){
        notaRepository.deleteById(id); 
    } 

    
}