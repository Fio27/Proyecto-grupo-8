/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto;

import com.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 
 * @author Golcher
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Da acceso a paginas deseadas por los roles de usuarios

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();               //objeto
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());                        //seteo la password
        daoAuthenticationProvider.setUserDetailsService(getUserService());                      //crear un nuevo objeto de userService
        return daoAuthenticationProvider;                                                       //lo devuelvo
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {                            //constructor
        this.userDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    //El siguiente método funciona para hacer la autentificación del usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http.authorizeRequests()
        .antMatchers("/persona", "/login")
        .hasRole ("ADMIN")
        .antMatchers("/personasN", "/persona", "/","/login") 
        .hasAnyRole("USER", "VENDEDOR", "ADMIN") 
        .anyRequest().authenticated() 
        .and() 
        .formLogin(); 
         */

        http.authorizeRequests()
                .antMatchers("/concierto", "/login")                                          //Permiso de poder ir a 
                .hasRole("ADMIN")                                                           //Si tiene el rol de "ADMIN"
                .antMatchers("/conciertoN", "/login", "/partido")                       //Quiero que pueda ir a "/home", "/".... 
                .hasAnyRole("USER", "ADMIN")                                    //Si tiene el rol de "USER"
                .anyRequest().authenticated()                                               
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/home", true);       //A cual ruta dirije el login y si es valido redirijalo a "/home".
    }
//E1 siguiente metodo funciona parsa realizar la autorización de accesos 
//i18n 
    
    

}