/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Teatro;
import com.proyecto.service.ITeatroService;
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
public class TeatroController {

    @Autowired
    private ITeatroService teatroService;

    @GetMapping("/teatroAdmin")  
    public String index(Model model) {
        List<Teatro> listaTeatro = teatroService.getAllTeatro();
        model.addAttribute("titulo", "Tabla Teatro");
        model.addAttribute("teatrodataset", listaTeatro);
        return "teatro_Admin";
    }

    @GetMapping("/teatroN")
    public String crearTeatro(Model model) {
        List<Teatro> listaTeatro = teatroService.getAllTeatro();
        model.addAttribute("teatrodataset", new Teatro());
        return "crear_Teatro";
    }

    @PostMapping("/saveTeatro")
    public String saveTeatro(@ModelAttribute Teatro teatro) {
        teatroService.saveTeatro(teatro);
        return "redirect:/teatroAdmin";
    }

    @GetMapping("/editTeatro/{id}") 
    public String editarTeatro(@PathVariable("id") Long id, Model model) {
        Teatro teatro = teatroService.getTeatroById(id);
        List<Teatro> listaTeatro = teatroService.getAllTeatro();
        model.addAttribute("teatrodataset", teatro);
        return "crear_Teatro";
    } 

    @GetMapping("/deleteTeatro/{id}") //eliminar elemento
    public String eliminarTeatro(@PathVariable("id") Long id) {
        teatroService.delete(id);
        return "redirect:/teatroAdmin";
    }
    
    @GetMapping("/teatro")  
    public String index2 (Model model) {
        List<Teatro> listaTeatro = teatroService.getAllTeatro();
        model.addAttribute("titulo", "Tabla Teatro");
        model.addAttribute("teatrodataset", listaTeatro);
        return "indexteatro";
    }
}
