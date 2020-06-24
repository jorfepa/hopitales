package com.hopital.hospital_rest.Services;

import com.hopital.hospital_rest.Repositories.HospitalRepository;

import java.util.List;

import com.hopital.hospital_rest.Entities.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> list(){
        return hospitalRepository.findAll();
    }

    public Hospital save(Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    public Hospital get(Integer id){
        return hospitalRepository.findById(id).get();
    }

    public void delete(Integer id){
        hospitalRepository.deleteById(id); 
    } 

    
}