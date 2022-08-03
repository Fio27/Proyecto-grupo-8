/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Teatro;
import java.util.List;

/**
 *
 * @author Golcher
 */
public interface ITeatroService {

    public List<Teatro> getAllTeatro();

    public Teatro getTeatroById(long id);

    public void saveTeatro(Teatro teatro);

    public void delete(long id);

}