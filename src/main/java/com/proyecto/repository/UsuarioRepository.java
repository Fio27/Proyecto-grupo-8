/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.repository;

import com.proyecto.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Golcher
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String nombreUsuario);            //Aqui indico que busque 
//Objeto persona + findBy"nombre de la columna que quiero buscar con inical mayusc."  + se le pasa el nombre o parámetro 
}
