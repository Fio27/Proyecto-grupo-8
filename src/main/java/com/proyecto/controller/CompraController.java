/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.entity.Compra;
import com.proyecto.service.ICompraService;
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
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/compras")                         //  RESULTADO
    public String indexCompras(Model model) {
        List<Compra> listaCompra = compraService.getAllCompra();
        model.addAttribute("titulo", "Tabla Compra");
        model.addAttribute("compradataset", listaCompra);
        return "resultadocompra";
    }

    @GetMapping("/compraR")                                 //LLAMADO
    public String crearCompra(Model model) {
        List<Compra> listaCompra = compraService.getAllCompra();
        model.addAttribute("compradataset", new Compra());
        return "compra";
    }

    @PostMapping("/saveCompra")
    public String saveCompra(@ModelAttribute Compra compra) {
        compraService.saveCompra(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editCompra/{id}")
    public String editarCompra(@PathVariable("id") Long id, Model model) {
        Compra compra = compraService.getCompraById(id);
        List<Compra> listaCompra = compraService.getAllCompra();
        model.addAttribute("compradataset", compra);
        return "compraR";
    }

    @GetMapping("/deleteCompra/{id}") //eliminar elemento
    public String eliminarCompra(@PathVariable("id") Long id) {
        compraService.delete(id);
        return "redirect:/compras";
    }
}
