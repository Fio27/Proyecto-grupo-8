/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Compra;
import java.util.List;

/**
 *
 * @author Golcher
 */
public interface ICompraService {

    public List<Compra> getAllCompra();

    public Compra getCompraById(long id);

    public void saveCompra(Compra compra);

    public void delete(long id);
}
