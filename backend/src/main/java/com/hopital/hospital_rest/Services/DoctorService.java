package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.DoctorRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> list(){
        return doctorRepository.findAll();
    }

    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor get(Integer id){
        return doctorRepository.findById(id).get();
    }

    public void delete(Integer id){
        doctorRepository.deleteById(id); 
    } 

    
}