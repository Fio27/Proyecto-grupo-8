/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Partido;
import com.proyecto.service.IPartidoService;
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
public class PartidoController {

    @Autowired
    private IPartidoService partidoService;

    @GetMapping("/partidoAdmin")
    public String index(Model model) {
        List<Partido> listaPartido = partidoService.getAllPartido();
        model.addAttribute("titulo", "Tabla Partido");
        model.addAttribute("partidodataset", listaPartido);
        return "partido_Admin";
    }

    @GetMapping("/partidoN")
    public String crearPartido(Model model) {
        List<Partido> listaPartido = partidoService.getAllPartido();
        model.addAttribute("partidodataset", new Partido());
        return "crear_Partido";
    }

    @PostMapping("/savePartido")
    public String savePartido(@ModelAttribute Partido partido) {
        partidoService.savePartido(partido);
        return "redirect:/partidoAdmin";
    }

    @GetMapping("/editPartido/{id}")
    public String editarPartido(@PathVariable("id") Long id, Model model) {
        Partido partido = partidoService.getPartidoById(id);
        List<Partido> listaPartido = partidoService.getAllPartido();
        model.addAttribute("partidodataset", partido);
        return "crear_Partido";
    }

    @GetMapping("/deletePartido/{id}") //eliminar elemento
    public String eliminarPartido(@PathVariable("id") Long id) {
        partidoService.delete(id);
        return "redirect:/partidoAdmin";
    }

    @GetMapping("/partidos")
    public String index2(Model model) {
        List<Partido> listaPartido = partidoService.getAllPartido();
        model.addAttribute("titulo", "Tabla Partido");
        model.addAttribute("partidodataset", listaPartido);
        return "partidos";
    }
}
