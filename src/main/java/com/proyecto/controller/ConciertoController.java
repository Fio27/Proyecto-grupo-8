/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Concierto;
import com.proyecto.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/** 
 *
 * @author Golcher
 */
@Controller
public class ConciertoController {

    @Autowired
    private IConciertoService conciertoService;

    @GetMapping("/conciertoAdmin")  
    public String index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo", "Tabla Concierto");
        model.addAttribute("conciertodataset", listaConcierto);
        return "concierto_Admin";
    }

    @GetMapping("/conciertoN")
    public String crearConcierto(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("conciertodataset", new Concierto());
        return "crear_Concierto";
    }

    @PostMapping("/saveConcierto")
    public String saveConcierto(@ModelAttribute Concierto concierto) {
        conciertoService.saveConcierto(concierto);
        return "redirect:/conciertoAdmin";
    }

    @GetMapping("/editConcierto/{id}") 
    public String editarConcierto(@PathVariable("id") Long id, Model model) {
        Concierto concierto = conciertoService.getConciertoById(id);
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("conciertodataset", concierto);
        return "crear_Concierto";
    } 

    @GetMapping("/deleteConcierto/{id}") //eliminar elemento
    public String eliminarConcierto(@PathVariable("id") Long id) {
        conciertoService.delete(id);
        return "redirect:/conciertoAdmin";
    }
     
    @GetMapping("/conciertos")  
    public String index2 (Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo", "Tabla Concierto");
        model.addAttribute("conciertodataset", listaConcierto);
        return "conciertos";
    }
}