/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//************************Toda esta clase lo que hace es guardar toda la info del usuario: pass, nombre, permisos, roles, etc.***********************************

//La clase interface es la que indica que metodos deben implementarse pero no como se implementan
public class UserPrincipal implements UserDetails { //UserDetails guarda la información del usuario como tal para almacenar info o encapsular la info del usuario
                                                    //Esta info es referente a la seguridad: correo, contraseña, etc.
    private Usuario usuario; //Creamos el objeto persona. Este es el que almacena toda la info de la pass, username, permisos, roles, active, etc.
    //Y lo guardo en un UserPrincipal como abajo.

    //Cuando se instancia el objeto con el constructor le especificamos quien es la persona (atributo) al objeto de arriba.
    public UserPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();  //Se crea la lista. GrantedAuthority decide que permisos tiene un usuario hacer o no.
        //Extraxt list of permissions (name)
        this.usuario.getPermissionList().forEach(p -> {  //En el entity de persona creamos método getPermissionList(), por cada elemento de la lista permisos genera lo de abajo.
            GrantedAuthority authority = new SimpleGrantedAuthority(p); //Creo un nuevo objeto que le paso "p" que es cada elemento dentro de la lista
            authorities.add(authority);  //Y lo agrega a la lista de authorities creada en la linea 26.
        });
        // Extract list of roles (ROLE_name)
        this.usuario.getRoleList().forEach(r -> {  //Se busca en la lista de roles 
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r); //Se usa "ROLE_" para identificar que es un rol si no lo toma como permiso.
            authorities.add(authority); //Se agrega a la lista de authorities.
        });
        return authorities; //Y se devuelven.
    }

    @Override
    public String getPassword() {               
        return this.usuario.getPassword();
    }

    @Override
    public String getUsername() {           //El username a utilizar va a ser con el parámetro de nombre 
        return this.usuario.getNombreUsuario();
    }

    @Override
    public boolean isAccountNonExpired() { 
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {                //Retorna un true or false
        return this.usuario.getActive() == 1;
    }
}
