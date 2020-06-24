package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.DoctorEspecialidadRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.DoctorEspecialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorEspecialidadService {
    @Autowired
    private DoctorEspecialidadRepository doctorEspecialidadRepository;

    public List<DoctorEspecialidad> list(){
        return doctorEspecialidadRepository.findAll();
    }

    public void save(DoctorEspecialidad doctorEspecialidad){
        doctorEspecialidadRepository.save(doctorEspecialidad);
    }
    
    public DoctorEspecialidad get(Integer id){
        return doctorEspecialidadRepository.findById(id).get();
    }

    public void delete(Integer id){
        doctorEspecialidadRepository.deleteById(id); 
    } 
    
}