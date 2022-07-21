/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Cine;
import java.util.List;

/**
 *
 * @author Golcher
 */
public interface ICineService {

    public List<Cine> getAllCine();

    public Cine getCineById(long id);

    public void saveCine(Cine cine);

    public void delete(long id);

}
