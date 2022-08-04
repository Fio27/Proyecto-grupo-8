/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Cine;
import com.proyecto.service.ICineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Golcher
 */
@Controller
public class CineController {

    @Autowired
    private ICineService cineService;

    @GetMapping("/cineAdmin")
    public String index(Model model) {
        List<Cine> listaCine = cineService.getAllCine();
        model.addAttribute("titulo", "Tabla Cine");
        model.addAttribute("cinedataset", listaCine);
        return "cine_Admin";
    }

    @GetMapping("/cineN")
    public String crearCine(Model model) {
        List<Cine> listaCine = cineService.getAllCine();
        model.addAttribute("cinedataset", new Cine());
        return "crear_Cine";
    }

    @PostMapping("/save")
    public String saveCine(@ModelAttribute Cine cine) {
        cineService.saveCine(cine);
        return "redirect:/cineAdmin";
    }

    @GetMapping("/editCine/{id}")
    public String editarCine(@PathVariable("id") Long id, Model model) {
        Cine cine = cineService.getCineById(id);
        List<Cine> listaCine = cineService.getAllCine();
        model.addAttribute("cinedataset", cine);
        return "crear_Cine";
    }

    @GetMapping("/delete/{id}") //eliminar elemento
    public String eliminarCine(@PathVariable("id") Long id) {
        cineService.delete(id);
        return "redirect:/cineAdmin";
    }

    @GetMapping("/cines")
    public String index2(Model model) {
        List<Cine> listaCine = cineService.getAllCine();
        model.addAttribute("titulo", "Tabla Cine");
        model.addAttribute("cinedataset", listaCine);
        return "cine";
    }
}
