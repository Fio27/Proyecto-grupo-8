/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template 
 */
package com.proyecto.service;

import com.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Golcher
 */

//UserDetails no seutiliza para el SpringSecurity y el UserDetailsService si lo utiliza.

@Service
public class UserService implements UserDetailsService { //UserService retorna el ususario, la contraseña y otros atributos de autenticación.
                                                         //Los obtenemos de la clase UserPrincipal.
    @Autowired
    public IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.findByNombreUsuario(username); //El objeto persona es el que encontremos en nuestra base de datos que coincida con el username
        UserPrincipal userprincipal = new UserPrincipal(usuario);   //Se crea un objeto de tipo userPrincipal donde se le pasa una persona de parámetro
        return userprincipal; //Y retornamos el userPrincipal (La clase que tiene toda la info encapsulada).
        //Encapsula toda la info y además se ve afectado por el Spring Security porque implementa UserDetailsService.
    }
}
