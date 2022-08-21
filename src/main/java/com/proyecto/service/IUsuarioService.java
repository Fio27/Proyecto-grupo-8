/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Usuario;
import java.util.List;

/**
 *
 * @author Golcher
 */
public interface IUsuarioService {

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioById(long id);

    public void saveUsuario(Usuario usuario);

    public void delete(long id);

    public Usuario findByNombreUsuario(String nombreUsuario);
                 //Devolver una persona por el nombre 

}
