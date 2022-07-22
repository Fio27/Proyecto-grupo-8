/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Cine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.repository.CineRepository;

/**
 *
 * @author Golcher
 */
@Service
public class CineService implements ICineService {

    @Autowired
    private CineRepository cineRepository;

    @Override
    public List<Cine> getAllCine() {
        return (List<Cine>) cineRepository.findAll();
    }

    @Override
    public Cine getCineById(long id) {
        return cineRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCine(Cine cine) {
        cineRepository.save(cine);
    }

    @Override
    public void delete(long id) {
        cineRepository.deleteById(id);
    }

}
