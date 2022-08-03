/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Partido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.repository.PartidoRepository;

/**
 *
 * @author Golcher
 */
@Service
public class PartidoService implements IPartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public List<Partido> getAllPartido() {
        return (List<Partido>) partidoRepository.findAll();
    }

    @Override
    public Partido getPartidoById(long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    @Override
    public void savePartido(Partido partido) {
        partidoRepository.save(partido);
    }

    @Override
    public void delete(long id) {
        partidoRepository.deleteById(id);
    }

}