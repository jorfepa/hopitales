package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.EspecialidadRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Especialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> list(){
        return especialidadRepository.findAll();
    }

    public Especialidad get(Integer id){
        return especialidadRepository.findById(id).get();
    }

    public List<Especialidad> findByIdDoctor(Integer idDoctor){
        return especialidadRepository.findByIdDoctor(idDoctor);
    }

    public List<Especialidad> findNotInDoctor(Integer idDoctor){
        return especialidadRepository.findNotInDoctor(idDoctor);
    }

    public Especialidad save(Especialidad especialidad){
        return especialidadRepository.save(especialidad);
    }


    public void delete(Integer id){
        especialidadRepository.deleteById(id); 
    } 

    
}