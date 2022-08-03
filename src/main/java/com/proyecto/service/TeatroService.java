/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Teatro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.repository.TeatroRepository;

/**
 *
 * @author Golcher
 */
@Service
public class TeatroService implements ITeatroService {

    @Autowired
    private TeatroRepository teatroRepository;

    @Override
    public List<Teatro> getAllTeatro() {
        return (List<Teatro>) teatroRepository.findAll();
    }

    @Override
    public Teatro getTeatroById(long id) {
        return teatroRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTeatro(Teatro teatro) {
        teatroRepository.save(teatro);
    }

    @Override
    public void delete(long id) {
        teatroRepository.deleteById(id);
    }

}

