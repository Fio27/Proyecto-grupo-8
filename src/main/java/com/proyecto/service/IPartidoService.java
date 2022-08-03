/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Partido;
import java.util.List;

/**
 *
 * @author Golcher
 */
public interface IPartidoService {

    public List<Partido> getAllPartido();

    public Partido getPartidoById(long id);

    public void savePartido(Partido partido);

    public void delete(long id);

}