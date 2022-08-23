/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Compra;
import com.proyecto.repository.CompraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Golcher
 */
@Service
public class CompraService implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> getAllCompra() {
        return (List<Compra>) compraRepository.findAll();
    }

    @Override
    public Compra getCompraById(long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void delete(long id) {
        compraRepository.deleteById(id);
    }

}
